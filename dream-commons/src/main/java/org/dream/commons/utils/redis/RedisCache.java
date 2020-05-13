package org.dream.commons.utils.redis;

import java.util.HashMap;

/**
 * @Author 刘牌
 * @Date 2020/4/24 0024 19:08
 * @Version 1.0
 */
public interface RedisCache {

    /**
     * 设置缓存
     * @param key
     * @param value
     */
    public void setCache(String key , Object value , long expTime);

    /**
     * 删除缓存
     * @param key
     * @return
     */
    public Boolean deleteKey(String key);

    /**
     * 键设置过期时长
     * @param time
     */
    public Boolean setKeyExpTime(long time , String key);


    public Long getKeyExpTime(String key);


    public String getCache(String key);

    public Boolean hasKey(String key);

}
