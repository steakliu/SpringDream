package org.dream.commons.exception;

/**
 * @Author 刘牌
 * @Date 2020/4/23 0023 20:31
 * @Version 1.0
 */

public class BusinessException extends RuntimeException implements CommonError{

    private CommonError commonError;

    public BusinessException(CommonError commonError){
        this.commonError = commonError;
    }

    public BusinessException(CommonError commonError , String msg){
        this.commonError = commonError;
        this.commonError.setErrMsg(msg);
    }

    @Override
    public int getErrCode() {
        return this.commonError.getErrCode();
    }

    @Override
    public String getErrMsg() {
        return this.commonError.getErrMsg();
    }

    @Override
    public CommonError setErrMsg(String errorMsg) {
        this.commonError.setErrMsg(errorMsg);
        return this;
    }
}
