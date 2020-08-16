package cc.itsc.project.vocabulary.training.backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 后台项目的入口
 *
 * @author Leonardo iWzl
 */

//此注解表示SpringBoot启动类
@SpringBootApplication
// 此注解表示动态扫描DAO接口所在包
@MapperScan("cc.itsc.project.vocabulary.training.backend.dao")

public class VocabularyTrainingBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(VocabularyTrainingBackendApplication.class, args);
    }

}
