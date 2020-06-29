package org.dream.web;

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
    RESULT_IS_NULL(1003,"没有记录"),
    /**
     * 2000
     */
    USER_NOT_EXIST(2001,"用户不存在"),
    PASSWORD_ERROR(2002,"密码错误"),
    TOKEN_IS_NULL(2003,"缺失token，无法鉴权"),
    USER_NOT_LOGIN(2003,"没有登录，请登录"), //单点登录
    LOGIN_OUT_SUCCESS(2004,"单点登出成功"),
    LOGIN_OUT_FAIL(2005,"单点登出失败"),
    ALREADY_LOGIN_OUT(2006,"单点已经登出"),

    /**
     * 3000
     */
    NO_AUTH(30001,"没有授权，不能进行访问"),
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
