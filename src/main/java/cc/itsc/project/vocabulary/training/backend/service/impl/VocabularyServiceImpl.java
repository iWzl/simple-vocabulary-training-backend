package cc.itsc.project.vocabulary.training.backend.service.impl;


import cc.itsc.project.vocabulary.training.backend.dao.VocabularyDao;
import cc.itsc.project.vocabulary.training.backend.pojo.po.GrammarPO;
import cc.itsc.project.vocabulary.training.backend.pojo.po.SentencePO;
import cc.itsc.project.vocabulary.training.backend.pojo.po.VocabularyPO;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.GrammarRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.PageOfInfoListRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.SentenceRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.VocabularyRsp;
import cc.itsc.project.vocabulary.training.backend.service.VocabularyService;

import cc.itsc.project.vocabulary.training.backend.utils.HttpUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VocabularyServiceImpl implements VocabularyService {
    private static final String LISTEN_CLASSIFY_WORD_UNDO = "生词本";
    private static final String LISTEN_CLASSIFY_WORD_DO = "已学单词";
    private static final String LISTEN_CLASSIFY_SENTENCE = "句子";
    private static final String LISTEN_CLASSIFY_MOVIE = "影视片段";

    private static final String WORD_CLASSIFY_WORD_UNDO = "未学";
    private static final String WORD_CLASSIFY_WORD_DO = "已学";

    private final VocabularyDao vocabularyDao;

    public VocabularyServiceImpl(VocabularyDao vocabularyDao) {
        this.vocabularyDao = vocabularyDao;
    }

    @Override
    public PageOfInfoListRsp<SentenceRsp> fetchPageOfListenSentencesWithClassify(String classify, Integer pageNo, Integer pageSize) {
        PageOfInfoListRsp<SentenceRsp> sentenceRspPageOfInfoListRsp = new PageOfInfoListRsp<>();
        if(null == classify){
            return sentenceRspPageOfInfoListRsp;
        }
        List<SentencePO>  sentenceList = new ArrayList<>();
        switch (classify){
            case LISTEN_CLASSIFY_WORD_UNDO:
                PageHelper.startPage(pageNo,pageSize);
                sentenceList = vocabularyDao.selectUnReadVocabularySentenceListByUid(HttpUtil.getUserUid());
                break;
            case LISTEN_CLASSIFY_WORD_DO:
                PageHelper.startPage(pageNo,pageSize);
                sentenceList = vocabularyDao.selectReadVocabularySentenceListByUid(HttpUtil.getUserUid());
                break;
            case LISTEN_CLASSIFY_SENTENCE:
            case LISTEN_CLASSIFY_MOVIE:
                PageHelper.startPage(pageNo,pageSize);
                sentenceList = vocabularyDao.selectSentenceListByUidAndClassify(HttpUtil.getUserUid(),classify);
                break;
            default:
                break;
        }
        PageInfo<SentencePO>  pageOfSentenceList = new PageInfo<>(sentenceList);
        sentenceRspPageOfInfoListRsp.setDataList(pageOfSentenceList.getList().stream().map((sentence->{
            SentenceRsp sentenceRsp= new SentenceRsp();
            BeanUtils.copyProperties(sentence, sentenceRsp);
            return sentenceRsp;
        })).collect(Collectors.toList()));
        BeanUtils.copyProperties(pageOfSentenceList, sentenceRspPageOfInfoListRsp);
        return sentenceRspPageOfInfoListRsp;
    }

    @Override
    public PageOfInfoListRsp<VocabularyRsp> fetchPageOfVocabularyByClassify(String classify, Integer pageNo, Integer pageSize) {
        PageOfInfoListRsp<VocabularyRsp> vocabularyPageOfInfoListRsp = new PageOfInfoListRsp<>();
        if(null == classify){
            return vocabularyPageOfInfoListRsp;
        }
        List<VocabularyPO> vocabularyList = new ArrayList<>();
        switch (classify){
            case WORD_CLASSIFY_WORD_UNDO:
                PageHelper.startPage(pageNo,pageSize);
                vocabularyList = vocabularyDao.selectUnReadVocabularyListByUid(HttpUtil.getUserUid());
                break;
            case WORD_CLASSIFY_WORD_DO:
                PageHelper.startPage(pageNo,pageSize);
                vocabularyList = vocabularyDao.selectReadVocabularyListByUid(HttpUtil.getUserUid());
                break;
            default:
                break;
        }
        PageInfo<VocabularyPO>  pageOfVocabularyList = new PageInfo<>(vocabularyList);
        vocabularyPageOfInfoListRsp.setDataList(pageOfVocabularyList.getList().stream().map((vocabulary->{
            VocabularyRsp vocabularyRsp= new VocabularyRsp();
            BeanUtils.copyProperties(vocabulary, vocabularyRsp);
            return vocabularyRsp;
        })).collect(Collectors.toList()));
        BeanUtils.copyProperties(pageOfVocabularyList, vocabularyPageOfInfoListRsp);
        return vocabularyPageOfInfoListRsp;
    }

    @Override
    public void syncUnReadVocabularyWithWordDetail(String word) {
        vocabularyDao.insertVocabularyReadInfo(HttpUtil.getUserUid(),word);
    }

    @Override
    public PageOfInfoListRsp<GrammarRsp> fetchPageOfGrammarWithClassify(String classify, Integer pageNo, Integer pageSize) {
        PageOfInfoListRsp<GrammarRsp> grammarRspPageOfInfoListRsp = new PageOfInfoListRsp<>();
        PageHelper.startPage(pageNo,pageSize);
        List<GrammarPO> grammarList = vocabularyDao.selectGrammarWithClassify(classify);
        PageInfo<GrammarPO> grammarPageInfo = new PageInfo<>(grammarList);
        grammarRspPageOfInfoListRsp.setDataList(grammarPageInfo.getList().stream().map((grammar->{
            GrammarRsp grammarRsp= new GrammarRsp();
            BeanUtils.copyProperties(grammar, grammarRsp);
            return grammarRsp;
        })).collect(Collectors.toList()));
        BeanUtils.copyProperties(grammarPageInfo, grammarRspPageOfInfoListRsp);
        return grammarRspPageOfInfoListRsp;
    }
}
