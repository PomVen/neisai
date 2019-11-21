package com.hallth.service.impl;

import com.hallth.domain.*;
import com.hallth.mapper.MytyDengmiTempMapper;
import com.hallth.service.MytyDengmiTempService;
import com.hallth.utils.DatabaseUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String, Object> selectByUserIdPageQuery(int roundNo, String loginUserId, int currentPage, int pageSize) {
        MytyDengmiTemp dengmiTemp = new MytyDengmiTemp();
        dengmiTemp.setDmAuthor(loginUserId);
        dengmiTemp.setPageSize(pageSize);
        dengmiTemp.setStartRow(DatabaseUtils.getStartRow(currentPage,pageSize));
        dengmiTemp.setAgendaRoundNo(roundNo);
        List<MytyDengmiTemp> list = dengmiTempMapper.selectByUserIdPageQuery(dengmiTemp);
        int total = dengmiTempMapper.selectByUserIdPageQueryCount(dengmiTemp);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count",total);
        map.put("data",list);
        return map;
    }

    @Override
    public Map<String, Object> selectNoAnswersPageQuery(int roundNo, String loginUserId, int currentPage, int pageSize) {
        MytyDengmiTemp dengmiTemp = new MytyDengmiTemp();
        dengmiTemp.setDmAuthor(loginUserId);
        dengmiTemp.setPageSize(pageSize);
        dengmiTemp.setStartRow(DatabaseUtils.getStartRow(currentPage,pageSize));
        dengmiTemp.setAgendaRoundNo(roundNo);
        List<MytyDengmiTemp> list = dengmiTempMapper.selectNoAnswersPageQuery(dengmiTemp);
        int total = dengmiTempMapper.selectNoAnswersPageQueryCount(dengmiTemp);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count",total);
        map.put("data",list);
        return map;
    }

    @Override
    public int insertByList(List<MytyDengmiTemp> mySubjectList) {
        int i = dengmiTempMapper.insertByList(mySubjectList);
        return i;
    }

    @Override
    @Transactional()
    public MytyDengmiTemp selectDengmiByTempId(MytyDengmiTemp dengmiTemp) {
        return dengmiTempMapper.selectById(dengmiTemp);
    }

    @Override
    public int insertSingle(MytyDengmiTemp dengmiTemp) {
        return dengmiTempMapper.insert(dengmiTemp);
    }

    @Override
    public int update(MytyDengmiTemp dengmiTemp) {
        return dengmiTempMapper.update(dengmiTemp);
    }


    @Override
    public Map<String, Object> selectNoJudgePageQuery(int roundNo, String userId, int currentPage, int pageSize) {
        MytyDengmiTemp dengmiTemp = new MytyDengmiTemp();
        dengmiTemp.setDmAuthor(userId);
        dengmiTemp.setPageSize(pageSize);
        dengmiTemp.setStartRow(DatabaseUtils.getStartRow(currentPage,pageSize));
        dengmiTemp.setAgendaRoundNo(roundNo);
        List<MytyAnswerQueryBean> list = dengmiTempMapper.selectNoJudgePageQuery(dengmiTemp);
        int total = dengmiTempMapper.selectNoJudgePageQueryCount(dengmiTemp);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count",total);
        map.put("data",list);
        return map;
    }

    @Override
    public Map<String, Object> selectYidi(int roundNo, String loginUserId, int currentPage, int pageSize) {
        MytyDengmiTemp dengmiTemp = new MytyDengmiTemp();
        dengmiTemp.setDmAuthor(loginUserId);
        dengmiTemp.setPageSize(pageSize);
        dengmiTemp.setStartRow(DatabaseUtils.getStartRow(currentPage,pageSize));
        dengmiTemp.setAgendaRoundNo(roundNo);
        List<MytyAnswerQueryBean> list = dengmiTempMapper.selectYidi(dengmiTemp);
        int total = dengmiTempMapper.countYidi(dengmiTemp);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count",total);
        map.put("data",list);
        return map;
    }

    @Override
    public Map<String, Object> getInputSubjectCounts(MytyAgenda agenda) {
        List<SaikuangBean> list = dengmiTempMapper.getInputSubjectCounts(agenda);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count",0);
        map.put("data",list);
        return map;
    }

    @Override
    public Map<String, Object> getDengmiByRoundNo(Integer roundNo, int currentPage, int pageSize) {
        DengmiQueryBean queryBean = new DengmiQueryBean();
        queryBean.setAgenda_round_no(roundNo);
        queryBean.setStartRow(DatabaseUtils.getStartRow(currentPage, pageSize));
        queryBean.setPageSize(pageSize);
        List<DengmiQueryBean> list = dengmiTempMapper.getDengmiByRoundNo(queryBean);
        int total = dengmiTempMapper.getDengmiByRoundNoCount(queryBean);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count",total);
        map.put("data",list);
        return map;
    }

    @Override
    public Map<String, Object> getGoodSubjectByRoundNo(int roundNo) {
        DengmiQueryBean queryBean = new DengmiQueryBean();
        queryBean.setAgenda_round_no(roundNo);
        List<DengmiQueryBean> list = dengmiTempMapper.getGoodSubjectByRoundNo(queryBean);
        int total = dengmiTempMapper.getGoodSubjectByRoundNoCount(queryBean);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count",total);
        map.put("data",list);
        return map;
    }
}
