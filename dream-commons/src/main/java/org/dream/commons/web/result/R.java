package org.dream.commons.web.result;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author 刘牌
 * @Date 2020/4/21 0021 18:28
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class R {
    private int code;
    private String msg;
    private Object data;

    /**
     * 成功
     * @param o
     * @return
     */
    public static R success(Object o){
        R r = new R();
        r.setCode(RCode.SUCCESS)
                .setMsg(RMessage.SUCCESS)
                .setData(o);
        return r;
    }

    /**
     * 失败
     * @param o
     * @return
     */
    public static R fail(Object o){
        R r = new R();
        r.setCode(RCode.FAIL)
                .setMsg(RMessage.FAIL)
                .setData(o);
        return r;
    }

    /**
     * 自定义响应结果
     * @param code
     * @param message
     * @param o
     * @return
     */
    public static R custom(int code , String message , Object o){
        R r = new R();
        r.setCode(code)
                .setMsg(message)
                .setData(o);
        return r;
    }
}
