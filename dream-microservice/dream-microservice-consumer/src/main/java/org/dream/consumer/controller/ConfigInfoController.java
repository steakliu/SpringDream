package org.dream.consumer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 刘牌
 * @Date 2020/4/21 0021 1:13
 * @Version 1.0
 */
@RestController
@RefreshScope
public class ConfigInfoController {

    @Value("${config.info}")
    public String info;

    @GetMapping("info")
    public String outInfo(){
        return info;
    }
}
