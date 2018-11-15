package com.lr.cloudadmin.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * 请填写类注释
 *
 * @author shijie.xu
 * @since 2018年11月15日
 */
public class JwtUtil {
    /**
     * 解析jwt
     */

    public static Claims parseJWT(String jsonWebToken, String base64Security){
        try{
            Claims claims = Jwts.parser()
            .setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
            .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        }catch (Exception e){
            return null;
        }
    }

    /**
     *
     * @param name
     * @param password
     * @param audience
     * @param issuer
     * @param TTLMillis
     * @param base64Security
     * @return
     */
    public static String createJWT(String name,String password,
                                   String audience, String issuer, long TTLMillis, String base64Security){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //生成签名密钥
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Security);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
        .claim("unique_name", name)
//        .claim("userid", userId)
        .claim("password",password)
        .setIssuer(issuer)
        .setAudience(audience)
        .signWith(signatureAlgorithm, signingKey);
        //添加Token过期时间
        if (TTLMillis >= 0) {
            long expMillis = nowMillis + TTLMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp).setNotBefore(now);
        }

        //生成JWT
        return builder.compact();
    }

}
