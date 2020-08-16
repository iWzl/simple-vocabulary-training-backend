package cc.itsc.project.vocabulary.training.backend.utils;

import cc.itsc.project.vocabulary.training.backend.pojo.enums.RoleEnum;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

/**
 * JWTUtils的工具类,产生和创建Token
 *
 * @author Leonardo iWzl
 * @version 1.0
 */
public class JWTUtil {

    private static final long EXPIRE_TIME_PREFIX = 1296000L;
    private static final long EXPIRE_TIME = EXPIRE_TIME_PREFIX * 1000;
    private final static String ISSUER = "ITSC";
    private final static String SUBJECT = "MOVIE-X-TOKEN";

    /**
     * 创建用户Token
     *
     * @param uid  用户uid
     * @param password 用户密钥
     * @return 是否正确
     */
    public static String createToken(Integer uid, RoleEnum roleEnum, String password){
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(password);
        return JWT.create()
                .withSubject(SUBJECT)
                .withClaim("uid",uid)
                .withClaim("role",roleEnum.getRole())
                .withIssuer(ISSUER)
                .withExpiresAt(date)
                .sign(algorithm);
    }

    /**
     * 校验token是否正确
     *
     * @param token  密钥
     * @param password 用户的密钥
     * @return 是否正确
     */
    public static boolean verify(String token, String password) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(password);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .withSubject(SUBJECT)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     * 获取账户用户名
     *
     * @author Leo Wang
     * @param token Token
     * @return token中包含的用户名
     */
    public static String getPassword(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("password").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }


    /**
     * 根据token，返回用户ID
     *
     * @author Leo Wang
     * @param token Token
     * @return java.lang.Long
     */
    public static Integer getUid(String token) {
        try {
            if(null == token || "".equals(token)) return 0;
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("uid").asInt();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    public static String getRole(String token) {
        try {
            if(null == token || "".equals(token)) return RoleEnum.ALL.getRole();
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("role").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }
}
