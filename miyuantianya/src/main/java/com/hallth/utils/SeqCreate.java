package com.hallth.utils;

import com.hallth.domain.MytySeq;
import com.hallth.service.impl.MytySeqServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SeqCreate {

    @Resource
    private MytySeqServiceImpl seqService;

    public String getNextUserId(){
        MytySeq seq = new MytySeq();
        seq.setSeqName("user_id");
        int nextUserId = seqService.getNextId(seq);
        String userIdStr = "MYTY_";
        if(nextUserId < 10){
            userIdStr = userIdStr + "00" + nextUserId;
        } else if(nextUserId < 100 && nextUserId >= 10){
            userIdStr = userIdStr + "0" + nextUserId;
        } else {
            userIdStr = userIdStr + nextUserId;
        }
        seq.setNextId(nextUserId+1);
        seqService.updateNextId(seq);
        return userIdStr;
    }
}
