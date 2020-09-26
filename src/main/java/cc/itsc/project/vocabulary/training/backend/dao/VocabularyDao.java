package cc.itsc.project.vocabulary.training.backend.dao;

import cc.itsc.project.vocabulary.training.backend.pojo.po.SentencePO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VocabularyDao {
    List<SentencePO> selectUnReadVocabularySentenceListByUid(@Param("userUid") Integer userUid);

    List<SentencePO> selectReadVocabularySentenceListByUid(@Param("userUid") Integer userUid);

    List<SentencePO> selectSentenceListByUidAndClassify(@Param("userUid") Integer userUid, @Param("classify") String classify);


}
