package com.hallth.service.impl;

import com.hallth.domain.MytyDengmiTemp;
import com.hallth.mapper.MytyDengmiTempMapper;
import com.hallth.service.MytyDengmiTempService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MytyDengmiTempServiceImpl implements MytyDengmiTempService {

    @Resource
    private MytyDengmiTempMapper dengmiTempMapper;

    @Override
    public List<MytyDengmiTemp> selectByUserId(String loginUserId) {
        MytyDengmiTemp dengmiTemp = new MytyDengmiTemp();
        dengmiTemp.setDmAuthor(loginUserId);
        List<MytyDengmiTemp> list = dengmiTempMapper.selectByUserId(dengmiTemp);
        return list;
    }

    @Override
    public List<MytyDengmiTemp> selectNoAnswers(String loginUserId) {
        MytyDengmiTemp dengmiTemp = new MytyDengmiTemp();
        dengmiTemp.setDmAuthor(loginUserId);
        List<MytyDengmiTemp> list = dengmiTempMapper.selectNoAnswers(dengmiTemp);
        return list;
    }
}
