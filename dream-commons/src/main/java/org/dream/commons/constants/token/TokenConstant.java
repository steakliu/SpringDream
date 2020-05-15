package org.dream.commons.constants.token;

import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.UUID;

/**
 * @Author 刘牌
 * @Date 2020/4/24 0024 17:29
 * @Version 1.0
 */

public class TokenConstant {
    /**
     * 将要过期的token(6分钟后就过期)
     */
    public static final int TOKEN_DEAD_TIME_LENGTH = 360000; //小于等于五分钟的token

    /**
     * TOKEN过期时间长度(7分钟过期)
     */
    private static final long EXPIRATION_DATE_LENGTH = 420000;

    /**
     * ID
     */
    public static final String ID = UUID.randomUUID().toString().replace("-", "");

    /**
     * token的生成时间
     */
    public static final Date GENERATE_TOKEN_TIME = new Date();

    /**
     * 过期时间
     */
    public static final Date EXPIRATION_DATE =  new Date(System.currentTimeMillis() + 420000);

    /**
     * 签名算法
     */
    public static final SignatureAlgorithm  SIGNATURE_ALGORITHM  = SignatureAlgorithm.HS256;



}
