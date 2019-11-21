package com.hallth.service.impl;

import com.hallth.domain.MytyAgenda;
import com.hallth.domain.MytyAnswer;
import com.hallth.domain.SaikuangBean;
import com.hallth.domain.ScoreQueryBean;
import com.hallth.mapper.MytyAnswerMapper;
import com.hallth.service.MytyAgendaService;
import com.hallth.service.MytyAnswerService;
import com.hallth.utils.DatabaseUtils;
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
    public Map<String, Object> getInputAnswerCounts(MytyAgenda agenda) {
        List<SaikuangBean> list = answerMapper.getInputAnswerCounts(agenda);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count",0);
        map.put("data",list);
        return map;
    }

    @Override
    public Map<String, Object> getJudgeCounts(MytyAgenda agenda) {
        List<SaikuangBean> list = answerMapper.getJudgeCounts(agenda);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count",0);
        map.put("data",list);
        return map;
    }

    @Override
    public Map<String, Object> getAnswerScoreInfo(int roundNo, int currentPage, int pageSize) {
        ScoreQueryBean scoreQueryBean = new ScoreQueryBean();
        scoreQueryBean.setAgenda_round_no(roundNo);
        scoreQueryBean.setStartRow(DatabaseUtils.getStartRow(currentPage, pageSize));
        scoreQueryBean.setPageSize(pageSize);
        List<SaikuangBean> list = answerMapper.getAnswerScoreInfo(scoreQueryBean);
        int total = answerMapper.getAnswerScoreInfoCount(scoreQueryBean);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count",total);
        map.put("data",list);
        return map;
    }

    @Override
    public Map<String, Object> getSubjectScoreInfo(int roundNo, int currentPage, int pageSize) {
        ScoreQueryBean scoreQueryBean = new ScoreQueryBean();
        scoreQueryBean.setAgenda_round_no(roundNo);
        scoreQueryBean.setStartRow(DatabaseUtils.getStartRow(currentPage, pageSize));
        scoreQueryBean.setPageSize(pageSize);
        List<SaikuangBean> list = answerMapper.getSubjectScoreInfo(scoreQueryBean);
        int total = answerMapper.getSubjectScoreInfoCount(scoreQueryBean);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count",total);
        map.put("data",list);
        return map;
    }

}
