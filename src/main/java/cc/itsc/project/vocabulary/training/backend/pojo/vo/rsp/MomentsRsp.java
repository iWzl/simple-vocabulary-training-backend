package cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp;

import cc.itsc.project.vocabulary.training.backend.pojo.vo.HttpResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("影圈创建信息")
public class MomentsRsp implements HttpResponse {
    @ApiModelProperty(value = "momentsID",example = "1234")
    private Long mid;

    @ApiModelProperty(value = "发布用户uid",example = "123456")
    private Long uid;

    @ApiModelProperty(value = "影圈内容",example = "我是影圈内容")
    private String content;

    @ApiModelProperty(value = "影圈图片",example = "我是影圈图片.jpg")
    private String image;

    @ApiModelProperty(value = "审核状态",notes = "0-待审核 1-通过",example = "0")
    private Integer review;

    @ApiModelProperty(value = "创建时间",example = "1235654645345")
    private Long createTime;

    @ApiModelProperty(value = "更新时间",example = "342432542545432")
    private Long updateTime;

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getReview() {
        return review;
    }

    public void setReview(Integer review) {
        this.review = review;
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
}
