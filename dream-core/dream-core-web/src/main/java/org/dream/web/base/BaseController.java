package org.dream.web.base;

import org.dream.web.BusinessException;
import org.dream.web.CommonErrorEnum;
import org.dream.web.result.R;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 刘牌
 * @Date 2020/4/24 0024 16:18
 * @Version 1.0
 */

public class BaseController {
    /**
     * Tomcat异常捕获
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException(HttpServletRequest request, Exception ex){
        Map<String,Object> responseData = new HashMap<>();
        if (ex instanceof BusinessException){
            BusinessException businessException = (BusinessException) ex;
            responseData.put("errorCode",businessException.getErrCode());
            responseData.put("errorMsg",businessException.getErrMsg());
        }
        else {
            responseData.put("errorCode", CommonErrorEnum.UNKNOWN_ERROR.getErrCode());
            responseData.put("errorMsg",CommonErrorEnum.UNKNOWN_ERROR.getErrMsg());
        }
        return R.fail(responseData);
    }

}
