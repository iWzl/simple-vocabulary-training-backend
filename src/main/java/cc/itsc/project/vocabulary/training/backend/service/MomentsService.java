package cc.itsc.project.vocabulary.training.backend.service;


import cc.itsc.project.vocabulary.training.backend.pojo.vo.req.MomentsReq;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.MomentsRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.PageOfInfoListRsp;
import org.apache.ibatis.annotations.Param;

/**
 * @author Leonardo iWzl
 * @version 1.0
 */
public interface MomentsService {
    /**
     * 添加新的电影信息请求
     *
     * @param momentsReq moments动态请求
     */
    void insertNewMomentsDetail(MomentsReq momentsReq);

    /**
     * 分页获取电影信息请求信息
     *
     * @param pageNo   分页页码
     * @param pageSize 每页的数量
     * @return 查询后的每页的影评信息, 带分页信息
     */
    PageOfInfoListRsp<MomentsRsp> fetchPageOfMomentsByPageInfo(Integer pageNo, Integer pageSize);

    /**
     * 分页待审核的Moments信息
     *
     * @param pageNo   分页页码
     * @param pageSize 每页的数量
     * @return 查询后的每页的影评信息, 带分页信息
     */
    PageOfInfoListRsp<MomentsRsp> fetchReviewPageOfMoments(Integer pageNo, Integer pageSize);


    /**
     * 根据MomentsId删除Id
     *
     * @param mid MomentsId
     */
    void deleteMomentsByMid(@Param("mid") Long mid);

    /**
     * @param pageNo   分页页码
     * @param pageSize 每页的数量
     * @return 查询后的每页的影评信息, 带分页信息
     */
    PageOfInfoListRsp<MomentsRsp> fetchPageOfMomentsByMe(Integer pageNo, Integer pageSize);

    void reviewPassPageOfMomentsByMid(Long mid);
}
