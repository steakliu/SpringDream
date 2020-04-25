package org.dream.auth.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Author 刘牌
 * @Date 2020/4/23 0023 21:37
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class UserInfo {
    private Long userId;
    private Long deptId;
    private String userName;
    private String password;
    private List<Long> roleIds;
    private List<String> roleNames;
}
