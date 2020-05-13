package org.dream.commons.utils.info;

import com.auth0.jwt.JWT;
import org.dream.commons.constants.token.PayloadConstant;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    /**
     * 获取用户ID(userId)
     * @param token
     * @return
     */
    public static String getUserId(String token){
        return JWT.decode(token).getClaim(PayloadConstant.USER_ID).asString();
    }

    /**
     * 获取用户ID(userId)
     * @param token
     * @return
     */
    public static String getUserName(String token){
        return JWT.decode(token).getClaim(PayloadConstant.USER_NAME).asString();
    }

    /**
     * 获取用户角色集合
     * @param token
     * @return
     */
    public static List<String> getRoleNameList(String token){
        return JWT.decode(token).getClaim(PayloadConstant.ROLE_NAME_LIST).asList(String.class);
    }

}
