package com.hallth.domain;

public class MytyParam {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myty_param.param_id
     *
     * @mbggenerated
     */
    private String paramId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myty_param.param_value
     *
     * @mbggenerated
     */
    private String paramValue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myty_param.param_desc
     *
     * @mbggenerated
     */
    private String paramDesc;

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
     * This method returns the value of the database column myty_param.param_id
     *
     * @return the value of myty_param.param_id
     *
     * @mbggenerated
     */
    public String getParamId() {
        return paramId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myty_param.param_id
     *
     * @param paramId the value for myty_param.param_id
     *
     * @mbggenerated
     */
    public void setParamId(String paramId) {
        this.paramId = paramId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myty_param.param_value
     *
     * @return the value of myty_param.param_value
     *
     * @mbggenerated
     */
    public String getParamValue() {
        return paramValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myty_param.param_value
     *
     * @param paramValue the value for myty_param.param_value
     *
     * @mbggenerated
     */
    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myty_param.param_desc
     *
     * @return the value of myty_param.param_desc
     *
     * @mbggenerated
     */
    public String getParamDesc() {
        return paramDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myty_param.param_desc
     *
     * @param paramDesc the value for myty_param.param_desc
     *
     * @mbggenerated
     */
    public void setParamDesc(String paramDesc) {
        this.paramDesc = paramDesc;
    }
}