package org.dream.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 刘牌
 * @Date 2020/4/22 0022 23:45
 * @Version 1.0
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @GetMapping("/list")
    public String list(){
        return "菜单列表";
    }
}
