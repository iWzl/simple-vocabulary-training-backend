package cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp;

import cc.itsc.project.vocabulary.training.backend.pojo.vo.HttpResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Leonardo iWzl
 * @version 1.0
 */
@ApiModel(description = "用户登录返回")
public class SignRsp implements HttpResponse {
    @ApiModelProperty(value = "用户UID",example = "123456",required = true)
    private Integer uid;
    @ApiModelProperty(value = "用户访问密钥",example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTYiLCJuYW1lIjoiSm9obiBEb2UifQ.blKTsRigVUP1pobSoNU0C6hP1tTZsYXrnvLxI8XsNZ4",required = true)
    private String token;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
