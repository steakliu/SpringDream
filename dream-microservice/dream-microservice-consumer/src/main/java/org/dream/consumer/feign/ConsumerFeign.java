package org.dream.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author 刘牌
 * @Date 2020/4/22 0022 14:35
 * @Version 1.0
 */
@FeignClient(value = "${service.name}" , fallback = ConsumerFallbackFeign.class)
public interface ConsumerFeign {

    @GetMapping("/provider/get")
    public String get(@RequestParam("id") int id);
}
