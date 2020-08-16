package cc.itsc.project.vocabulary.training.backend.dao;

import cc.itsc.project.vocabulary.training.backend.pojo.po.AccountPO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Leonardo iWzl
 * @version 1.0
 */

@Mapper
public interface AccountDao {

    /**
     * 查询用户的信息 根据用户UID
     *
     * @param uid 用户UID
     * @return 查询到的用户信息
     */
    AccountPO selectAccountInfoByUid(@Param("uid") Integer uid);

    /**
     * 根据用户唯一账户名登录和密码查询用户
     *
     * @param account 用户唯一账户
     * @return 查询到的用户信息
     */
    AccountPO selectAccountInfoByAccount(@Param("account") String account);

    /**
     * 插入新的accountInfo
     *
     * @param accountInfo 用户Account Info
     * @return 受影响的行数
     */
    int insertAccountDetail(@Param("accountInfo") AccountPO accountInfo);

    /**
     * 更新用户头像
     *
     * @param avatar 用户头像
     * @param uid    用户UID
     */

    @Update("update lana_account set avatar = #{avatar} where uid = #{uid}")
    void updateProfileAvatarByUid(@Param("avatar") String avatar, @Param("uid") Integer uid);

    /**
     * 修改NikeName名字
     *
     * @param nikeName 用户昵称
     * @param uid      用户uid
     */
    @Update("update lana_account set nike_name = #{nikeName} where uid = #{uid}")
    void updateProfileNikeNameByUid(@Param("nikeName") String nikeName, @Param("uid") Integer uid);


    /**
     * 根据用户uid修改用户签名
     *
     * @param signature 用户个性签名
     * @param uid       用户UID
     */
    @Update("update lana_account set `signature` = #{signature} where uid = #{uid}")
    void updateProfileSignatureByUid(@Param("signature") String signature, @Param("uid") Integer uid);

    /**
     * 根据用户uid修改用户生日
     *
     * @param birthday 用户生日的时间戳
     * @param uid      用户UID
     */
    @Update("update lana_account set birthday = #{birthday} where uid = #{uid}")
    void updateProfileBirthdayByUid(@Param("birthday") Long birthday, @Param("uid") Integer uid);

    /**
     * 查询说有的Account信息
     *
     * @return 查询到的Account信息结果
     */
    List<AccountPO> selectAllAccountInfo();

    /**
     * 通过用户Uid更新用户身份权限
     *
     * @param uid  用户Uid
     * @param role 用户身份权限
     */
    @Update("update lana_account set role = #{role} where uid = #{uid}")
    void updateProfileRoleByAccountUid(@Param("uid") int uid, @Param("role") String role);

    /**
     * 删除用户账号信息
     *
     * @param uid 用户uid
     */
    int deleteAccountProfileByUid(@Param("uid") Integer uid);

    /**
     * 更新用户密码
     *
     * @param uid      用户uid
     * @param password 用户密码
     */
    void updateAccountPasswordByUid(@Param("uid") Integer uid, @Param("password") String password);

    /**
     * 更新用户状态信息
     *
     * @param accountInfo 用户信息
     * @return 查询完成的处理结果
     */
    int updateProfileAccountByUid(@Param("accountInfo") AccountPO accountInfo);


    void refreshAccountLastLoginTime(@Param("uid") Integer uid);
}
