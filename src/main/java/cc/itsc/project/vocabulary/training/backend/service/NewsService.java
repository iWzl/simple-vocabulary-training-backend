package cc.itsc.project.vocabulary.training.backend.service;

import cc.itsc.project.vocabulary.training.backend.pojo.vo.req.NewsReq;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.NewsRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.PageOfInfoListRsp;

/**
 * @author Leonardo iWzl
 * @version 1.0
 */
public interface NewsService {

    /**
     * 创建信息的信息数据
     *
     * @param newsReq 新闻信息请求
     */
    void insertNewNewsDetail(NewsReq newsReq);

    /**
     * 拉取分页拉取News信息
     *
     * @param pageNo 页码数
     * @param pageSize 每页的大小
     * @return 查询到的News信息
     */
    PageOfInfoListRsp<NewsRsp> fetchPageOfNewsByPageInfo(Integer pageNo, Integer pageSize);

    /**
     * 删除News信息
     *
     * @param nid NID
     */
    void deleteNewsByNid(Long nid);
}
