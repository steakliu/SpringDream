package org.dream.basic.pojo.vo.menu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author 刘牌
 * @Date 2020/4/27 0027 23:15
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Meta {

    private String icon;

    private String title;
}
