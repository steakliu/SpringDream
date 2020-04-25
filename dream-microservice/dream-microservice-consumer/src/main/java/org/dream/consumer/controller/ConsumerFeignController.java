package org.dream.consumer.controller;

import org.dream.consumer.feign.ConsumerFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 刘牌
 * @Date 2020/4/22 0022 14:45
 * @Version 1.0
 */
@RestController
public class ConsumerFeignController {

    @Autowired
    private ConsumerFeign consumerFeign;

    @GetMapping("/provider/get")
    public String get(@RequestParam("id") int id){
        return consumerFeign.get(id);
    }
}
