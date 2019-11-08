package com.hallth.service;

import com.hallth.domain.MytyDengmiTemp;

import java.util.List;

public interface MytyDengmiTempService {
    List<MytyDengmiTemp> selectByUserId(String loginUserId);

    List<MytyDengmiTemp> selectNoAnswers(String loginUserId);
}
