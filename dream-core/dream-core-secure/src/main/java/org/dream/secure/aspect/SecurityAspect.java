package org.dream.secure.aspect;

import com.auth0.jwt.JWT;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.dream.commons.constants.global.GlobalConstant;
import org.dream.commons.constants.token.PayloadConstant;
import org.dream.web.BusinessException;
import org.dream.web.CommonErrorEnum;
import org.dream.secure.aspect.anotation.PreAuthorize;
import org.dream.secure.aspect.auth.AuthFunction;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 * @Author 刘牌
 * @Date 2020/3/13 0013 18:04
 * @Version 1.0
 */
@Component
@Aspect
public class SecurityAspect{
    @Resource
    private HttpServletRequest request;

    @Pointcut("@annotation(auth)")
    public void pointcutPreAuthorize(PreAuthorize auth) {}

    @Around("pointcutPreAuthorize(auth)")
    public Object doPreAuthorize(ProceedingJoinPoint point,PreAuthorize auth) throws Throwable {
        String token = request.getHeader(GlobalConstant.TOKEN);
        List<String> roles = JWT.decode(token).getClaim(PayloadConstant.ROLE_NAME_LIST).asList(String.class);
        if (AuthFunction.isContain(auth,roles)){
            return point.proceed();
        }
        else {
            throw new BusinessException(CommonErrorEnum.NO_AUTH);
        }
    }

}
