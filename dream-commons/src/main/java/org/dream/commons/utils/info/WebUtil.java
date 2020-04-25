package org.dream.commons.utils.info;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author 刘牌
 * @Date 2020/4/24 0024 19:20
 * @Version 1.0
 */

public class WebUtil {

    private static final String TOKEN = "token";

    /**
     * 获取token
     * @param request
     * @return
     */
    public static String getToken(HttpServletRequest request){
        return request.getHeader(TOKEN);
    }

}
