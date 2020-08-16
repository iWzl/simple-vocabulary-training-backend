package cc.itsc.project.vocabulary.training.backend.pojo.vo.req;

import cc.itsc.project.vocabulary.training.backend.pojo.vo.HttpRequset;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Leonardo iWzl
 * @version 1.0
 */
@ApiModel(description = "用户登录")
public class SignInReq implements HttpRequset {
    @ApiModelProperty(value = "用户名",example = "Leonardo",required = true)
    @NotBlank(message = "用户名不能为空")
    private String account;

    @ApiModelProperty(value = "密码",example = "12345678",required = true)
    @NotBlank(message = "密码不能为空")
    @Size(min = 8,max = 16,message = "密码长度在8-16之间")
    private String password;

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
