package org.dream.consumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 刘牌
 * @Date 2020/4/22 0022 16:03
 * @Version 1.0
 * 流控
 */
@RestController
public class FlowLimitController {
    /**
     *
     * @return
     */
    @GetMapping("/flowLimit")
    public String flowLimit(){
        return "FlowLimit Success";
    }
}
