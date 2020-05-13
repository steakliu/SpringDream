package org.dream.sso.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.dream.web.BusinessException;
import org.dream.web.CommonErrorEnum;
import org.dream.pojo.Role;
import org.dream.pojo.UserInfo;
import org.dream.sso.mapper.AuthMapper;
import org.dream.sso.service.AuthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 刘牌
 * @Date 2020/4/23 0023 23:56
 * @Version 1.0
 */

@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    private AuthMapper authMapper;

    /**
     * 获取用户信息
     * @param username
     * @return
     */
    @Override
    public UserInfo getUserInfo(String username) {
        UserInfo userInfo = authMapper.getUserInfo(username);
        if (userInfo == null){
            throw new BusinessException(CommonErrorEnum.USER_NOT_EXIST);
        }
        List<Role> roles =  authMapper.getRoleByUserName(userInfo.getUserId());
        List<Long> roleIds = new ArrayList<>();
        List<String> roleNames = new ArrayList<>();
        if (roles.size() != 0){
            roles.forEach(item ->{
                roleIds.add(item.getRoleId());
                roleNames.add(item.getRoleName());
            });
            userInfo.setRoleIds(roleIds);
            userInfo.setRoleNames(roleNames);
        }
        return userInfo;
    }
}
