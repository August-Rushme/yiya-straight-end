package com.yiya.dentalcity.wx.config.shiro;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 战神
 */
@Component
@Slf4j
public class JwtUtil {
    @Value("${yiya.jwt.secret}")
    private String secret;

    @Value("${yiya.jwt.expire}")
    private int expire;

    /**
     * 生成token
     * @param userId
     * @return
     */
    public String createToken(int userId){
        Date date=DateUtil.offset(new Date(), DateField.DAY_OF_YEAR,expire);
        Algorithm algorithm=Algorithm.HMAC256(secret);
        JWTCreator.Builder builder= JWT.create();
        String token=builder.withClaim("userId",userId).withExpiresAt(date).sign(algorithm);
        return token;
    }

    /**
     * 获取用户id
     * @param token
     * @return
     */
    public int getUserId(String token){
        DecodedJWT jwt=JWT.decode(token);
        int userId=jwt.getClaim("userId").asInt();
        return userId;
    }
    /**
     * 验证token
     * @param token
     * @return
     */
    public void verifierToken(String token){
        Algorithm algorithm=Algorithm.HMAC256(secret);
        JWTVerifier verifier=JWT.require(algorithm).build();
        verifier.verify(token);
    }
}
