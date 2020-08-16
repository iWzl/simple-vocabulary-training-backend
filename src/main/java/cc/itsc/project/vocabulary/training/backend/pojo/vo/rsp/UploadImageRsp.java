package cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp;

import cc.itsc.project.vocabulary.training.backend.pojo.vo.HttpResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Leonardo iWzl
 * @version 1.0
 */

@ApiModel(description = "图片上传后的正常回包返回")
public class UploadImageRsp implements HttpResponse {
    @ApiModelProperty(value = "图片上传后的图片名称",example = "uuid_image_image_name.jpg")
    private String imagePath;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
