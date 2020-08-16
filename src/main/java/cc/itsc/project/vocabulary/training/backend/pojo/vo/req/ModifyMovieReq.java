package cc.itsc.project.vocabulary.training.backend.pojo.vo.req;

import cc.itsc.project.vocabulary.training.backend.pojo.vo.HttpRequset;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import java.util.List;

@ApiModel("修改电影详细信息")
public class ModifyMovieReq implements HttpRequset {

    @ApiModelProperty(value = "电影唯一ID")
    @Min(value = 1,message = "Movie ID 不能为空")
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
}
