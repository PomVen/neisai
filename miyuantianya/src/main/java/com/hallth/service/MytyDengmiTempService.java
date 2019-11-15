package com.hallth.service;

import com.hallth.domain.MytyDengmiTemp;

import java.util.List;
import java.util.Map;

public interface MytyDengmiTempService {
    List<MytyDengmiTemp> selectByUserId(String loginUserId);

    List<MytyDengmiTemp> selectNoAnswers(String loginUserId);

    Map<String, Object> selectByUserIdPageQuery(String loginUserId , int currentPage, int pageSize);

    Map<String, Object> selectNoAnswersPageQuery(String loginUserId, int currentPage, int pageSize);

    int insertByList(List<MytyDengmiTemp> mySubjectList);

    MytyDengmiTemp selectDengmiByTempId(MytyDengmiTemp dengmiTemp);

    int insertSingle(MytyDengmiTemp dengmiTemp);

    int update(MytyDengmiTemp dengmiTemp);

    Map<String, Object> selectNoJudgePageQuery(String loginUserId, int currentPage, int pageSize);

    Map<String, Object> selectYidi(String loginUserId, int currentPage, int pageSize);

//    List<MytyDengmiTemp> getUnjudgedSubject(String userId, int currentPage, int pageSize);
//
//    int countUnjudgedSubject(String userId);
}
