package com.hallth.utils;

import com.hallth.domain.MytyScore;
import com.hallth.domain.MytyUser;
import com.hallth.domain.ScoreQueryBean;
import com.hallth.domain.UserAnswerScore;
import com.hallth.mapper.MytyAnswerMapper;
import com.hallth.mapper.MytyScoreMapper;
import com.hallth.mapper.MytyUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserScoreUtils {

    @Resource
    private MytyScoreMapper scoreMapper;

    public List<MytyScore>  getUserScoreList(MytyScore scoreQueryBean){
        List<MytyScore> userAnswerScoreList = scoreMapper.getScoreByRoundNo(scoreQueryBean);
        return userAnswerScoreList;
    }

    public int getUserScoreListCount(MytyScore scoreQueryBean) {
        return scoreMapper.getScoreByRoundNoCount(scoreQueryBean);
    }
}
