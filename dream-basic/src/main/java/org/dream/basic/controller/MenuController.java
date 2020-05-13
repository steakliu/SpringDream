package org.dream.basic.controller;

import org.dream.basic.pojo.vo.menu.MenuVO;
import org.dream.basic.service.IMenuService;
import org.dream.commons.utils.info.WebUtil;
import org.dream.web.base.BaseController;
import org.dream.web.result.R;
import org.dream.secure.aspect.anotation.PreAuthorize;
import org.dream.secure.aspect.constant.AuthRole;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author 刘牌
 * @Date 2020/4/22 0022 23:45
 * @Version 1.0
 */
@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController {

    @Resource
    private IMenuService menuService;
    /**
     * 根据用户查询用户拥有的路由
     * @param request
     * @return
     */
    @GetMapping("/selectRoutesByUserId")
    @PreAuthorize(AuthRole.ADMIN)
    public R selectRoutesByUserId(HttpServletRequest request){
        String token = WebUtil.getToken(request);
        String userId = WebUtil.getUserId(token);
        String userName = WebUtil.getUserName(token);
        List<MenuVO> list = menuService.selectRoutesByUserId(userId,userName);
        return R.success(list);
    }


}
