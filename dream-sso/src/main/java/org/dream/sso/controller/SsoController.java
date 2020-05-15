package org.dream.sso.controller;

import lombok.extern.slf4j.Slf4j;
import org.dream.commons.constants.global.GlobalConstant;
import org.dream.commons.constants.redis.RedisConstant;
import org.dream.commons.utils.cookie.CookieUtils;
import org.dream.commons.utils.jwt.TokenUtil;
import org.dream.commons.utils.redis.RedisCache;
import org.dream.commons.utils.security.SecurityUtil;
import org.dream.commons.utils.uuid.UUIDUtil;
import org.dream.web.CommonErrorEnum;
import org.dream.web.result.R;
import org.dream.pojo.LoginBody;
import org.dream.pojo.UserInfo;
import org.dream.sso.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @Author 刘牌
 * @Date 2020/5/4 0004 21:47
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/sso")
public class SsoController {

    @Autowired
    private RedisCache redisCache;
    @Autowired
    private AuthService authService;
    /**
     * 单点登录
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/login")
    public R ssoLogin(@RequestBody LoginBody loginBody,
                      HttpServletRequest request,
                      HttpServletResponse response) {
        UserInfo userInfo = authService.getUserInfo(loginBody.getUsername());
        if (userInfo == null) {
            return R.fail(CommonErrorEnum.USER_NOT_EXIST);
        }
        userInfo.setKey(UUIDUtil.generateUUID());
        if (!SecurityUtil.check(loginBody.getUsername(), loginBody.getPassword(), userInfo.getPassword())) {
            return R.fail(CommonErrorEnum.PASSWORD_ERROR);
        }
        String token = TokenUtil.generateToken(userInfo);
        /**
         * 将用户唯一标识存至redis
         */
        redisCache.setCache(userInfo.getKey(), token, RedisConstant.TOKEN_DEAD_TIME_LENGTH);
        /**
         * 校验通过，将用户的账号返回cookie里面
         */
        CookieUtils.setCookie(request, response, GlobalConstant.CookieKey, userInfo.getKey(), 60 * 60 * 24);
        return R.success(token);
    }

    /**
     * 单点登录验证
     *
     * @param request
     * @return
     */
    @GetMapping("/loginValidate")
    public R ssoLoginValidate(HttpServletRequest request, HttpServletResponse response) {
        String ticket = null;
        try {
            ticket = CookieUtils.getCookieValue(request, response, "ticket");
        } catch (Exception e) {
            /**
             * cookie不存在，代表用户没登录
             */
            return R.fail(CommonErrorEnum.USER_NOT_LOGIN);
        }
        Boolean hasKey = redisCache.hasKey(ticket);
        /**
         * redis存在ticket
         */
        if (hasKey) {
            /**
             * 验证通过将token返回前端
             */
            String cache = redisCache.getCache(ticket);
            return R.custom(200, "system is running ", cache);
        } else {
            return R.custom(400, "system is not running", null);
        }
    }

    /**
     * 单点登出
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/loginOut")
    public R ssoLoginOut(HttpServletRequest request, HttpServletResponse response) {
        String ticket = null;
        try {
            ticket = CookieUtils.getCookieValue(request, response, GlobalConstant.CookieKey);
        }catch (Exception e){
            return R.fail(CommonErrorEnum.ALREADY_LOGIN_OUT);
        }

        Boolean hasKey = redisCache.hasKey(ticket);
        if (hasKey){
            /**
             * 删除redis中的用户唯一标识
             */
            Boolean deleteKey = redisCache.deleteKey(ticket);
            /**
             * 单点登出成功
             */
            if (deleteKey) {
                /**
                 * 删除cookie
                 */
                CookieUtils.deleteCookie(request,response,ticket);
                return R.success(CommonErrorEnum.LOGIN_OUT_SUCCESS);
            }
        }
        CookieUtils.deleteCookie(request,response,ticket);
        return R.success(CommonErrorEnum.LOGIN_OUT_SUCCESS);
    }

}
