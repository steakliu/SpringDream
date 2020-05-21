package org.dream.commons.utils.jwt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import org.dream.commons.constants.token.PayloadConstant;
import org.dream.commons.constants.token.TokenConstant;
import org.dream.commons.utils.uuid.UUIDUtil;
import org.dream.pojo.UserInfo;

import java.util.Date;
import java.util.HashMap;
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
        map.put("keyOfOne", UUIDUtil.generateUUID());
        map.put(PayloadConstant.PASSWORD, user.getPassword());
        map.put(PayloadConstant.ROLE_ID_LIST, user.getRoleIds());
        map.put(PayloadConstant.ROLE_NAME_LIST,user.getRoleNames());
        map.put(PayloadConstant.KEY,user.getKey());
        //生成签名的时候使用的密钥secret
        String key = PayloadConstant.SECRET;
        //签发人
        String subject = user.getUserName();
        //为payload添加各种标准
        JwtBuilder jwtBuilder = Jwts.builder()
                .setClaims(map)
                .setId(TokenConstant.ID)
                .setIssuedAt(TokenConstant.GENERATE_TOKEN_TIME)
                .setSubject(subject)
                .signWith(TokenConstant.SIGNATURE_ALGORITHM, key);
        jwtBuilder.setExpiration(TokenConstant.EXPIRATION_DATE);//设置过期时间
        return jwtBuilder.compact();
    }

    /**
     * 刷新token
     * @param user
     * @return
     */
    public static String generateNewToken(UserInfo user){
        //创建payload私有声明
        Map<String, Object> map = new HashMap<>();
        map.put(PayloadConstant.USER_ID, user.getUserId());
        map.put(PayloadConstant.USER_NAME, user.getUserName());
        map.put(PayloadConstant.DEPT_ID, user.getDeptId());
        map.put("keyOfOne", UUIDUtil.generateUUID());
        map.put(PayloadConstant.PASSWORD, user.getPassword());
        map.put(PayloadConstant.ROLE_ID_LIST, user.getRoleIds());
        map.put(PayloadConstant.ROLE_NAME_LIST,user.getRoleNames());
        map.put(PayloadConstant.KEY,user.getKey());
        //生成签名的时候使用的密钥secret
        String key = PayloadConstant.SECRET;
        //签发人
        String subject = user.getUserName();
        //为payload添加各种标准
        JwtBuilder jwtBuilder = Jwts.builder()
                .setClaims(map)
                .setId(TokenConstant.ID)
                .setIssuedAt(TokenConstant.GENERATE_TOKEN_TIME)
                .setSubject(subject)
                .signWith(TokenConstant.SIGNATURE_ALGORITHM, key);
        jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + 5200000));//设置过期时间
        return jwtBuilder.compact();
    }

}
