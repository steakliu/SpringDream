package org.dream.commons.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Author 刘牌
 * @Date 2020/4/24 0024 19:48
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class UserInfoVO {
    private Long userId;
    private Long deptId;
    private String userName;
    private List<Long> roleIds;
    private List<String> roleNames;
}
