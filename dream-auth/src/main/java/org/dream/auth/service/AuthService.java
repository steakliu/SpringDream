package org.dream.auth.service;

import org.dream.pojo.UserInfo;

/**
 * @Author 刘牌
 * @Date 2020/4/23 0023 23:56
 * @Version 1.0
 */

public interface AuthService {
    UserInfo getUserInfo(String username);
}
