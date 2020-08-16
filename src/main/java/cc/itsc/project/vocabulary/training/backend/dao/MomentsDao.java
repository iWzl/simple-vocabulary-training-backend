package cc.itsc.project.vocabulary.training.backend.dao;

import cc.itsc.project.vocabulary.training.backend.pojo.po.MomentsPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MomentsDao {
    /**
     * delete by primary key
     *
     * @param mid primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long mid);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(MomentsPO record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(MomentsPO record);

    /**
     * select by primary key
     *
     * @param mid primary key
     * @return object by primary key
     */
    MomentsPO selectByPrimaryKey(Long mid);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(MomentsPO record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MomentsPO record);

    /**
     * 查询可用的Moments信息
     *
     * @param userUid 用户Uid
     * @return 查询到的Moment信息列表
     */
    List<MomentsPO> selectAllEnableMomentsByUin(@Param("userUid") Integer userUid);

    /**
     * 查询可用的Moments信息
     *
     * @return 查询到的Moment信息列表
     */
    List<MomentsPO> selectReviewMoments();

    /**
     * 查询自己的Moments信息
     *
     * @param userUid 用户Uid
     * @return 查询到的Moment信息列表
     */
    List<MomentsPO> selectByUid(Integer userUid);

    void updateReviewStatusByMid(@Param("mid") Long mid);
}