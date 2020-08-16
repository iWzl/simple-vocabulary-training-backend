package cc.itsc.project.vocabulary.training.backend.service.impl;

import cc.itsc.project.vocabulary.training.backend.dao.MomentsDao;
import cc.itsc.project.vocabulary.training.backend.pojo.po.MomentsPO;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.req.MomentsReq;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.MomentsRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.PageOfInfoListRsp;
import cc.itsc.project.vocabulary.training.backend.service.MomentsService;
import cc.itsc.project.vocabulary.training.backend.utils.HttpUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.stream.Collectors;

@Service
public class MomentsServiceImpl implements MomentsService {
    @Resource
    private MomentsDao momentsDao;

    @Override
    public void insertNewMomentsDetail(MomentsReq momentsReq) {
        MomentsPO momentDetail = new MomentsPO();
        momentDetail.setUid(Long.valueOf(HttpUtil.getUserUid()));
        momentDetail.setContent(momentsReq.getContent());
        momentDetail.setCreateTime(System.currentTimeMillis());
        momentDetail.setUpdateTime(System.currentTimeMillis());
        momentDetail.setReview(0);
        momentDetail.setImage(momentsReq.getImage());
        momentsDao.insertSelective(momentDetail);
    }

    @Override
    public PageOfInfoListRsp<MomentsRsp> fetchPageOfMomentsByPageInfo(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<MomentsPO> pageOfMoments = new PageInfo<>(momentsDao.selectAllEnableMomentsByUin(HttpUtil.getUserUid()));
        return coverToPageOfMomentRsp(pageOfMoments);
    }

    @Override
    public PageOfInfoListRsp<MomentsRsp> fetchReviewPageOfMoments(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<MomentsPO> pageOfMoments = new PageInfo<>(momentsDao.selectReviewMoments());
        return coverToPageOfMomentRsp(pageOfMoments);
    }

    @Override
    public PageOfInfoListRsp<MomentsRsp> fetchPageOfMomentsByMe(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<MomentsPO> pageOfMoments = new PageInfo<>(momentsDao.selectByUid(HttpUtil.getUserUid()));
        return coverToPageOfMomentRsp(pageOfMoments);
    }

    @Override
    public void reviewPassPageOfMomentsByMid(Long mid) {
        momentsDao.updateReviewStatusByMid(mid);
    }

    @Override
    public void deleteMomentsByMid(Long mid) {
        momentsDao.deleteByPrimaryKey(mid);
    }

    private PageOfInfoListRsp<MomentsRsp> coverToPageOfMomentRsp(PageInfo<MomentsPO> momentsPageInfo){
        PageOfInfoListRsp<MomentsRsp> pageOfMomentsRsp = new PageOfInfoListRsp<>();
        pageOfMomentsRsp.setDataList(momentsPageInfo.getList().stream().map((moments->{
            MomentsRsp momentsRsp = new MomentsRsp();
            BeanUtils.copyProperties(moments, momentsRsp);
            return momentsRsp;
        })).collect(Collectors.toList()));
        BeanUtils.copyProperties(momentsPageInfo, pageOfMomentsRsp);
        return pageOfMomentsRsp;
    }

}
