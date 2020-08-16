package cc.itsc.project.vocabulary.training.backend.pojo.vo.req;

import cc.itsc.project.vocabulary.training.backend.pojo.vo.HttpRequset;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

@ApiModel("影圈创建请求")
public class MomentsReq implements HttpRequset {
    @Size(min = 1,message = "内容不能为空")
    @ApiModelProperty(value = "影圈内容",example = "我是文字，我是文字")
    private String content;

    @Size(min = 1,message = "内容不能为空")
    @ApiModelProperty(value = "携带的图片信息",example = "我是图片.jpg")
    private String image;

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
}
