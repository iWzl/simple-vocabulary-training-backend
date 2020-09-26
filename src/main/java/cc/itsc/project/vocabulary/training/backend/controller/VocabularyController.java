package cc.itsc.project.vocabulary.training.backend.controller;


import cc.itsc.project.vocabulary.training.backend.annotation.Security;
import cc.itsc.project.vocabulary.training.backend.pojo.enums.RoleEnum;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.common.ServiceResponseMessage;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.GoodsRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.PageOfInfoListRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.SentenceRsp;
import cc.itsc.project.vocabulary.training.backend.service.VocabularyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

/**
 * @author Leonardo iWzl
 * @version 1.0
 */

@Api(tags = "Vocabulary")
@RestController
@RequestMapping(value = "/sentence", produces = MediaType.APPLICATION_JSON_VALUE)
public class VocabularyController {
    private final VocabularyService vocabularyService;

    public VocabularyController(VocabularyService vocabularyService) {
        this.vocabularyService = vocabularyService;
    }

    @Security(roles = RoleEnum.ALL)
    @ApiOperation("# 听力板块")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "pageNo",value = "页码数",example = "1"),
            @ApiImplicitParam(name = "pageSize",value = "页码大小",example = "20")
    })
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceResponseMessage<PageOfInfoListRsp<SentenceRsp>> fetchPageOfListenSentencesWithClassify(@Min(value = 1,message = "页码数最少为1")@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,
                                                                                                         @Min (value = 1,message = "每页数量最小为1")@RequestParam(value = "pageSize",defaultValue = "20") Integer pageSize,
                                                                                                         @RequestParam(value = "classify",defaultValue = "1") String classify) {
        PageOfInfoListRsp<SentenceRsp> pageOfSentenceRsp = vocabularyService.fetchPageOfListenSentencesWithClassify(classify,pageNo,pageSize);
        return ServiceResponseMessage.createBySuccessCodeMessage(pageOfSentenceRsp);
    }


}
