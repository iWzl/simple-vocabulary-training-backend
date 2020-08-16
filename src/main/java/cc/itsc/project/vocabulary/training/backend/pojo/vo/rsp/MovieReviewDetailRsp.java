package cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp;

import cc.itsc.project.vocabulary.training.backend.pojo.vo.HttpResponse;
import io.swagger.annotations.ApiModel;

@ApiModel
public class MovieReviewDetailRsp implements HttpResponse {
    private Long rid;

    private Long mid;

    private UserProfileRsp userProfileRsp;

    private String content;

    private Long reviewTime;

    private Integer status;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public UserProfileRsp getUserProfileRsp() {
        return userProfileRsp;
    }

    public void setUserProfileRsp(UserProfileRsp userProfileRsp) {
        this.userProfileRsp = userProfileRsp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Long reviewTime) {
        this.reviewTime = reviewTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
