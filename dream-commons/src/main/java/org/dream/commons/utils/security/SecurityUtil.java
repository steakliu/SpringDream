package org.dream.commons.utils.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author 刘牌
 * @Date 2020/4/24 0024 18:26
 * @Version 1.0
 */

public class SecurityUtil {

    /**
     * 加密
     * @return
     */
    public static String encode(String username , String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(username+password);
    }

    /**
     * 核实密码
     * @param cryptPassword
     * @return
     */
    public static boolean check(String username , String password , String cryptPassword){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(username+password,cryptPassword);
    }

}
