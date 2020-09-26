package cc.itsc.project.vocabulary.training.backend.service.impl;

import cc.itsc.project.vocabulary.training.backend.dao.GoodsDao;
import cc.itsc.project.vocabulary.training.backend.pojo.po.GoodsPO;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.GoodsRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.PageOfInfoListRsp;
import cc.itsc.project.vocabulary.training.backend.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    GoodsDao goodsDao;


    @Override
    public PageOfInfoListRsp<GoodsRsp> fetchPageOfGoodsWithClassify(String classify, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<GoodsPO> goodsList = goodsDao.selectPageOfGoodsWithClassify(classify);
        PageInfo<GoodsPO> goodsPageInfo= new PageInfo<>(goodsList);
        PageOfInfoListRsp<GoodsRsp> pageOfGoodsRsp = new PageOfInfoListRsp<>();
        pageOfGoodsRsp.setDataList(goodsPageInfo.getList().stream().map((good->{
            GoodsRsp goodsRsp = new GoodsRsp();
            BeanUtils.copyProperties(good, goodsRsp);
            return goodsRsp;
        })).collect(Collectors.toList()));
        BeanUtils.copyProperties(goodsPageInfo, pageOfGoodsRsp);
        return pageOfGoodsRsp;
    }
}
