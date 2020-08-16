package cc.itsc.project.vocabulary.training.backend.annotation;


import cc.itsc.project.vocabulary.training.backend.pojo.enums.RoleEnum;

import java.lang.annotation.*;

/**
 * 用户安全权限相关配置
 * 用户标识是否需要安全校验和相关配置操作
 *
 * @author Leonardo iWzl
 **/
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Security {
    // 用户所拥有的权限身份
    RoleEnum[] roles() default {};
    // 标识用户是否需要判断Token
    boolean checkToken() default true;
}
