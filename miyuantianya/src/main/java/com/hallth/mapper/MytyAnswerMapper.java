package com.hallth.mapper;

import com.hallth.domain.MytyAgenda;
import com.hallth.domain.MytyAnswer;
import com.hallth.domain.SaikuangBean;
import com.hallth.domain.ScoreQueryBean;

import java.util.List;

public interface MytyAnswerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table myty_answer
     *
     * @mbggenerated
     */
    int insert(MytyAnswer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table myty_answer
     *
     * @mbggenerated
     */
    int insertSelective(MytyAnswer record);

    MytyAnswer selectAnswer(MytyAnswer answer);

    int updateMyAnswer(MytyAnswer answer);
    int updateMyJudge(MytyAnswer answer);

    int updateIsRight(MytyAnswer answer);

    List<SaikuangBean> getInputAnswerCounts(MytyAgenda agenda);

    List<SaikuangBean> getJudgeCounts(MytyAgenda agenda);

    List<SaikuangBean> getAnswerScoreInfo(ScoreQueryBean scoreQueryBean);

    int getAnswerScoreInfoCount(ScoreQueryBean scoreQueryBean);
}