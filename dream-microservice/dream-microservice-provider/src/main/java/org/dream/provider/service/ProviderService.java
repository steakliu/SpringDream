package org.dream.provider.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 刘牌
 * @Date 2020/4/22 0022 14:50
 * @Version 1.0
 */
@RestController
@Slf4j
public class ProviderService {

    @GetMapping("/provider/get")
    public String get(@RequestParam("id") int id){
        return "我来自服务提供者，你传来的id = "+id;
    }
}
