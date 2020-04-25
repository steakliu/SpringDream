package org.dream.auth.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author 刘牌
 * @Date 2020/4/23 0023 20:56
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
public class LoginBody {
    private String username;
    private String password;
    private String captcha;
}
