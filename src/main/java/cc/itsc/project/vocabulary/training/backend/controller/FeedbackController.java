package cc.itsc.project.vocabulary.training.backend.controller;

import cc.itsc.project.vocabulary.training.backend.annotation.Security;
import cc.itsc.project.vocabulary.training.backend.pojo.enums.RoleEnum;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.common.ServiceResponseMessage;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.req.FeedbackReq;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.DefaultHttpRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.FeedbackRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.PageOfInfoListRsp;
import cc.itsc.project.vocabulary.training.backend.service.FeedbackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

/**
 * @author Leonardo iWzl
 * @version 1.0
 */

@Api(tags = "反馈模块")
@RestController
@RequestMapping(value = "/feedback", produces = MediaType.APPLICATION_JSON_VALUE)
public class FeedbackController {
    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @Security(roles = RoleEnum.USER)
    @PostMapping(value = "",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("#* 创建Feedback")
    public ServiceResponseMessage<DefaultHttpRsp> insertNewFeedbackDetail(@RequestBody @Validated FeedbackReq feedbackReq) {
        feedbackService.insertNewFeedbackDetail(feedbackReq);
       return ServiceResponseMessage.createBySuccessCodeMessage();
    }


    @Security(roles = RoleEnum.ADMIN)
    @ApiOperation("# 分页拉取Feedback信息")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "pageNo",value = "页码数",example = "1"),
            @ApiImplicitParam(name = "pageSize",value = "页码大小",example = "20")
    })
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceResponseMessage<PageOfInfoListRsp<FeedbackRsp>> fetchPageOfFeedback(@Min(value = 1,message = "页码数最少为1")@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,
                                                                                      @Min (value = 1,message = "每页数量最小为1")@RequestParam(value = "pageSize",defaultValue = "20") Integer pageSize) {
        PageOfInfoListRsp<FeedbackRsp> pageOfFeedbacksRep = feedbackService.fetchPageOfFeedbackByPageInfo(pageNo,pageSize);
        return ServiceResponseMessage.createBySuccessCodeMessage(pageOfFeedbacksRep);
    }


    @ApiOperation("# 删除Feedback")
    @Security(roles = RoleEnum.ADMIN)
    @DeleteMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceResponseMessage<DefaultHttpRsp> deleteFeedbackByFid(@Min (value = 0,message = "NewId不能为空") @RequestParam(value = "fid") Long fid) {
        feedbackService.deleteFeedbackByFid(fid);
        return ServiceResponseMessage.createBySuccessCodeMessage();
    }
}
