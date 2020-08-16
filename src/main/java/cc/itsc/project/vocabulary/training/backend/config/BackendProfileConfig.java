package cc.itsc.project.vocabulary.training.backend.config;

import org.springframework.stereotype.Component;

@Component
public class BackendProfileConfig {
    public static final Integer ROW_NUMBER_1 = 1;
    public static final String  ERROR_WORDING_SIGN_IN_ERROR = "登录失败";
    public static final String  ERROR_WORDING_SIGN_NOT_FOUND = "账户未存在";
    public static final String  ERROR_WORDING_SIGN_ALWAYS_EXIST = "账户已存在";
    public static final String  ERROR_WORDING_SIGN_VERIFICATION_FAILED = "验证错误";
    public static final String  SUCCESS_WORDING_MODIFY_SUCCESS = "修改成功";
    public static final String ERROR_WORDING_MODIFY_FAILED = "修改失败";
    public static final String  ERROR_WORDING_FETCH_FAILED = "拉取失败";
}
