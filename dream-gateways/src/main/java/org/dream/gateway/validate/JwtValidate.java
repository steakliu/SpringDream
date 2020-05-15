package org.dream.gateway.validate;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.dream.commons.constants.redis.RedisConstant;
import org.dream.commons.constants.token.PayloadConstant;
import org.dream.commons.utils.info.UserInfoUtil;
import org.dream.commons.utils.info.WebUtil;
import org.dream.commons.utils.jwt.TokenUtil;
import org.dream.commons.utils.redis.RedisCache;
import org.dream.pojo.UserInfo;
import org.dream.web.result.R;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @Author 刘牌
 * @Date 2020/5/13 0013 22:48
 * @Version 1.0
 */
@Component
public class JwtValidate {

    @Resource
    private RedisCache redisCache;
    /**
     * 判断token是否有效
     * @param token
     * @return
     */
    public R checkToken(String token) {
        try {
            Jwts.parser().setSigningKey(PayloadConstant.SECRET).parseClaimsJws(token).getBody();
            return isExp(token);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 判断token是否过期
     * @param token
     * @return
     */
    public R isExp(String token){
        Claims claims = Jwts.parser().setSigningKey(PayloadConstant.SECRET).parseClaimsJws(token).getBody();
        long tokenExpTime = claims.getExpiration().getTime();
        long currentTimeMillis = System.currentTimeMillis();
        long d = tokenExpTime - currentTimeMillis;
        if (tokenExpTime - currentTimeMillis < 300000){
            /**
             * 刷新token
             */
            String refreshToken = refreshToken(token);
            /**
             * 将新token保存进redis
             */
            redisCache.setCache(WebUtil.getKey(token),refreshToken,RedisConstant.TOKEN_DEAD_TIME_LENGTH);
            /**
             * 刷新token返回前端
             */
            return R.custom(201,"刷新token返回前端",refreshToken);
        }
        return R.custom(202,"token尚未过期，可继续使用",null);
    }

    /**
     * 刷新token
     */
    public String refreshToken(String token) {
        UserInfo userInfo = UserInfoUtil.userInfoToken(token);
        return TokenUtil.generateNewToken(userInfo);
    }
}
