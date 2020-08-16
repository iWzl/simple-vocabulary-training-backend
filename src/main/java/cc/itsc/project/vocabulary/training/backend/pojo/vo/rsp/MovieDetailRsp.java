package cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp;

import cc.itsc.project.vocabulary.training.backend.pojo.vo.HttpResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class MovieDetailRsp implements HttpResponse {
    @ApiModelProperty(value = "电影唯一ID")
    private Long mid;
    /**
     * 电影名
     */
    @ApiModelProperty(value = "电影名")
    private String name;

    /**
     * 导演
     */
    @ApiModelProperty(value = "导演")
    private String director;

    /**
     * 编剧
     */
    @ApiModelProperty(value = "编剧")
    private String scriptWriter;

    /**
     * 主演
     */
    @ApiModelProperty(value = "主演")
    private String starring;

    /**
     * 上映时间
     */
    @ApiModelProperty(value = "上映时间")
    private String releaseTime;

    /**
     * 时长(min)
     */
    @ApiModelProperty(value = "时长(min)")
    private Integer duration;

    /**
     * 剧情简介
     */
    @ApiModelProperty(value = "剧情简介")
    private String introduction;

    /**
     * 海报URL
     */
    @ApiModelProperty(value = "海报URL")
    private String poster;

    @ApiModelProperty(value = "分类")
    private List<String> classifyList;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(value = "电影点评信息")
    private List<MovieReviewDetailRsp> movieReviewDetailRspList;

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getScriptWriter() {
        return scriptWriter;
    }

    public void setScriptWriter(String scriptWriter) {
        this.scriptWriter = scriptWriter;
    }

    public String getStarring() {
        return starring;
    }

    public void setStarring(String starring) {
        this.starring = starring;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public List<String> getClassifyList() {
        return classifyList;
    }

    public void setClassifyList(List<String> classifyList) {
        this.classifyList = classifyList;
    }

    public List<MovieReviewDetailRsp> getMovieReviewDetailRspList() {
        return movieReviewDetailRspList;
    }

    public void setMovieReviewDetailRspList(List<MovieReviewDetailRsp> movieReviewDetailRspList) {
        this.movieReviewDetailRspList = movieReviewDetailRspList;
    }
}
