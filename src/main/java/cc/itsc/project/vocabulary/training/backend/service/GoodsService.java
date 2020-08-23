package cc.itsc.project.vocabulary.training.backend.service;

import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.ClassifiesRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.GoodsRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.PageOfInfoListRsp;

public interface GoodsService {
    ClassifiesRsp fetchAllGoodsClassify();

    PageOfInfoListRsp<GoodsRsp> fetchPageOfGoodsWithClassify(String classify, Integer pageNo, Integer pageSize);
}
