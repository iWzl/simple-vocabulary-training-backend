package cc.itsc.project.vocabulary.training.backend.service;

import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.PageOfInfoListRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.SentenceRsp;

/**
 * @author Leonardo iWzl
 * @version 1.0
 */
public interface VocabularyService {

    PageOfInfoListRsp<SentenceRsp> fetchPageOfListenSentencesWithClassify(String classify, Integer pageNo, Integer pageSize);
}
