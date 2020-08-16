package cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp;

import cc.itsc.project.vocabulary.training.backend.pojo.vo.HttpResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Leo Wang
 * @version 1.0
 */

@ApiModel("用户Profile信息")
public class UserProfileRsp implements HttpResponse {
    @ApiModelProperty(value = "用户唯一标示Uid",example = "100000",required = true)
    private Integer uid;
    @ApiModelProperty(value = "用户登录账号",example = "Leonardo",required = true)
    private String account;
    @ApiModelProperty(value = "用户生日时间戳",example = "1595586247000",required = true)
    private Long birthday;
    @ApiModelProperty(value = "用户昵称",example = "Leonardo Da",required = true)
    private String nikeName;
    @ApiModelProperty(value = "用户性别",example = "F",required = true)
    private String gender;
    @ApiModelProperty(value = "用户签名",example = "好雨知时节，当春乃发生。 随风潜入夜，润物细无声。",required = true)
    private String signature;
    @ApiModelProperty(value = "用户头像",example = "https://w.wallhaven.cc/full/83/wallhaven-83ylm2.jpg",required = true)
    private String avatar;
    @ApiModelProperty(value = "用户背景",example = "https://w.wallhaven.cc/full/ym/wallhaven-ympzzl.jpg",required = true)
    private String background;
    @ApiModelProperty(value = "用户状态",example = "0",required = true)
    private Integer status;
    @ApiModelProperty(value = "用户账号的创建时间",example = "1595586247000",required = true)
    private Long createTime;
    @ApiModelProperty(value = "用户账号的更新时间",example = "1595586247000",required = true)
    private Long updateTime;
    @ApiModelProperty(value = "用户的角色",example = "Admin",required = true)
    private String role;
    @ApiModelProperty(value = "上次登录时间",example = "1595586247000",required = true)
    private Long lastLoginTime;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(hidden = true)
    private String password = null;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
