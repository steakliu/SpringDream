package org.dream.auth.controller;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.dream.commons.constants.token.PayloadConstant;
import org.dream.commons.utils.info.UserInfoUtil;
import org.dream.commons.utils.info.WebUtil;
import org.dream.web.result.R;
import org.dream.pojo.vo.UserInfoVO;
import org.dream.secure.aspect.anotation.PreAuthorize;
import org.dream.secure.aspect.constant.AuthRole;
import org.springframework.web.bind.annotation.*;
import org.dream.web.base.BaseController;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author 刘牌
 * @Date 2020/4/23 0023 19:46
 * @Version 1.0
 */
@RestController
@RequestMapping("/auth")
public class AuthController extends BaseController {

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
