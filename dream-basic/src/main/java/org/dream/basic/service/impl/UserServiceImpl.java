package org.dream.basic.service.impl;

import org.dream.basic.mapper.DeptMapper;
import org.dream.basic.mapper.UserMapper;
import org.dream.basic.mapper.UserRoleMapper;
import org.dream.basic.pojo.domain.Role;
import org.dream.basic.pojo.vo.UserVO;
import org.dream.basic.service.UserService;
import org.dream.web.BusinessException;
import org.dream.web.CommonErrorEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private DeptMapper deptMapper;
    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public List<UserVO> list(int nodeId) {
        List<UserVO> list = null;
        if (nodeId == 1){
             list = userMapper.getUserList(); //全部用户
        }
        else {
             int count = deptMapper.getCountById(nodeId);
             if (count == 0){
                 list = userMapper.getUserListOfOne(nodeId);
             }
             else {
                 list = userMapper.getUserListOfMore(nodeId);
             }
        }
        if (list.size() == 0){
            throw new BusinessException(CommonErrorEnum.RESULT_IS_NULL);
        }
        List<UserVO> userS = new ArrayList<>();
        list.forEach(user -> {
            List<Role> roles =  userRoleMapper.getRoleList(user.getUserId());
            List<String> roleNameList = new ArrayList<>();
            List<Long> roleIdList = new ArrayList<>();
            roles.forEach(role -> {
                roleIdList.add(role.getRoleId());
                roleNameList.add(role.getRoleName());
            });
            UserVO userVO = new UserVO();
            userVO.setCreateBy(user.getCreateBy())
                    .setCreateTime(user.getCreateTime())
                    .setDeptId(user.getDeptId())
                    .setDeptName(user.getDeptName())
                    .setEmail(user.getEmail())
                    .setNickName(user.getNickName())
                    .setPhone(user.getPhone())
                    .setRoleIdList(roleIdList)
                    .setRoleNameList(roleNameList)
                    .setSex(user.getSex())
                    .setStatus(user.getStatus())
                    .setUserId(user.getUserId())
                    .setUserName(user.getUserName());
            userS.add(userVO);
        });
        return userS;
    }

}
