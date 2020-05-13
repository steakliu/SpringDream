package org.dream.web;

/**
 * @Author 刘牌
 * @Date 2020/4/23 0023 20:31
 * @Version 1.0
 */

public interface CommonError {
    /**
     * 错误码
     */
    public int getErrCode();

    /**
     * 错误信息
     */
    public String getErrMsg();

    /**
     * 自定义错误信息
     */
    public CommonError setErrMsg(String errorMsg);

}
