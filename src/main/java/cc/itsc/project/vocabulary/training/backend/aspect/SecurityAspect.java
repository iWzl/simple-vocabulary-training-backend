package cc.itsc.project.vocabulary.training.backend.aspect;

import cc.itsc.project.vocabulary.training.backend.annotation.Security;
import cc.itsc.project.vocabulary.training.backend.pojo.enums.RoleEnum;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.common.ResultCodeEnum;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.common.ServiceResponseMessage;
import cc.itsc.project.vocabulary.training.backend.utils.HttpUtil;
import cc.itsc.project.vocabulary.training.backend.utils.JWTUtil;
import cc.itsc.project.vocabulary.training.backend.dao.AccountDao;
import cc.itsc.project.vocabulary.training.backend.pojo.po.AccountPO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * 安全拦截相关切面
 *
 * @author Leonardo iWzl
 **/
@Aspect
@Component
public class SecurityAspect {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    AccountDao accountDao;

    @Pointcut("execution(* cc.itsc.project.movie.review.backend.controller..*.*(..))")
    public void pointCut() {
    }


    @Around(value = "pointCut()&&@annotation(cc.itsc.project.vocabulary.training.backend.annotation.Security)")
    public Object roleAop(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 从原有的方法调用中获取用户安全拦截的注解
        Class<?> classTarget=proceedingJoinPoint.getTarget().getClass();
        Class<?>[] par=((MethodSignature) proceedingJoinPoint.getSignature()).getParameterTypes();
        String methodName=proceedingJoinPoint.getSignature().getName();
        Method objMethod=classTarget.getMethod(methodName, par);
        // 从方法中获取到注解 并判断注解中写的参数
        Security security = objMethod.getAnnotation(Security.class);
        // 判断方法需不需要判断token的正确性
        if (security.checkToken()) {
            // 获取用户的Token
            String token = HttpUtil.getUserToken();
            int uid = HttpUtil.getUserUid();
            if(null == token ||  "".equals(token) || uid == 0){
                // 获取用户的Token失败,返回提示用户需要首先登录
                return ServiceResponseMessage.createByFailCodeMessage(ResultCodeEnum.NOT_LOGIN, "请先登录");
            }
            log.debug("用户X-TOKEN >> uid:{} token:{}",uid,token);
            AccountPO accountInfo = accountDao.selectAccountInfoByUid(uid);
            // 检验用户是否存在
            if(null != accountInfo && null != accountInfo.getPassword()){
                // 判断用户的Token的正确性
                if(!JWTUtil.verify(token,accountInfo.getPassword())){
                    return ServiceResponseMessage.createByFailCodeMessage(ResultCodeEnum.ERROR_TOKEN, "TOKEN错误");
                }
                if(HttpUtil.getRole() != RoleEnum.getRole(accountInfo.getRole())){
                    return ServiceResponseMessage.createByFailCodeMessage(ResultCodeEnum.UNAUTHORIZED_CHANGE, "权限变更");
                }
            }else {
                // 用户不存在 返回用户不存在
                return ServiceResponseMessage.createByFailCodeMessage(ResultCodeEnum.ERROR_ACCOUNT, "用户不存在");
            }
        }
        // 获取用户权限身份
        RoleEnum[] roles = security.roles();
        if (roles.length > 0) {
            if (roles[0] == RoleEnum.ALL){
                // 安全限制标识是登录 直接返回原方法的调用
                return proceedingJoinPoint.proceed();
            }
            // 判断用户的身份是否能够访问当前方法
            for (RoleEnum role : roles) {
                if (role == HttpUtil.getRole()) {
                    // 校验成功 能够访问当前方法
                    return proceedingJoinPoint.proceed();
                }
            }
        }
        // 所有的校验完成 用户没有访问的权限的匹配 直接返回
        return ServiceResponseMessage.createByFailCodeMessage(ResultCodeEnum.UNAUTHORIZED, "没有权限");
    }
}
