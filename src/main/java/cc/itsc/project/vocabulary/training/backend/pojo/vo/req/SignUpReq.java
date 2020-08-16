package cc.itsc.project.vocabulary.training.backend.pojo.vo.req;

import cc.itsc.project.vocabulary.training.backend.pojo.vo.HttpRequset;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Leonardo iWzl
 * @version 1.0
 */

@ApiModel(description = "用户注册属性")
public class SignUpReq implements HttpRequset {
    @ApiModelProperty(value = "用户名(登录)",example = "Leonardo",required = true)
    @Size(min = 4,max = 16,message = "用户名最小长度最小为4最大为16")
    private String account;

    @ApiModelProperty(value = "用户密码",example = "12345678",required = true)
    @Size(min = 8,max = 16,message = "密码最小长度最小为8最大为16")
    private String password;

    @ApiModelProperty(value = "昵称(显示)",example = "Leonardo DiCaprio",required = true)
    @Size(min = 4,max = 20,message = "昵称最小长度最小为4最大为20")
    private String nikeName;

    @ApiModelProperty(value = "用户性别",example = "M",required = true)
    @Size(min = 1,max = 1,message = "用户性别为M｜F")
    @Pattern(regexp = "[MF]",message ="用户性别为M或F")
    private String gender;

    @ApiModelProperty(value = "头像",example = "https://w.wallhaven.cc/full/39/wallhaven-39pw6v.jpg",required = true)
    @Size(min = 4,message = "用户头像不能为空")
    private String avatar;

    @ApiModelProperty(value = "用户角色",example = "Admin/User",required = true)
    @Size(min = 4,max = 5,message = "用户角色为Admin/User")
    @Pattern(regexp = "Admin|User",message ="用户角色为Admin/User")
    private String role;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
