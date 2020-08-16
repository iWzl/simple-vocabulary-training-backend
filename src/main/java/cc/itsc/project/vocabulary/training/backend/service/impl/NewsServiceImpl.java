package cc.itsc.project.vocabulary.training.backend.service.impl;

import cc.itsc.project.vocabulary.training.backend.dao.NewsDao;
import cc.itsc.project.vocabulary.training.backend.pojo.po.NewsPO;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.req.NewsReq;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.NewsRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.PageOfInfoListRsp;
import cc.itsc.project.vocabulary.training.backend.service.NewsService;
import cc.itsc.project.vocabulary.training.backend.utils.HttpUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.stream.Collectors;

@Service
public class NewsServiceImpl implements NewsService {
    @Resource
    private NewsDao newsDao;

    @Override
    public void insertNewNewsDetail(NewsReq newsReq) {
        NewsPO newDetail  = new NewsPO();
        newDetail.setContent(newsReq.getContent());
        newDetail.setUid(Long.valueOf(HttpUtil.getUserUid()));
        newDetail.setCreateTime(System.currentTimeMillis());
        newDetail.setStatus(0);
        newsDao.insertSelective(newDetail);
    }

    @Override
    public PageOfInfoListRsp<NewsRsp> fetchPageOfNewsByPageInfo(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<NewsPO> pageOfNews = new PageInfo<>(newsDao.selectAllNews());
        PageOfInfoListRsp<NewsRsp> pageOfNewsRsp = new PageOfInfoListRsp<>();
        pageOfNewsRsp.setDataList(pageOfNews.getList().stream().map((news->{
            NewsRsp newsRsp = new NewsRsp();
            BeanUtils.copyProperties(news, newsRsp);
            return newsRsp;
        })).collect(Collectors.toList()));
        BeanUtils.copyProperties(pageOfNews, pageOfNewsRsp);
        return pageOfNewsRsp;
    }

    @Override
    public void deleteNewsByNid(Long nid) {
        newsDao.deleteByPrimaryKey(nid);
    }
}
