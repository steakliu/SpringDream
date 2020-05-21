package org.dream.basic.controller;

import lombok.AllArgsConstructor;
import org.dream.basic.pojo.domain.User;
import org.dream.secure.aspect.anotation.PreAuthorize;
import org.dream.secure.aspect.constant.AuthRole;
import org.dream.web.result.R;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 刘牌
 * @Date 2020/5/20 0020 15:03
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    /**
     * 用户列表
     * @return
     */
    @RequestMapping(method = RequestMethod.GET , path = "/list")
    public R list(){
        return R.success(null);
    }

    /**
     * 添加/修改用户
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,path = "/save")
    @PreAuthorize(AuthRole.ADMIN)
    public R saveOrEdit(@RequestBody User user){
        return R.success(null);
    }

    /**
     * 删除用户
     * @param ids
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE , path = "/delete")
    @PreAuthorize({AuthRole.ADMIN,AuthRole.EDITOR})
    public R delete(@RequestParam String ids){
        return R.success(null);
    }


}
