package org.dream.consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 刘牌
 * @Date 2020/4/21 0021 13:53
 * @Version 1.0
 */
@RestController
public class HotKeyController {
    /**
     * 热点规则
     * @return
     */
    @SentinelResource(value = "hotKey" , blockHandler = "handHotKey")
    @GetMapping("/hotKey")
    public String hotKey(@RequestParam(value = "hotParam") String hotParam){
        return "hotKey正常";
    }

    /**
     * 热点规则失败后执行的方法
     * @param hotParam
     * @param ex
     * @return
     */
    public String handHotKey(String hotParam , BlockException ex){
        return "hotKey失败，请稍后重试";
    }


}
