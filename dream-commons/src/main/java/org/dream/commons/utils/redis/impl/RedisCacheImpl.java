package org.dream.commons.utils.redis.impl;

import org.dream.commons.utils.redis.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import java.util.concurrent.TimeUnit;

/**
 * @Author 刘牌
 * @Date 2020/4/25 0025 14:00
 * @Version 1.0
 */
@Component
public class RedisCacheImpl implements RedisCache {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 设置缓存
     * @param key
     * @param value
     */
    @Override
    public void setCache(String key, Object value,long expTime) {
        redisTemplate.opsForValue().set(key,value,expTime,TimeUnit.MINUTES);
    }

    /**
     * 根据key删除缓存
     * @param key
     * @return
     */
    @Override
    public Boolean deleteKey(String key) {
        try {
            return redisTemplate.delete(key);
        }catch (Exception e){
            return false;
        }

    }

    /**
     * 键设置过期时长
     * @param time
     */
    @Override
    public Boolean setKeyExpTime(long time , String key) {
        return redisTemplate.expire(key, time, TimeUnit.MILLISECONDS);
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public Long getKeyExpTime(String key){
         return redisTemplate.getExpire(key,TimeUnit.MINUTES);
    }


    @Override
    public String getCache(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

    @Override
    public Boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        }catch (Exception e){
            return false;
        }
    }
}
