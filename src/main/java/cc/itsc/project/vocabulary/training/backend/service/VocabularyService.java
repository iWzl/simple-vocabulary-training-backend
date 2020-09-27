package cc.itsc.project.vocabulary.training.backend.service;

import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.GrammarRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.PageOfInfoListRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.SentenceRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.VocabularyRsp;

/**
 * @author Leonardo iWzl
 * @version 1.0
 */
public interface VocabularyService {

    PageOfInfoListRsp<SentenceRsp> fetchPageOfListenSentencesWithClassify(String classify, Integer pageNo, Integer pageSize);

    PageOfInfoListRsp<VocabularyRsp> fetchPageOfVocabularyByClassify(String classify, Integer pageNo, Integer pageSize);

    void syncUnReadVocabularyWithWordDetail(String word);

    PageOfInfoListRsp<GrammarRsp> fetchPageOfGrammarWithClassify(String classify, Integer pageNo, Integer pageSize);
}
