package com.hallth.mapper;

import com.hallth.domain.MytyDengmi;

public interface MytyDengmiMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table myty_dengmi
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer dmId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table myty_dengmi
     *
     * @mbggenerated
     */
    int insert(MytyDengmi record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table myty_dengmi
     *
     * @mbggenerated
     */
    int insertSelective(MytyDengmi record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table myty_dengmi
     *
     * @mbggenerated
     */
    MytyDengmi selectByPrimaryKey(Integer dmId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table myty_dengmi
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(MytyDengmi record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table myty_dengmi
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(MytyDengmi record);
}