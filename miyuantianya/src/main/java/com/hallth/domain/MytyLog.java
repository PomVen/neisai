package com.hallth.domain;

import java.util.Date;

public class MytyLog {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myty_log.oper_time
     *
     * @mbggenerated
     */
    private Date operTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myty_log.oper_desc
     *
     * @mbggenerated
     */
    private String operDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column myty_log.agenda_round_no
     *
     * @mbggenerated
     */
    private Integer agendaRoundNo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myty_log.oper_time
     *
     * @return the value of myty_log.oper_time
     *
     * @mbggenerated
     */
    public Date getOperTime() {
        return operTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myty_log.oper_time
     *
     * @param operTime the value for myty_log.oper_time
     *
     * @mbggenerated
     */
    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myty_log.oper_desc
     *
     * @return the value of myty_log.oper_desc
     *
     * @mbggenerated
     */
    public String getOperDesc() {
        return operDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myty_log.oper_desc
     *
     * @param operDesc the value for myty_log.oper_desc
     *
     * @mbggenerated
     */
    public void setOperDesc(String operDesc) {
        this.operDesc = operDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column myty_log.agenda_round_no
     *
     * @return the value of myty_log.agenda_round_no
     *
     * @mbggenerated
     */
    public Integer getAgendaRoundNo() {
        return agendaRoundNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column myty_log.agenda_round_no
     *
     * @param agendaRoundNo the value for myty_log.agenda_round_no
     *
     * @mbggenerated
     */
    public void setAgendaRoundNo(Integer agendaRoundNo) {
        this.agendaRoundNo = agendaRoundNo;
    }
}