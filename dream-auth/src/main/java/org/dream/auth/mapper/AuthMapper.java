package org.dream.auth.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.dream.pojo.Role;
import org.dream.pojo.UserInfo;

import java.util.List;

/**
 * @Author 刘牌
 * @Date 2020/4/23 0023 23:58
 * @Version 1.0
 */
@Mapper
public interface AuthMapper {

    /**
     * 查询用户信息
     * @param userName
     * @return
     */
    @Select("select user_id,dept_id,user_name,password from dream_user where user_name = #{userName}")
    public UserInfo getUserInfo(String userName);


    /**
     * 查询用户拥有的角色
     * @param userId
     * @return
     */
    @Select("SELECT r.role_name , ur.role_id FROM dream_user_role ur , dream_role r where ur.user_id = #{userId} and r.role_id = ur.role_id")
    List<Role> getRoleByUserName(Long userId);
}
