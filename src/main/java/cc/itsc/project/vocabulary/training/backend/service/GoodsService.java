package cc.itsc.project.vocabulary.training.backend.service;

import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.GoodsRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.PageOfInfoListRsp;

public interface GoodsService {
    PageOfInfoListRsp<GoodsRsp> fetchPageOfGoodsWithClassify(String classify, Integer pageNo, Integer pageSize);
}
