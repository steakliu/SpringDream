package org.dream.gateway.utils;

import com.auth0.jwt.JWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.dream.commons.constants.redis.RedisConstant;
import org.dream.commons.constants.token.PayloadConstant;
import org.dream.commons.constants.token.TokenConstant;
import org.dream.commons.utils.info.UserInfoUtil;
import org.dream.commons.utils.redis.RedisCache;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author 刘牌
 * @Date 2020/4/24 0024 21:51
 * @Version 1.0
 */
@Component
public class JwtUtil {

    @Resource
    private RedisCache redisCache;

    public boolean checkToken(String token) {
        /**
         * 用户名
         */
        String username = JWT.decode(token).getClaim(PayloadConstant.USER_NAME).asString();
        /**
         * 还有多久过期
         */
        long time = redisCache.getKeyExpTime(RedisConstant.TOKEN_KEY + username);
        /**
         * 已经过期
         */
        if (time < 1){
            return false;
        }
        /**
         *  token将要过期
         */
        if (time < RedisConstant.TOKEN_WILL_DEAD) {
            /**
             * 为token续时
             */
            return refreshToken(username);
        }
        /**
         * 未过期
         */
        return true;
    }

    /**
     * 刷新token
     */
    public Boolean refreshToken(String key) {
        return redisCache.setKeyExpTime(TokenConstant.TOKEN_DEAD_TIME_LENGTH, RedisConstant.TOKEN_KEY + key);
    }


}
