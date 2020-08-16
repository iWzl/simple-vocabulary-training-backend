package cc.itsc.project.vocabulary.training.backend.dao;

import cc.itsc.project.vocabulary.training.backend.pojo.po.NewsPO;

import java.util.List;

public interface NewsDao {
    /**
     * delete by primary key
     * @param nid primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long nid);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(NewsPO record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(NewsPO record);

    /**
     * select by primary key
     * @param nid primary key
     * @return object by primary key
     */
    NewsPO selectByPrimaryKey(Long nid);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(NewsPO record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(NewsPO record);

    List<NewsPO> selectAllNews();
}