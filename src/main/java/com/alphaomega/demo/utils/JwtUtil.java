package com.alphaomega.demo.utils;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import com.alphaomega.demo.constant.Constant;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {

    /**
     * 根据用户信息签发token字符串
     * 
     * @param userName
     * @param userId
     * @return token字符串
     */
    public static String createJWT(String userName, String userId) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        //设置token的超时时间
        long expirTime = Long.valueOf(Constant.USER_TOKEN_VALID_TIME) * 1000;
        Date expireDate = new Date(nowMillis + expirTime);
//        log.debug("now:" + now + ", expireDate:" + expireDate);

        // 添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
        							.setHeaderParam("alg", "HS256")
        							.claim("username", userName).claim("userid", userId)
        							.setIssuer("hanergy").setAudience(userName)
        							//.setExpiration(new Date(nowMillis + 24 * 60 * 1000))
        							.setExpiration(expireDate)
        							.setNotBefore(now).setIssuedAt(now)
        							.signWith(signatureAlgorithm, generalKey());

        // 生成JWT
        return builder.compact();
    }
    
    /**
     * 生成加密key
     * 
     * @return 加密key
     */
    public static Key generalKey() {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(Constant.TOKEN_SECRET_KEY);
        return new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
    }
	
}
