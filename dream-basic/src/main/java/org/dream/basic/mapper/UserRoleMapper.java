package org.dream.basic.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.dream.basic.pojo.domain.Role;
import org.dream.basic.pojo.domain.UserRole;

import java.util.List;
@Mapper
public interface UserRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dream_user_role
     *
     * @mbg.generated Tue May 26 22:10:17 CST 2020
     */
    int deleteByPrimaryKey(UserRole key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dream_user_role
     *
     * @mbg.generated Tue May 26 22:10:17 CST 2020
     */
    int insert(UserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dream_user_role
     *
     * @mbg.generated Tue May 26 22:10:17 CST 2020
     */
    int insertSelective(UserRole record);

    @Select("select r.role_name , r.role_id from dream_user_role ur , dream_role r where r.role_id = ur.role_id and user_id = #{userId}")
    List<Role> getRoleList(Long userId);
}