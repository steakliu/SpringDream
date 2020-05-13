package org.dream.commons.constants.redis;

/**
 * @Author 刘牌
 * @Date 2020/4/25 0025 15:16
 * @Version 1.0
 */

public class RedisConstant {

    /**
     * token存redis的key，格式为 token:username
     */
    public static final String TOKEN_KEY = "token:";

    /**
     * token在Redis中的过期时间
     */
    public static final long TOKEN_DEAD_TIME_LENGTH = 7;

    /**
     *5分钟
     */
    public static final long TOKEN_WILL_DEAD = 300000;

    /**
     * key
     */
    public static final String KEY = "key";
}
