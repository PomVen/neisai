package com.hallth.domain;

public class MytyMenu {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myty_menu.menu_id
     *
     * @mbggenerated
     */
    private String menuId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myty_menu.menu_name
     *
     * @mbggenerated
     */
    private String menuName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myty_menu.menu_path
     *
     * @mbggenerated
     */
    private String menuPath;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myty_menu.menu_role
     *
     * @mbggenerated
     */
    private String menuRole;

    private int menuType;

    public int getMenuType() {
        return menuType;
    }

    public void setMenuType(int menuType) {
        this.menuType = menuType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myty_menu.menu_id
     *
     * @return the value of myty_menu.menu_id
     *
     * @mbggenerated
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myty_menu.menu_id
     *
     * @param menuId the value for myty_menu.menu_id
     *
     * @mbggenerated
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myty_menu.menu_name
     *
     * @return the value of myty_menu.menu_name
     *
     * @mbggenerated
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myty_menu.menu_name
     *
     * @param menuName the value for myty_menu.menu_name
     *
     * @mbggenerated
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myty_menu.menu_path
     *
     * @return the value of myty_menu.menu_path
     *
     * @mbggenerated
     */
    public String getMenuPath() {
        return menuPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myty_menu.menu_path
     *
     * @param menuPath the value for myty_menu.menu_path
     *
     * @mbggenerated
     */
    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myty_menu.menu_role
     *
     * @return the value of myty_menu.menu_role
     *
     * @mbggenerated
     */
    public String getMenuRole() {
        return menuRole;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myty_menu.menu_role
     *
     * @param menuRole the value for myty_menu.menu_role
     *
     * @mbggenerated
     */
    public void setMenuRole(String menuRole) {
        this.menuRole = menuRole;
    }
}