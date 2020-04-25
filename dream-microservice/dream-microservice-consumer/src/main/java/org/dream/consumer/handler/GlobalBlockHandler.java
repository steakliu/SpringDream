package org.dream.consumer.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @Author 刘牌
 * @Date 2020/4/21 0021 21:27
 * @Version 1.0
 *
 * 自定义全局服务降级类
 */
public class GlobalBlockHandler {

    public static String handlerOne(BlockException bx){
        return "限流失败跳转方法1";
    }

    public static String handlerTwo(BlockException bx){
        return "限流失败跳转方法2";
    }
}
