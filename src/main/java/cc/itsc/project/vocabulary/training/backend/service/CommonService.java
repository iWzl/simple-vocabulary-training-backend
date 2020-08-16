package cc.itsc.project.vocabulary.training.backend.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Leonardo iWzl
 * @version 1.0
 */
public interface CommonService {
    /**
     * 上传保存图片文件信息
     *
     * @param imageFile 图片文件地址
     * @return 文件上传成功的图片地址
     */
    String uploadMultipartFile(MultipartFile imageFile);
}
