package com.hallth.service.impl;

import com.hallth.domain.MytyAgenda;
import com.hallth.domain.MytyAnswer;
import com.hallth.domain.SaikuangBean;
import com.hallth.mapper.MytyAnswerMapper;
import com.hallth.service.MytyAgendaService;
import com.hallth.service.MytyAnswerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        } else if("UJ".equals(flag)){
            answerMapper.updateMyJudge(answer);
        }  else if("UR".equals(flag)){
            answerMapper.updateIsRight(answer);
        }
        return 0;
    }

    @Override
    public MytyAnswer getMyAnswer(MytyAnswer answer) {
        return answerMapper.selectAnswer(answer);
    }

    @Override
    public Map<String, Object> getInputAnswerCounts() {
        List<SaikuangBean> list = answerMapper.getInputAnswerCounts();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count",0);
        map.put("data",list);
        return map;
    }

    @Override
    public Map<String, Object> getJudgeCounts() {
        List<SaikuangBean> list = answerMapper.getJudgeCounts();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count",0);
        map.put("data",list);
        return map;
    }

}
