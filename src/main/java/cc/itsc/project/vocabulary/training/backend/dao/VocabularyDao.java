package cc.itsc.project.vocabulary.training.backend.dao;

import cc.itsc.project.vocabulary.training.backend.pojo.po.GrammarPO;
import cc.itsc.project.vocabulary.training.backend.pojo.po.SentencePO;
import cc.itsc.project.vocabulary.training.backend.pojo.po.VocabularyPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VocabularyDao {
    List<SentencePO> selectUnReadVocabularySentenceListByUid(@Param("userUid") Integer userUid);

    List<SentencePO> selectReadVocabularySentenceListByUid(@Param("userUid") Integer userUid);

    List<SentencePO> selectSentenceListByUidAndClassify(@Param("userUid") Integer userUid, @Param("classify") String classify);

    List<VocabularyPO> selectUnReadVocabularyListByUid(@Param("userUid") Integer userUid);

    List<VocabularyPO> selectReadVocabularyListByUid(@Param("userUid") Integer userUid);

    void insertVocabularyReadInfo(@Param("userUid") Integer userUid, @Param("word") String word);

    List<GrammarPO> selectGrammarWithClassify(@Param("classify") String classify);
}
