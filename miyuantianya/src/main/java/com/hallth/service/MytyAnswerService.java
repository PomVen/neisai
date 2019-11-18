package com.hallth.service;

import com.hallth.domain.MytyAnswer;

import java.util.Map;

public interface MytyAnswerService {
    int saveMyAnswer(MytyAnswer answer, String flag);

    MytyAnswer getMyAnswer(MytyAnswer answer);

    Map<String, Object> getInputAnswerCounts();

    Map<String, Object> getJudgeCounts();
}
