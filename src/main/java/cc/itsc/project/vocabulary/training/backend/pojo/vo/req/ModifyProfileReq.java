package cc.itsc.project.vocabulary.training.backend.pojo.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Leonardo iWzl
 * @version 1.0
 */

@ApiModel(description = "修改用户的Profile信息")
public class ModifyProfileReq {
    @ApiModelProperty(value = "需要修改的UIN,Admin必填,User不填",example = "123456")
    private Integer uid;

    @ApiModelProperty(value = "生日",example = "12495739223")
    private Long birthday;

    @ApiModelProperty(value = "用户签名",example = "123456")
    private String signature;

    @ApiModelProperty(value = "背景信息",example = "https://w.wallhaven.cc/full/39/wallhaven-391dxy.jpg")
    private String background;

    @ApiModelProperty(value = "昵称(显示)",example = "Leonardo DiCaprio")
    private String nikeName;

    @ApiModelProperty(value = "用户性别",example = "M")
    private String gender;

    @ApiModelProperty(value = "头像",example = "https://w.wallhaven.cc/full/39/wallhaven-39pw6v.jpg")
    private String avatar;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
