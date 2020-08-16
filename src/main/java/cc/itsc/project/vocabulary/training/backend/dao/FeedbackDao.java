package cc.itsc.project.vocabulary.training.backend.dao;

import cc.itsc.project.vocabulary.training.backend.pojo.po.FeedbackPO;

import java.util.List;

public interface FeedbackDao {
    /**
     * delete by primary key
     * @param fid primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long fid);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(FeedbackPO record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(FeedbackPO record);

    /**
     * select by primary key
     * @param fid primary key
     * @return object by primary key
     */
    FeedbackPO selectByPrimaryKey(Long fid);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(FeedbackPO record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(FeedbackPO record);

    List<FeedbackPO> selectAllFeedback();
}