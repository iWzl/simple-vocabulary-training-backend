package cc.itsc.project.vocabulary.training.backend.service.impl;


import cc.itsc.project.vocabulary.training.backend.dao.VocabularyDao;
import cc.itsc.project.vocabulary.training.backend.pojo.po.DictionaryPO;
import cc.itsc.project.vocabulary.training.backend.pojo.po.SentencePO;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.GoodsRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.PageOfInfoListRsp;
import cc.itsc.project.vocabulary.training.backend.pojo.vo.rsp.SentenceRsp;
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

    private VocabularyDao vocabularyDao;

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
}
