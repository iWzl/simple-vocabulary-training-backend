package cc.itsc.project.vocabulary.training.backend.utils;


import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * AES 加密方法，是对称的密码算法(加密与解密的密钥一致)，这里使用最大的 256 位的密钥
 */
public class AESUtil {

    private final static String prng = "SHA1PRNG";
    /**
     * 获得一个 密钥长度为 256 位的 AES 密钥，
     *
     * @return 返回经 BASE64 处理之后的密钥字符串
     */
    public static String getStrKeyAES(String key) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom =  SecureRandom.getInstance(prng);
        secureRandom.setSeed(key.getBytes(StandardCharsets.UTF_8));
        keyGen.init(256, secureRandom);   // 这里可以是 128、192、256、越大越安全
        SecretKey secretKey = keyGen.generateKey();
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }

    /**
     * 将使用 Base64 加密后的字符串类型的 secretKey 转为 SecretKey
     *
     * @param strKey Base64的密钥Key
     * @return SecretKey
     */
    public static SecretKey strKey2SecretKey(String strKey) {
        byte[] bytes = Base64.getDecoder().decode(strKey);
        return new SecretKeySpec(bytes, "AES");
    }

    /**
     * 加密
     *
     * @param content   待加密内容
     * @param secretKey 加密使用的 AES 密钥
     * @return 加密后的密文 byte[]
     */
    public static byte[] encryptAES(byte[] content, SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(content);
    }

    /**
     * 解密
     *
     * @param content   待解密内容
     * @param secretKey 解密使用的 AES 密钥
     * @return 解密后的明文 byte[]
     */
    public static byte[] decryptAES(byte[] content, SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(content);
    }


    public static String encryptAES(String secret, String password) {
        try {
            // 获得经 BASE64 处理之后的 AES 密钥
            String strKeyAES = AESUtil.getStrKeyAES(secret);
            // 将 BASE64 处理之后的 AES 密钥转为 SecretKey
            SecretKey secretKey = AESUtil.strKey2SecretKey(strKeyAES);
            // 加密数据
            byte[] encryptAESBytes = AESUtil.encryptAES(password.getBytes(StandardCharsets.UTF_8), secretKey);
            return Base64.getEncoder().encodeToString(encryptAESBytes);
        } catch (Exception e) {
            return "";
        }
    }


    public static String decryptAES(String secret, String passcode) {
        try {
            // 获得经 BASE64 处理之后的 AES 密钥
            String strKeyAES = AESUtil.getStrKeyAES(secret);
            // 将 BASE64 处理之后的 AES 密钥转为 SecretKey
            SecretKey secretKey = AESUtil.strKey2SecretKey(strKeyAES);
            // 解密数据
            byte[] encryptAESBytes = Base64.getDecoder().decode(passcode);
            return new String(AESUtil.decryptAES(encryptAESBytes, secretKey), StandardCharsets.UTF_8);
        } catch (Exception e) {
            return "";
        }
    }


    public static void main(String[] args) {
        String content = "Password"; // 待加密的字符串
        String passcode = encryptAES("09698636-b381-4033-83b3-b09bd2773ca8",content);
        System.out.println(passcode);
        System.out.println(decryptAES("09698636-b381-4033-83b3-b09bd2773ca8",passcode));
    }
}