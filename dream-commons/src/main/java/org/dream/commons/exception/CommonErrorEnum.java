package org.dream.commons.exception;

/**
 * @Author 刘牌
 * @Date 2020/4/23 0023 20:33
 * @Version 1.0
 */
public enum CommonErrorEnum implements CommonError{
    /**
     * 1000
     */
    CUSTOM_EX(1000,"自定义异常"),
    PARAM_ERROR(1001,"参数不合法"),
    UNKNOWN_ERROR(1002,"未知错误"),
    /**
     * 2000
     */
    USER_NOT_EXIST(2001,"用户不存在"),
    PASSWORD_ERROR(2002,"密码错误"),
    TOKEN_IS_NULL(2003,"缺失token，无法鉴权")
    ;




    private int errorCode;
    private String errorMsg;

    CommonErrorEnum(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public int getErrCode() {
        return this.errorCode;
    }

    @Override
    public String getErrMsg() {
        return this.errorMsg;
    }

    /**
     * 自定义错误信息
     * @param errorMsg
     * @return
     */
    @Override
    public CommonError setErrMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }
}
