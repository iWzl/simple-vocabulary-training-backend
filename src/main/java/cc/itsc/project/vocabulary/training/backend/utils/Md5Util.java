package cc.itsc.project.vocabulary.training.backend.utils;

import org.springframework.util.DigestUtils;

import java.security.MessageDigest;
import java.util.UUID;

/**
 * @author Leonardo iWzl
 * @version 1.0
 */
public class Md5Util {
    public static String encodeByMd5(String value,String slat,int uid) {
        String passString = String.format("I%sT%sS%sC",value,slat,uid);
        return DigestUtils.md5DigestAsHex(passString.getBytes());
    }
}
