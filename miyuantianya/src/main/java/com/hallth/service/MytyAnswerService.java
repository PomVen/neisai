package com.hallth.service;

import com.hallth.domain.MytyAnswer;

public interface MytyAnswerService {
    int saveMyAnswer(MytyAnswer answer, String flag);

    MytyAnswer getMyAnswer(MytyAnswer answer);

}
