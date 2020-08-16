package cc.itsc.project.vocabulary.training.backend.service;

import cc.itsc.project.vocabulary.training.backend.pojo.vo.req.ModifyAccountPasswordReq;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.req.ModifyProfileReq;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.req.SignInReq;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.req.SignUpReq;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.PageOfInfoListRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.SignRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.UserProfileRsp;

/**
 * @author Leonardo iWzl
 * @version 1.0
 */
public interface AccountService {

    /**
     * 用户的登录请求
     *
     * @param signInReq 包含用户账号和用户密码
     * @return 登陆的返回结果
     */
    SignRsp signIn(SignInReq signInReq);

    /**
     * 用户的在注册接口
     *
     * @param signUpReq 注册需要的信息接口
     * @return 注册的登录结果
     */
    SignRsp signUp(SignUpReq signUpReq);

    /**
     * 修改用户Profile信息的结构
     *
     * @param modifyProfileReq 修改用户Profile信息
     * @return 修改用户Profile信息
     */
    UserProfileRsp modifyProfile(ModifyProfileReq modifyProfileReq);

    /**
     * 通过用户UID查询用户Profile信息
     *
     * @param uid 用户UID
     * @return 用户Profile的查询结果
     */
    UserProfileRsp fetchUserProfileByUid(Integer uid);


    /**
     * 修改用户的
     *
     * @param modifyAccountPasswordReq 修改用户密码
     * @return 密码修改的处理结果
     */
    boolean modifyAccountPassword(ModifyAccountPasswordReq modifyAccountPasswordReq);

    /**
     * 删除账号
     *
     * @param uid 用户uid
     * @return 返回用户账号删除的处理状态
     */
    boolean deleteAccountProfileByUid(Integer uid);

    /**
     *  分页获取所有的用户信息
     *
     * @param pageSize 分页大小
     * @param pageNo 页码数字
     * @return 查询到的分页数据结果
     */
    PageOfInfoListRsp<UserProfileRsp> fetchPageOfUsersProfile(Integer pageSize, Integer pageNo);
}
