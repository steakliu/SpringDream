package org.dream.basic.service;

import org.dream.basic.pojo.domain.Menu;
import org.dream.basic.pojo.vo.menu.MenuVO;

import java.util.List;

/**
 * @Author 刘牌
 * @Date 2020/4/27 0027 21:59
 * @Version 1.0
 */

public interface IMenuService {
    /**
     * 根据用户id获取用户路由
     * @param userId
     * @return
     */
    List<MenuVO> selectRoutesByUserId(String userId, String username);
}
