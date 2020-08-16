package cc.itsc.project.vocabulary.training.backend.service.impl;

import cc.itsc.project.vocabulary.training.backend.dao.FeedbackDao;
import cc.itsc.project.vocabulary.training.backend.pojo.po.FeedbackPO;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.req.FeedbackReq;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.FeedbackRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.PageOfInfoListRsp;
import cc.itsc.project.vocabulary.training.backend.service.FeedbackService;
import cc.itsc.project.vocabulary.training.backend.utils.HttpUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.stream.Collectors;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Resource
    private FeedbackDao feedbackDao;

    @Override
    public void insertNewFeedbackDetail(FeedbackReq feedbackReq) {
        FeedbackPO feedbackDetail  = new FeedbackPO();
        feedbackDetail.setContent(feedbackReq.getContent());
        feedbackDetail.setUid(Long.valueOf(HttpUtil.getUserUid()));
        feedbackDetail.setCreateTime(System.currentTimeMillis());
        feedbackDetail.setStatus(0);
        feedbackDao.insertSelective(feedbackDetail);
    }

    @Override
    public PageOfInfoListRsp<FeedbackRsp> fetchPageOfFeedbackByPageInfo(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<FeedbackPO> pageOfNews = new PageInfo<>(feedbackDao.selectAllFeedback());
        PageOfInfoListRsp<FeedbackRsp> pageOfNewsRsp = new PageOfInfoListRsp<>();
        pageOfNewsRsp.setDataList(pageOfNews.getList().stream().map((feedback->{
            FeedbackRsp feedbackRsp = new FeedbackRsp();
            BeanUtils.copyProperties(feedback, feedbackRsp);
            return feedbackRsp;
        })).collect(Collectors.toList()));
        BeanUtils.copyProperties(pageOfNews, pageOfNewsRsp);
        return pageOfNewsRsp;
    }

    @Override
    public void deleteFeedbackByFid(Long fid) {
        feedbackDao.deleteByPrimaryKey(fid);
    }
}
