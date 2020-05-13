package org.dream.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author 刘牌
 * @Date 2020/4/23 0023 23:39
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class Role {
    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 角色NAME
     */
    private String roleName;
}
