package cc.itsc.project.vocabulary.training.backend.dao;

import cc.itsc.project.vocabulary.training.backend.pojo.po.GoodsPO;

import java.util.List;

public interface GoodsDao {
    List<GoodsPO> selectPageOfGoodsWithClassify(String classify);
}