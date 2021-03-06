package com.hallth.domain;

public class MytyUser {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myty_user.user_id
     *
     * @mbggenerated
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myty_user.user_name
     *
     * @mbggenerated
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myty_user.user_role
     *
     * @mbggenerated
     */
    private String userRole;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myty_user.user_password
     *
     * @mbggenerated
     */
    private String userPassword;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myty_user.user_password
     *
     * @mbggenerated
     */
    private Integer isDeveloper;

    public Integer getIsDeveloper() {
        return isDeveloper;
    }

    public void setIsDeveloper(Integer isDeveloper) {
        this.isDeveloper = isDeveloper;
    }

    private int startRow;
    private int pageSize;

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myty_user.user_id
     *
     * @return the value of myty_user.user_id
     *
     * @mbggenerated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myty_user.user_id
     *
     * @param userId the value for myty_user.user_id
     *
     * @mbggenerated
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myty_user.user_name
     *
     * @return the value of myty_user.user_name
     *
     * @mbggenerated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myty_user.user_name
     *
     * @param userName the value for myty_user.user_name
     *
     * @mbggenerated
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myty_user.user_role
     *
     * @return the value of myty_user.user_role
     *
     * @mbggenerated
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myty_user.user_role
     *
     * @param userRole the value for myty_user.user_role
     *
     * @mbggenerated
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myty_user.user_password
     *
     * @return the value of myty_user.user_password
     *
     * @mbggenerated
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myty_user.user_password
     *
     * @param userPassword the value for myty_user.user_password
     *
     * @mbggenerated
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "MytyUser{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userRole='" + userRole + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }

    public MytyUser(String userId, String userName, String userRole, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userRole = userRole;
        this.userPassword = userPassword;
    }

    public MytyUser() {
    }
}