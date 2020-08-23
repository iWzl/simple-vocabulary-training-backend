package cc.itsc.project.vocabulary.training.backend.service.impl;

import cc.itsc.project.vocabulary.training.backend.dao.GoodsDao;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.ClassifiesRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.GoodsRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.PageOfInfoListRsp;
import cc.itsc.project.vocabulary.training.backend.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    GoodsDao goodsDao;

    @Override
    public ClassifiesRsp fetchAllGoodsClassify() {
        List<String> classifyList = goodsDao.selectAllGoodsClassify();
        ClassifiesRsp classifiesRsp = new ClassifiesRsp();
        classifiesRsp.setClassifyList(classifyList);
        return classifiesRsp;
    }

    @Override
    public PageOfInfoListRsp<GoodsRsp> fetchPageOfGoodsWithClassify(String classify, Integer pageNo, Integer pageSize) {
        return null;
    }
}
