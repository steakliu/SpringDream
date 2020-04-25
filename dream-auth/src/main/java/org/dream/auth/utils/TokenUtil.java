package org.dream.auth.utils;

import com.auth0.jwt.JWT;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import org.dream.auth.pojo.UserInfo;
import org.dream.commons.constants.token.PayloadConstant;
import org.dream.commons.constants.token.TokenConstant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 刘牌
 * @Date 2020/4/23 0023 21:28
 * @Version 1.0
 */

public class TokenUtil {
    /**
     * 创建Token
     * @param user
     * @return
     */
    public static String generateToken(UserInfo user) {
        //创建payload私有声明
        Map<String, Object> map = new HashMap<>();
        map.put(PayloadConstant.USER_ID, user.getUserId());
        map.put(PayloadConstant.USER_NAME, user.getUserName());
        map.put(PayloadConstant.DEPT_ID, user.getDeptId());
        map.put(PayloadConstant.PASSWORD, user.getPassword());
        map.put(PayloadConstant.ROLE_ID_LIST, user.getRoleIds());
        map.put(PayloadConstant.ROLE_NAME_LIST,user.getRoleNames());
        //生成签名的时候使用的密钥secret
        String key = user.getPassword();
        //签发人
        String subject = user.getUserName();
        //为payload添加各种标准
        JwtBuilder jwtBuilder = Jwts.builder()
                .setClaims(map)
                .setId(TokenConstant.ID)
                .setIssuedAt(TokenConstant.GENERATE_TOKEN_TIME)
                .setSubject(subject)
                .signWith(TokenConstant.SIGNATURE_ALGORITHM, key);
        //jwtBuilder.setExpiration();//设置过期时间
        return jwtBuilder.compact();
    }


}
