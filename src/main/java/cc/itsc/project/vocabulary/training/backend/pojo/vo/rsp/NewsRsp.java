package cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp;

import cc.itsc.project.vocabulary.training.backend.pojo.vo.HttpResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("影圈创建信息")
public class NewsRsp implements HttpResponse {
    @ApiModelProperty(value = "nid",example = "1234")
    private Long nid;

    @ApiModelProperty(value = "发布用户uid",example = "123456")
    private Long uid;

    @ApiModelProperty(value = "公告内容",example = "我是公告内容")
    private String content;

    @ApiModelProperty(value = "创建时间",example = "1235654645345")
    private Long createTime;

    public Long getNid() {
        return nid;
    }

    public void setNid(Long nid) {
        this.nid = nid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

}
