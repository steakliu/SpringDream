package org.dream.basic.pojo.domain;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Menu {

    private Long menuId;

    private String menuName;

    private Long parentId;

    private Integer orderNum;

    private String path;

    private String component;

    private Integer isFrame;

    private String menuType;

    private String visible;

    private String status;

    private String icon;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private List<Menu> children = new LinkedList<>();

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public Long getMenuId() {
        return menuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_menu.menu_id
     *
     * @param menuId the value for dream_menu.menu_id
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_menu.menu_name
     *
     * @return the value of dream_menu.menu_name
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_menu.menu_name
     *
     * @param menuName the value for dream_menu.menu_name
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_menu.parent_id
     *
     * @return the value of dream_menu.parent_id
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_menu.parent_id
     *
     * @param parentId the value for dream_menu.parent_id
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_menu.order_num
     *
     * @return the value of dream_menu.order_num
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_menu.order_num
     *
     * @param orderNum the value for dream_menu.order_num
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_menu.path
     *
     * @return the value of dream_menu.path
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    public String getPath() {
        return path;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_menu.path
     *
     * @param path the value for dream_menu.path
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_menu.component
     *
     * @return the value of dream_menu.component
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    public String getComponent() {
        return component;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_menu.component
     *
     * @param component the value for dream_menu.component
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    public void setComponent(String component) {
        this.component = component == null ? null : component.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_menu.is_frame
     *
     * @return the value of dream_menu.is_frame
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    public Integer getIsFrame() {
        return isFrame;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_menu.is_frame
     *
     * @param isFrame the value for dream_menu.is_frame
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    public void setIsFrame(Integer isFrame) {
        this.isFrame = isFrame;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_menu.menu_type
     *
     * @return the value of dream_menu.menu_type
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    public String getMenuType() {
        return menuType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_menu.menu_type
     *
     * @param menuType the value for dream_menu.menu_type
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    public void setMenuType(String menuType) {
        this.menuType = menuType == null ? null : menuType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_menu.visible
     *
     * @return the value of dream_menu.visible
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    public String getVisible() {
        return visible;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_menu.visible
     *
     * @param visible the value for dream_menu.visible
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    public void setVisible(String visible) {
        this.visible = visible == null ? null : visible.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_menu.status
     *
     * @return the value of dream_menu.status
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_menu.status
     *
     * @param status the value for dream_menu.status
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_menu.icon
     *
     * @return the value of dream_menu.icon
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    public String getIcon() {
        return icon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_menu.icon
     *
     * @param icon the value for dream_menu.icon
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_menu.create_by
     *
     * @return the value of dream_menu.create_by
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_menu.create_by
     *
     * @param createBy the value for dream_menu.create_by
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_menu.create_time
     *
     * @return the value of dream_menu.create_time
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_menu.create_time
     *
     * @param createTime the value for dream_menu.create_time
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_menu.update_by
     *
     * @return the value of dream_menu.update_by
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_menu.update_by
     *
     * @param updateBy the value for dream_menu.update_by
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dream_menu.update_time
     *
     * @return the value of dream_menu.update_time
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dream_menu.update_time
     *
     * @param updateTime the value for dream_menu.update_time
     *
     * @mbg.generated Sun May 17 15:11:57 CST 2020
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", parentId=" + parentId +
                ", orderNum=" + orderNum +
                ", path='" + path + '\'' +
                ", component='" + component + '\'' +
                ", isFrame=" + isFrame +
                ", menuType='" + menuType + '\'' +
                ", visible='" + visible + '\'' +
                ", status='" + status + '\'' +
                ", icon='" + icon + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", children=" + children +
                '}';
    }
}