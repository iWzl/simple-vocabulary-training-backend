package cc.itsc.project.vocabulary.training.backend.controller;

import cc.itsc.project.vocabulary.training.backend.annotation.Security;
import cc.itsc.project.vocabulary.training.backend.config.BackendProfileConfig;
import cc.itsc.project.vocabulary.training.backend.exception.AccountAlwaysExistException;
import cc.itsc.project.vocabulary.training.backend.exception.AccountNotFoundException;
import cc.itsc.project.vocabulary.training.backend.exception.AccountVerificationFailedException;
import cc.itsc.project.vocabulary.training.backend.pojo.enums.RoleEnum;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.common.ResultCodeEnum;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.common.ServiceResponseMessage;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.req.ModifyAccountPasswordReq;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.req.ModifyProfileReq;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.req.SignInReq;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.req.SignUpReq;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.DefaultHttpRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.PageOfInfoListRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.SignRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.UserProfileRsp;
import cc.itsc.project.vocabulary.training.backend.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

/**
 * @author Leonardo iWzl
 * @version 1.0
 */

@Api(tags = "账户模块")
@RestController
@RequestMapping(value = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Security(roles = RoleEnum.ALL, checkToken = false)
    @PostMapping(value = "/sign/in",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("#* 用户登录")
    public ServiceResponseMessage<SignRsp> signIn(@RequestBody @Validated SignInReq signInReq) {
        try {
            SignRsp signRsp = accountService.signIn(signInReq);
            if(null != signInReq){
                return ServiceResponseMessage.createBySuccessCodeMessage(signRsp);
            }else {
                return ServiceResponseMessage.createByFailCodeMessage(BackendProfileConfig.ERROR_WORDING_SIGN_IN_ERROR);
            }
        }catch (AccountNotFoundException accountNotFoundException){
            return ServiceResponseMessage.createByFailCodeMessage(ResultCodeEnum.NOT_FIND,BackendProfileConfig.ERROR_WORDING_SIGN_NOT_FOUND);
        }catch (AccountVerificationFailedException accountVerificationFailedException){
            return ServiceResponseMessage.createByFailCodeMessage(ResultCodeEnum.USERNAME_OR_PASSWORD_ERROR,BackendProfileConfig.ERROR_WORDING_SIGN_VERIFICATION_FAILED);
        }
    }

    @ApiOperation("#* 用户注册")
    @Security(roles = RoleEnum.ALL, checkToken = false)
    @PostMapping(value = "/sign/up", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceResponseMessage<SignRsp> signUp(@RequestBody @Validated SignUpReq signUpReq) {
        try {
            SignRsp signRsp = accountService.signUp(signUpReq);
            if(null != signRsp){
                return ServiceResponseMessage.createBySuccessCodeMessage(signRsp);
            }else {
                return ServiceResponseMessage.createByFailCodeMessage(BackendProfileConfig.ERROR_WORDING_SIGN_IN_ERROR);
            }
        }catch (AccountNotFoundException accountNotFoundException){
            return ServiceResponseMessage.createByFailCodeMessage(ResultCodeEnum.NOT_FIND,BackendProfileConfig.ERROR_WORDING_SIGN_NOT_FOUND);
        }catch (AccountVerificationFailedException accountVerificationFailedException){
            return ServiceResponseMessage.createByFailCodeMessage(ResultCodeEnum.USERNAME_OR_PASSWORD_ERROR,BackendProfileConfig.ERROR_WORDING_SIGN_VERIFICATION_FAILED);
        }catch (AccountAlwaysExistException accountAlwaysExistException){
            return ServiceResponseMessage.createByFailCodeMessage(ResultCodeEnum.ACCOUNT_ALWAYS_EXISTS,BackendProfileConfig.ERROR_WORDING_SIGN_ALWAYS_EXIST);
        }
    }

    @ApiOperation("#* 修改用户信息")
    @Security(roles = {RoleEnum.USER, RoleEnum.ADMIN})
    @PutMapping(value = "/profile", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceResponseMessage<UserProfileRsp> modifyProfile(@RequestBody @Validated ModifyProfileReq modifyProfileReq) {
        UserProfileRsp userProfileRsp = accountService.modifyProfile(modifyProfileReq);
        if(null != userProfileRsp){
            return ServiceResponseMessage.createBySuccessCodeMessage(BackendProfileConfig.SUCCESS_WORDING_MODIFY_SUCCESS,userProfileRsp);
        }else {
           return ServiceResponseMessage.createByFailCodeMessage(ResultCodeEnum.BAD_REQUEST,BackendProfileConfig.ERROR_WORDING_MODIFY_FAILED);
        }
    }

    @ApiOperation("#* 获取用户信息")
    @Security(roles = {RoleEnum.USER, RoleEnum.ADMIN})
    @GetMapping(value = "/profile", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParam(name = "uid",value = "用户Uid",example = "123456")
    public ServiceResponseMessage<UserProfileRsp> fetchProfileByUid(@RequestParam(value = "uid",required = false) Integer uid) {
        UserProfileRsp userProfileRsp = accountService.fetchUserProfileByUid(uid);
        if(null != userProfileRsp){
            return ServiceResponseMessage.createBySuccessCodeMessage(userProfileRsp);
        }else {
            return ServiceResponseMessage.createByFailCodeMessage(ResultCodeEnum.BAD_REQUEST,BackendProfileConfig.ERROR_WORDING_FETCH_FAILED);
        }
    }

    @ApiOperation("#* 修改用户密码")
    @Security(roles = {RoleEnum.ADMIN,RoleEnum.USER})
    @PutMapping(value = "/profile/password", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceResponseMessage<DefaultHttpRsp> modifyAccountPassword(@RequestBody @Validated ModifyAccountPasswordReq modifyAccountPasswordReq) {
        try {
            boolean isResetSuccess = accountService.modifyAccountPassword(modifyAccountPasswordReq);
            if (isResetSuccess) {
                return ServiceResponseMessage.createBySuccessCodeMessage(BackendProfileConfig.SUCCESS_WORDING_MODIFY_SUCCESS);
            } else {
                return ServiceResponseMessage.createByFailCodeMessage(ResultCodeEnum.BAD_REQUEST, BackendProfileConfig.ERROR_WORDING_MODIFY_FAILED);
            }
        } catch (AccountVerificationFailedException accountVerificationFailedException) {
            return ServiceResponseMessage.createByFailCodeMessage(ResultCodeEnum.USERNAME_OR_PASSWORD_ERROR, BackendProfileConfig.ERROR_WORDING_SIGN_VERIFICATION_FAILED);
        }
    }

    @ApiOperation("# 删除用户")
    @Security(roles = RoleEnum.ADMIN)
    @DeleteMapping(value = "/profile", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceResponseMessage<DefaultHttpRsp> deleteAccountProfile(@RequestParam(value = "uid") Integer uid) {
        boolean isDeleteSuccess = accountService.deleteAccountProfileByUid(uid);
        if (isDeleteSuccess) {
            return ServiceResponseMessage.createBySuccessCodeMessage(BackendProfileConfig.SUCCESS_WORDING_MODIFY_SUCCESS);
        } else {
            return ServiceResponseMessage.createByFailCodeMessage(ResultCodeEnum.BAD_REQUEST, BackendProfileConfig.ERROR_WORDING_MODIFY_FAILED);
        }
    }

    @Security(roles = RoleEnum.ADMIN)
    @ApiOperation("# 分页拉取用户Profile信息")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "pageNo",value = "页码数",example = "1"),
            @ApiImplicitParam(name = "pageSize",value = "页码大小",example = "20")
    })
    @GetMapping(value = "/profile/batch", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceResponseMessage<PageOfInfoListRsp<UserProfileRsp>> fetchPageOfUsersProfile(@Min(value = 1,message = "页码数最少为1")@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,
                                                                                             @Min (value = 1,message = "每页数量最小为1")@RequestParam(value = "pageSize",defaultValue = "20") Integer pageSize) {
        PageOfInfoListRsp<UserProfileRsp> pageOfUserProfileRsp = accountService.fetchPageOfUsersProfile(pageSize,pageNo);
        return ServiceResponseMessage.createBySuccessCodeMessage(pageOfUserProfileRsp);
    }
}
