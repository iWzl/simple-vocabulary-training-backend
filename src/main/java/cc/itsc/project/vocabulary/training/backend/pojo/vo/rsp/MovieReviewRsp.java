package cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("评论的请求返回")
public class MovieReviewRsp {
    @ApiModelProperty("影评ID")
    private Long rid;

    @ApiModelProperty("电影的详细信息")
    private MovieDetailRsp movieDetailRsp;

    @ApiModelProperty("用户的Profile属性信息")
    private UserProfileRsp userProfileRsp;

    @ApiModelProperty("影评的正文")
    private String content;

    @ApiModelProperty("评论时间")
    private Long reviewTime;

    @ApiModelProperty("评论的状态（忽略）")
    private Integer status;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public MovieDetailRsp getMovieDetailRsp() {
        return movieDetailRsp;
    }

    public void setMovieDetailRsp(MovieDetailRsp movieDetailRsp) {
        this.movieDetailRsp = movieDetailRsp;
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
