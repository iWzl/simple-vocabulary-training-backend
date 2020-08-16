package cc.itsc.project.vocabulary.training.backend.pojo.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "修改用户账户密码")
public class ModifyAccountPasswordReq {
    @ApiModelProperty(value = "用户Uid Admin必填 User不填",example = "123456")
    private Integer uid;
    @ApiModelProperty(value = "需要修改的用户密码",example = "123456")
    private String password;
    @ApiModelProperty(value = "用户原密码 User必填,Admin不填",example = "123456")
    private String oldPassword;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
}
