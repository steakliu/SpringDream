package org.dream.commons.utils.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @Author 刘牌
 * @Date 2020/5/4 0004 2:09
 * @Version 1.0
 * Cookie工具类
 */
public class CookieUtils {
    /**
     *
     * @param request
     * @param response
     * @param cookieKey
     * @param cookieValue
     * @param maxAge 指定时间内失效，单位秒
     * @return
     */
    public static void setCookie(HttpServletRequest request , HttpServletResponse response , String cookieKey , String cookieValue , int maxAge){
        Cookie cookie = new Cookie(cookieKey,cookieValue);
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
     * 根据key获取cookie值
     * @param request
     * @param response
     * @param cookieKey
     * @return
     */
    public static String getCookieValue(HttpServletRequest request , HttpServletResponse response , String cookieKey){
        Cookie[] cookie = request.getCookies();
        if (cookie.length == 0){
            return null;
        }
        else {
            for (int i = 0 ; i < cookie.length ; i++){
                if (cookie[i].getName().equals(cookieKey)){
                    return cookie[i].getValue();
                }
            }
            return null;
        }
    }

    /**
     * 删除cookie
     * @param request
     * @param response
     */
    public static void deleteCookie(HttpServletRequest request , HttpServletResponse response,String cookieValue){
        Cookie cookie = new Cookie("ticket",cookieValue);
        cookie.setMaxAge(1);
        response.addCookie(cookie);
    }
}
