package org.dream.commons.utils.uuid;

import java.util.UUID;

/**
 * @Author 刘牌
 * @Date 2020/4/26 0026 23:13
 * @Version 1.0
 */

public class UUIDUtil {

    /**
     * 生成uuid
     * @return
     */
    public static String generateUUID(){
        return UUID.randomUUID().toString().replace("_", "");
    }
}
