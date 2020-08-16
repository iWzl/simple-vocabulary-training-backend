package cc.itsc.project.vocabulary.training.backend.service.impl;

import cc.itsc.project.vocabulary.training.backend.config.BackendProfileConfig;
import cc.itsc.project.vocabulary.training.backend.dao.AccountDao;
import cc.itsc.project.vocabulary.training.backend.exception.AccountAlwaysExistException;
import cc.itsc.project.vocabulary.training.backend.exception.AccountNotFoundException;
import cc.itsc.project.vocabulary.training.backend.exception.AccountVerificationFailedException;
import cc.itsc.project.vocabulary.training.backend.pojo.enums.RoleEnum;
import cc.itsc.project.vocabulary.training.backend.pojo.po.AccountPO;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.req.ModifyAccountPasswordReq;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.req.ModifyProfileReq;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.req.SignInReq;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.req.SignUpReq;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.PageOfInfoListRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.SignRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.UserProfileRsp;
import cc.itsc.project.vocabulary.training.backend.service.AccountService;
import cc.itsc.project.vocabulary.training.backend.utils.AESUtil;
import cc.itsc.project.vocabulary.training.backend.utils.HttpUtil;
import cc.itsc.project.vocabulary.training.backend.utils.JWTUtil;
import cc.itsc.project.vocabulary.training.backend.utils.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Leonardo iWzl
 * @version 1.0
 */
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountDao accountDao;

    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public SignRsp signIn(SignInReq signInReq) {
        AccountPO accountInfo = accountDao.selectAccountInfoByAccount(signInReq.getAccount());
        if (null == accountInfo) {
            throw new AccountNotFoundException();
        }
        boolean isVerificationSuccess = accountInfo.getRole().equalsIgnoreCase(signInReq.getRole())
                && AESUtil.decryptAES(accountInfo.getSecretKey(),accountInfo.getPassword()).equals(signInReq.getPassword());
        if(!isVerificationSuccess){
            throw new AccountVerificationFailedException();
        }else {
            accountDao.refreshAccountLastLoginTime(accountInfo.getUid());
            SignRsp signRsp = new SignRsp();
            signRsp.setUid(accountInfo.getUid());
            signRsp.setToken(JWTUtil.createToken(accountInfo.getUid(),
                    RoleEnum.getRole(accountInfo.getRole()), accountInfo.getPassword()));
            return signRsp;
        }

    }

    @Override
    public SignRsp signUp(SignUpReq signUpReq) {
        AccountPO accountInfo = accountDao.selectAccountInfoByAccount(signUpReq.getAccount());
        if (accountInfo != null) {
            throw new AccountAlwaysExistException();
        } else {
            accountInfo = new AccountPO();
            BeanUtils.copyProperties(signUpReq, accountInfo);
            accountInfo.setCreateTime(System.currentTimeMillis());
            String secretKey = UUID.randomUUID().toString();
            accountInfo.setSecretKey(secretKey);
            accountInfo.setPassword(AESUtil.encryptAES(secretKey, signUpReq.getPassword()));
            if (accountDao.insertAccountDetail(accountInfo) == BackendProfileConfig.ROW_NUMBER_1) {
                SignInReq signInReq = new SignInReq();
                signInReq.setAccount(signUpReq.getAccount());
                signInReq.setPassword(signUpReq.getPassword());
                signInReq.setRole(signUpReq.getRole());
               return signIn(signInReq);
            } else {
                return null;
            }
        }
    }

    @Override
    public UserProfileRsp modifyProfile(ModifyProfileReq modifyProfileReq) {
        Integer uid = null;
        if (ObjectUtil.isNotEmpty(modifyProfileReq.getUid())) {
            uid = modifyProfileReq.getUid();
        } else {
            uid = HttpUtil.getUserUid();
        }

        AccountPO accountInfo = new AccountPO();
        BeanUtils.copyProperties(modifyProfileReq, accountInfo);
        accountInfo.setUid(uid);
        accountInfo.setUpdateTime(System.currentTimeMillis());
        if(accountDao.updateProfileAccountByUid(accountInfo) == BackendProfileConfig.ROW_NUMBER_1){
            return fetchUserProfileByUid(uid);
        }else {
            return null;
        }
    }

    @Override
    public UserProfileRsp fetchUserProfileByUid(Integer uid) {
        if (uid == null || 0 == uid) {
            uid = HttpUtil.getUserUid();
        }
        AccountPO accountInfo = accountDao.selectAccountInfoByUid(uid);
        if (null == accountInfo) {
            return null;
        } else {
            UserProfileRsp userProfileRsp = new UserProfileRsp();
            BeanUtils.copyProperties(accountInfo, userProfileRsp);
            userProfileRsp.setPassword(null);
            return userProfileRsp;
        }
    }

    @Override
    public boolean modifyAccountPassword(ModifyAccountPasswordReq modifyAccountPasswordReq) {
        boolean checkPassword = HttpUtil.getRole() == RoleEnum.USER;
        if(checkPassword){
            modifyAccountPasswordReq.setUid(HttpUtil.getUserUid());
        }
        if (ObjectUtil.isNotEmpty(modifyAccountPasswordReq.getUid())) {
            AccountPO accountInfo = accountDao.selectAccountInfoByUid(modifyAccountPasswordReq.getUid());
            if(checkPassword){
                if(!AESUtil.decryptAES(accountInfo.getSecretKey(),accountInfo.getPassword()).equals(modifyAccountPasswordReq.getOldPassword())){
                    throw new AccountVerificationFailedException();
                }
            }
            if (null != accountInfo) {
                String newPassword = AESUtil.encryptAES(accountInfo.getSecretKey(), modifyAccountPasswordReq.getPassword());
                accountDao.updateAccountPasswordByUid(modifyAccountPasswordReq.getUid(), newPassword);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteAccountProfileByUid(Integer uid) {
        int row = accountDao.deleteAccountProfileByUid(uid);
        return row == BackendProfileConfig.ROW_NUMBER_1;
    }

    @Override
    public PageOfInfoListRsp<UserProfileRsp> fetchPageOfUsersProfile(Integer pageSize, Integer pageNo) {
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<AccountPO> pageOfAccount = new PageInfo<>(accountDao.selectAllAccountInfo());
        PageOfInfoListRsp<UserProfileRsp> pageOfUserProfileRsp = new PageOfInfoListRsp<>();
        pageOfUserProfileRsp.setDataList(pageOfAccount.getList().stream().map((accountInfo->{
            UserProfileRsp userProfileRsp = new UserProfileRsp();
            BeanUtils.copyProperties(accountInfo, userProfileRsp);
            return userProfileRsp;
        })).collect(Collectors.toList()));
        BeanUtils.copyProperties(pageOfAccount, pageOfUserProfileRsp);
        return pageOfUserProfileRsp;
    }
}
