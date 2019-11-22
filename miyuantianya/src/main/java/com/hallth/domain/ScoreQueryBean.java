package com.hallth.domain;

public class ScoreQueryBean {
    private int agenda_round_no;
    private String user_id;
    private String user_name;
    private String dm_author_id;
    private String dm_author_name;
    private int sum_score;
    private int user_answer_score;
    private int user_subject_score;
    private int dm_id;
    private int right_count;
    private int times;
    private float avg_sum_score;
    private float avg_subject_score;
    private float avg_answer_score;
    private int user_ans_score;

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public float getAvg_sum_score() {
        return avg_sum_score;
    }

    public void setAvg_sum_score(float avg_sum_score) {
        this.avg_sum_score = avg_sum_score;
    }

    public float getAvg_subject_score() {
        return avg_subject_score;
    }

    public void setAvg_subject_score(float avg_subject_score) {
        this.avg_subject_score = avg_subject_score;
    }

    public float getAvg_answer_score() {
        return avg_answer_score;
    }

    public void setAvg_answer_score(float avg_answer_score) {
        this.avg_answer_score = avg_answer_score;
    }

    public int getUser_ans_score() {
        return user_ans_score;
    }

    public void setUser_ans_score(int user_ans_score) {
        this.user_ans_score = user_ans_score;
    }

    private int startRow;
    private int pageSize;

    public int getSum_score() {
        return sum_score;
    }

    public void setSum_score(int sum_score) {
        this.sum_score = sum_score;
    }

    public String getDm_author_id() {
        return dm_author_id;
    }

    public void setDm_author_id(String dm_author_id) {
        this.dm_author_id = dm_author_id;
    }

    public String getDm_author_name() {
        return dm_author_name;
    }

    public void setDm_author_name(String dm_author_name) {
        this.dm_author_name = dm_author_name;
    }

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

    public int getAgenda_round_no() {
        return agenda_round_no;
    }

    public void setAgenda_round_no(int agenda_round_no) {
        this.agenda_round_no = agenda_round_no;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getUser_answer_score() {
        return user_answer_score;
    }

    public void setUser_answer_score(int user_answer_score) {
        this.user_answer_score = user_answer_score;
    }

    public int getUser_subject_score() {
        return user_subject_score;
    }

    public void setUser_subject_score(int user_subject_score) {
        this.user_subject_score = user_subject_score;
    }

    public int getDm_id() {
        return dm_id;
    }

    public void setDm_id(int dm_id) {
        this.dm_id = dm_id;
    }

    public int getRight_count() {
        return right_count;
    }

    public void setRight_count(int right_count) {
        this.right_count = right_count;
    }
}
