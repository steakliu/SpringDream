package org.dream.basic.pojo.vo.menu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Author 刘牌
 * @Date 2020/4/27 0027 22:55
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class MenuVO {
    private String path;

    private String component;

    private String redirect;

    private boolean alwaysShow;

    private Meta meta;

    private String name;

    private List<MenuVO> children;
}
