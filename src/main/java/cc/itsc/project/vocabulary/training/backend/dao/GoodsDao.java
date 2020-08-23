package cc.itsc.project.vocabulary.training.backend.dao;

import cc.itsc.project.vocabulary.training.backend.pojo.po.GoodsPO;

import java.util.List;

public interface GoodsDao {
    /**
     * delete by primary key
     * @param gid primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer gid);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(GoodsPO record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(GoodsPO record);

    /**
     * select by primary key
     * @param gid primary key
     * @return object by primary key
     */
    GoodsPO selectByPrimaryKey(Integer gid);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(GoodsPO record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(GoodsPO record);

    List<String> selectAllGoodsClassify();
}