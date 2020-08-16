package cc.itsc.project.vocabulary.training.backend.service;

import cc.itsc.project.vocabulary.training.backend.pojo.vo.req.FeedbackReq;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.FeedbackRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.PageOfInfoListRsp;

/**
 * @author Leonardo iWzl
 * @version 1.0
 */
public interface FeedbackService {

    /**
     * 创建Feedback的信息数据
     *
     * @param feedbackReq 反馈信息请求
     */
    void insertNewFeedbackDetail(FeedbackReq feedbackReq);

    /**
     * 拉取分页拉取Feedback信息
     *
     * @param pageNo 页码数
     * @param pageSize 每页的大小
     * @return 查询到的News信息
     */
    PageOfInfoListRsp<FeedbackRsp> fetchPageOfFeedbackByPageInfo(Integer pageNo, Integer pageSize);

    /**
     * 删除Feedback信息
     *
     * @param fid NID
     */
    void deleteFeedbackByFid(Long fid);
}
