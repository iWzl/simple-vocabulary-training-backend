package cc.itsc.project.vocabulary.training.backend.pojo.vo.req;

import cc.itsc.project.vocabulary.training.backend.pojo.vo.HttpRequset;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@ApiModel("电影详细信息")
public class MovieDetailReq implements HttpRequset {
    /**
     * 电影名
     */
    @ApiModelProperty(value = "电影名")
    @NotBlank(message = "电影名不能为空")
    private String name;

    /**
     * 导演
     */
    @ApiModelProperty(value = "导演")
    @NotBlank(message = "导演不能为空")
    private String director;

    /**
     * 编剧
     */
    @ApiModelProperty(value = "编剧")
    @NotBlank(message = "编剧不能为空")
    private String scriptWriter;

    /**
     * 主演
     */
    @ApiModelProperty(value = "主演")
    @NotBlank(message = "主演不能为空")
    private String starring;

    /**
     * 上映时间
     */
    @ApiModelProperty(value = "上映时间")
    @NotBlank(message = "上映时间不能为空")
    private String releaseTime;

    /**
     * 时长(min)
     */
    @ApiModelProperty(value = "时长(min)")
    @Min(value = 1,message = "时长(min)不能为空")
    private Integer duration;

    /**
     * 剧情简介
     */
    @ApiModelProperty(value = "剧情简介")
    @NotBlank(message = "剧情简介不能为空")
    private String introduction;

    /**
     * 海报URL
     */
    @ApiModelProperty(value = "海报URL")
    @NotBlank(message = "海报URL不能为空")
    private String poster;

    @ApiModelProperty(value = "分类")
    @NotNull(message = "分类不能为空")
    private List<String> classifyList;


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
