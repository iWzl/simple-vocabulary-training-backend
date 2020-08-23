package cc.itsc.project.vocabulary.training.backend.controller;


import cc.itsc.project.vocabulary.training.backend.annotation.Security;
import cc.itsc.project.vocabulary.training.backend.pojo.enums.RoleEnum;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.common.ServiceResponseMessage;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.ClassifiesRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.GoodsRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.PageOfInfoListRsp;
import cc.itsc.project.vocabulary.training.backend.service.GoodsService;
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

@Api(tags = "周边商品")
@RestController
@RequestMapping(value = "/goods", produces = MediaType.APPLICATION_JSON_VALUE)
public class GoodsController {

    private final GoodsService goodsService;

    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @Security(roles = RoleEnum.USER)
    @GetMapping(value = "/classify",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("#* 创建Feedback")
    public ServiceResponseMessage<ClassifiesRsp> fetchAllGoodsClassify() {
        ClassifiesRsp classifiesRsp = goodsService.fetchAllGoodsClassify();
        return ServiceResponseMessage.createBySuccessCodeMessage(classifiesRsp);
    }

    @Security(roles = RoleEnum.ALL)
    @ApiOperation("# 分页拉取Goods信息")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "pageNo",value = "页码数",example = "1"),
            @ApiImplicitParam(name = "pageSize",value = "页码大小",example = "20")
    })
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceResponseMessage<PageOfInfoListRsp<GoodsRsp>> fetchPageOfGoodsWithClassify(@Min(value = 1,message = "页码数最少为1")@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,
                                                                                            @Min (value = 1,message = "每页数量最小为1")@RequestParam(value = "pageSize",defaultValue = "20") Integer pageSize,
                                                                                            @RequestParam(value = "pageNo",defaultValue = "1") String classify) {
        PageOfInfoListRsp<GoodsRsp> pageOfMomentsRep = goodsService.fetchPageOfGoodsWithClassify(classify,pageNo,pageSize);
        return ServiceResponseMessage.createBySuccessCodeMessage(pageOfMomentsRep);
    }



}
