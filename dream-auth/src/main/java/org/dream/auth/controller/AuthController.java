package org.dream.auth.controller;


import com.auth0.jwt.JWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dream.auth.pojo.UserInfo;
import org.dream.auth.service.AuthService;
import org.dream.auth.utils.TokenUtil;
import org.dream.commons.constants.redis.RedisConstant;
import org.dream.commons.constants.token.PayloadConstant;
import org.dream.commons.constants.token.TokenConstant;
import org.dream.commons.utils.info.UserInfoUtil;
import org.dream.commons.utils.info.WebUtil;
import org.dream.commons.utils.redis.RedisCache;
import org.dream.commons.utils.security.SecurityUtil;
import org.dream.commons.exception.BusinessException;
import org.dream.commons.exception.CommonErrorEnum;
import org.dream.commons.vo.UserInfoVO;
import org.dream.commons.web.base.BaseController;
import org.dream.commons.web.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author 刘牌
 * @Date 2020/4/23 0023 19:46
 * @Version 1.0
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController extends BaseController {

    @Resource
    private AuthService authService;

    @Autowired
    private RedisCache redisCache;

    @PostMapping("/login")
    public R login(@RequestParam String username ,
                   @RequestParam String password ,
                   @RequestParam String captcha){
        if (password.isEmpty() || username.isEmpty() || captcha.isEmpty()){
            throw new BusinessException(CommonErrorEnum.PARAM_ERROR);
        }
        UserInfo userInfo = authService.getUserInfo(username);
        if (!SecurityUtil.check(username,password,userInfo.getPassword())){
            throw new BusinessException(CommonErrorEnum.PASSWORD_ERROR);
        }
        String token = TokenUtil.generateToken(userInfo);
        redisCache.setCache(RedisConstant.TOKEN_KEY+username,token,RedisConstant.TOKEN_DEAD_TIME_LENGTH);
        return R.success(token);
    }

    /**
     * 获取用户信息
     * @return
     */
    @GetMapping("/userInfo")
    public R userInfo(HttpServletRequest request){
        String token = WebUtil.getToken(request);
        UserInfoVO userInfo = UserInfoUtil.userInfo(token);
        return R.success(userInfo);
    }

}
