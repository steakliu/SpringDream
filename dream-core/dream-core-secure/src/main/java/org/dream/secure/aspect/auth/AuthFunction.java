package org.dream.secure.aspect.auth;

import org.dream.secure.aspect.anotation.PreAuthorize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author 刘牌
 * @Date 2020/3/18 0018 23:31
 * @Version 1.0
 */

public class AuthFunction {

    /**
     * 判断用户能否访问接口 , 返回true代表有权限 ， 返回false代表没权限
     * @param auth
     * @return
     */
    public static boolean isContain(PreAuthorize auth , List<String> roles){
        return !Collections.disjoint(new ArrayList<>(Arrays.asList(auth.value())),roles);
    }
}
