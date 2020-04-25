package org.dream.consumer.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @Author 刘牌
 * @Date 2020/4/22 0022 13:59
 * @Version 1.0
 */

public class GlobalFallbackHandler {

    public static String fallbackOne(){
        return "fallback method one  + ";
    }
}
