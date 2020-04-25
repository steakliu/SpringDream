package org.dream.commons.utils.info;

import com.auth0.jwt.JWT;
import org.dream.commons.constants.token.PayloadConstant;
import org.dream.commons.vo.UserInfoVO;

/**
 * @Author 刘牌
 * @Date 2020/4/24 0024 19:36
 * @Version 1.0
 */

public class UserInfoUtil {

    /**
     * 从token中获取用户信息进行封装
     * @param token
     * @return
     */
    public static UserInfoVO userInfo(String token){
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setUserId(JWT.decode(token).getClaim(PayloadConstant.USER_ID).asLong())
                .setUserName(JWT.decode(token).getClaim(PayloadConstant.USER_NAME).asString())
                .setDeptId(JWT.decode(token).getClaim(PayloadConstant.DEPT_ID).asLong())
                .setRoleIds(JWT.decode(token).getClaim(PayloadConstant.ROLE_ID_LIST).asList(Long.class))
                .setRoleNames(JWT.decode(token).getClaim(PayloadConstant.ROLE_NAME_LIST).asList(String.class));
        return userInfoVO;
    }
}
