package org.dream.consumer.feign;

import org.springframework.stereotype.Component;

/**
 * @Author 刘牌
 * @Date 2020/4/22 0022 14:42
 * @Version 1.0
 * 服务降级类
 */
@Component
public class ConsumerFallbackFeign implements ConsumerFeign {
    @Override
    public String get(int id) {
        return "服务调用失败兜底方法";
    }
}
