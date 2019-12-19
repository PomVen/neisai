package com.hallth.mapper;

import com.hallth.domain.*;

import java.util.List;

public interface MytyDengmiTempMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table myty_dengmi_temp
     *
     * @mbggenerated
     */
    int insert(MytyDengmiTemp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table myty_dengmi_temp
     *
     * @mbggenerated
     */
    int insertSelective(MytyDengmiTemp record);

    List<MytyDengmiTemp> selectByUserId(MytyDengmiTemp dengmiTemp);

    List<MytyDengmiTemp> selectNoAnswers(MytyDengmiTemp dengmiTemp);

    List<MytyDengmiTemp> selectByUserIdPageQuery(MytyDengmiTemp dengmiTemp);
    int selectByUserIdPageQueryCount(MytyDengmiTemp dengmiTemp);


    List<MytyDengmiTemp> selectNoAnswersPageQuery(MytyDengmiTemp dengmiTemp);

    int selectNoAnswersPageQueryCount(MytyDengmiTemp dengmiTemp);

    List<MytyDengmiTemp> getUnjudgedSubject(MytyDengmiTemp dengmiTemp);

    int getUnjudgedSubjectCount(MytyDengmiTemp dengmiTemp);

    int insertByList(List<MytyDengmiTemp> mySubjectList);

    MytyDengmiTemp selectById(MytyDengmiTemp dengmiTemp);

    int update(MytyDengmiTemp dengmiTemp);

    List<MytyAnswerQueryBean> selectNoJudgePageQuery(MytyDengmiTemp dengmiTemp);

    int selectNoJudgePageQueryCount(MytyDengmiTemp dengmiTemp);

    List<MytyAnswerQueryBean> selectYidi(MytyDengmiTemp dengmiTemp);

    int countYidi(MytyDengmiTemp dengmiTemp);

    List<SaikuangBean> getInputSubjectCounts(MytyAgenda agenda);

    List<DengmiQueryBean> getDengmiByRoundNo(DengmiQueryBean queryBean);

    int getDengmiByRoundNoCount(DengmiQueryBean queryBean);

    List<DengmiQueryBean> getGoodSubjectByRoundNo(DengmiQueryBean queryBean);

    int getGoodSubjectByRoundNoCount(DengmiQueryBean queryBean);

    List<ScoreQueryBean> userCompetitionDetail(ScoreQueryBean queryBean);

    int userCompetitionDetailCount(ScoreQueryBean queryBean);

    List<DengmiQueryBean> dengmiDetailTable(DengmiQueryBean dengmiQueryBean);
}