package org.dream.consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.dream.consumer.handler.GlobalBlockHandler;
import org.dream.consumer.handler.GlobalFallbackHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 刘牌
 * @Date 2020/4/21 0021 21:30
 * @Version 1.0
 */
@RestController
public class RateLimitController {

    /**
     * 全局处理方法(blockHandler)
     * blockHandler只针对配置异常，就是在sentinel web界面配置的异常，对程序内部的异常没有效果
     *
     * @return
     */
    @GetMapping("/rateLimitTest")
    @SentinelResource(value = "rateLimitTest",
            blockHandlerClass = GlobalBlockHandler.class,
            blockHandler = "handlerOne")
    public String rateLimitTest() {
        return "限流测试，success";
    }

    /**
     * fallback
     * fallback针对程序异常
     * @return
     */
    @GetMapping("/fallbackTest")
    @SentinelResource(value = "fallbackTest",
            fallbackClass = GlobalFallbackHandler.class,
            fallback = "fallbackOne")
    public String fallbackTest() {
        int i = 3;
        if (i > 2) {
            throw new RuntimeException("发生异常");
        }
        return "success";
    }
}
