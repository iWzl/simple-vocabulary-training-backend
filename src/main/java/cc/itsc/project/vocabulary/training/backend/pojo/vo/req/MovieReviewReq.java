package cc.itsc.project.vocabulary.training.backend.pojo.vo.req;

import cc.itsc.project.vocabulary.training.backend.pojo.vo.HttpRequset;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@ApiModel(description = "添加电影影评")
public class MovieReviewReq implements HttpRequset {
    @ApiModelProperty(value = "需要评论的电影MID",example = "123456")
    @Min(value = 1,message = "电影评论的ID唯一且不能为空")
    private Long mid;

    @ApiModelProperty(value = "电影评论的内容",example = "在香港美丽的圣约翰大教堂出席跨年感恩崇拜，有一披头散发的流浪汉就坐在我附近。12点跨年的那一刻，大家彼此握手祝贺，外星男提醒我必须过去跟流浪汉握手。其实，踏进教堂见到流浪汉的那一刻，已经告诉自己当晚必须鼓起勇气和他握手。当我的手握住他的手时，感觉很奇妙，温暖、平安喜乐。")
    @Size(min = 1,max = 1024,message = "电影评论内容在1-1024之间")
    private String content;

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
