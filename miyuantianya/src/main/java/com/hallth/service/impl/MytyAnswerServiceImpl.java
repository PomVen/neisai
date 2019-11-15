package com.hallth.service.impl;

import com.hallth.domain.MytyAgenda;
import com.hallth.domain.MytyAnswer;
import com.hallth.mapper.MytyAnswerMapper;
import com.hallth.service.MytyAgendaService;
import com.hallth.service.MytyAnswerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MytyAnswerServiceImpl implements MytyAnswerService {


    @Resource
    private MytyAnswerMapper answerMapper;

    @Override
    public int saveMyAnswer(MytyAnswer answer, String flag) {
        if("I".equals(flag)){
            answerMapper.insert(answer);
        } else if("U".equals(flag)){
            answerMapper.updateMyAnswer(answer);
        }
        return 0;
    }

    @Override
    public MytyAnswer getMyAnswer(MytyAnswer answer) {
        return answerMapper.selectAnswer(answer);
    }

}
