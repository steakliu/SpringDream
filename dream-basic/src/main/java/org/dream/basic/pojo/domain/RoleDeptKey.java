package org.dream.basic.pojo.domain;

public class RoleDeptKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dream_role_dept.role_id
     *
     * @mbg.generated Tue May 26 22:12:13 CST 2020
     */
    private Long roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dream_role_dept.dept_id
     *
     * @mbg.generated Tue May 26 22:12:13 CST 2020
     */
    private Long deptId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_role_dept.role_id
     *
     * @return the value of dream_role_dept.role_id
     *
     * @mbg.generated Tue May 26 22:12:13 CST 2020
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_role_dept.role_id
     *
     * @param roleId the value for dream_role_dept.role_id
     *
     * @mbg.generated Tue May 26 22:12:13 CST 2020
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_role_dept.dept_id
     *
     * @return the value of dream_role_dept.dept_id
     *
     * @mbg.generated Tue May 26 22:12:13 CST 2020
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_role_dept.dept_id
     *
     * @param deptId the value for dream_role_dept.dept_id
     *
     * @mbg.generated Tue May 26 22:12:13 CST 2020
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }
}