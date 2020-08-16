package cc.itsc.project.vocabulary.training.backend.pojo.po;

public class MoviePO {
    /**
    * 电影的唯一标示符号
    */
    private Long mid;

    /**
    * 电影名
    */
    private String name;

    /**
    * 导演
    */
    private String director;

    /**
    * 编剧
    */
    private String scriptWriter;

    /**
    * 主演
    */
    private String starring;

    /**
    * 上映时间
    */
    private String releaseTime;

    /**
    * 时长(min)
    */
    private Integer duration;

    /**
    * 剧情简介
    */
    private String introduction;

    /**
    * 海报URL
    */
    private String poster;

    /**
    * 状态
    */
    private Integer status;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}