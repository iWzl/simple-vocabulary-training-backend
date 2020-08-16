package cc.itsc.project.vocabulary.training.backend.controller;

import cc.itsc.project.vocabulary.training.backend.annotation.Security;
import cc.itsc.project.vocabulary.training.backend.pojo.enums.RoleEnum;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.common.ResultCodeEnum;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.common.ServiceResponseMessage;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.UploadImageRsp;
import cc.itsc.project.vocabulary.training.backend.service.CommonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

/**
 * @author Leonardo iWzl
 * @version 1.0
 */

@Api(tags = "工具支持模块")
@Controller
@RequestMapping("/tools")
public class CommonController {
    private final CommonService commonService;

    public CommonController(CommonService commonService) {
        this.commonService = commonService;
    }

    @ResponseBody
    @PostMapping(value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @Security(roles = RoleEnum.ALL,checkToken = false)
    @ApiOperation("#* 用户图片相关信息上传")
    public ServiceResponseMessage<UploadImageRsp> upload(@NotNull @RequestParam("imageFile") MultipartFile imageFile) {
        if (imageFile.isEmpty()) {
            ServiceResponseMessage.createByFailCodeMessage(ResultCodeEnum.IMAGE_IS_EMPTY, "图片不存在");
        }
        String imageFilePath =  commonService.uploadMultipartFile(imageFile);
        if(!"".equals(imageFilePath)){
            UploadImageRsp uploadImageRsp = new UploadImageRsp();
            uploadImageRsp.setImagePath(imageFilePath);
            return ServiceResponseMessage.createBySuccessCodeMessage("文件上传成功", uploadImageRsp);
        }else {
            return ServiceResponseMessage.createByFailCodeMessage("文件保存失败");
        }
    }
}
