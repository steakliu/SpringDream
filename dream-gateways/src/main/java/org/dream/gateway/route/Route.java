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
        //登录
        noAuthRouteList.add("/login");
        noAuthRouteList.add("/menu/list");
        noAuthRouteList.add("/auth/login");
        //noAuthRouteList.add("/auth/userInfo");
        return noAuthRouteList;
    }
}
