package org.dream.gateway.route;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 刘牌
 * @Date 2020/4/22 0022 23:26
 * @Version 1.0
 * 不需要鉴权的路由
 */

public class Route {

    private static List<String> noAuthRouteList = new ArrayList<>();

    /**
     * 不需要鉴权的路由
     * @return
     */
    public static List<String> unAuthRoute(){
        /**
         * 单点登录
         */
        noAuthRouteList.add("/sso/login");
        /**
         * 验证用户是否登录
         */
        noAuthRouteList.add("/sso/loginValidate");
        /**
         * 单点登出
         */
        noAuthRouteList.add("/sso/loginOut");

        return noAuthRouteList;
    }
}
