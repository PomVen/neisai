package com.hallth.service.impl;

import com.hallth.domain.MytyDengmiTemp;
import com.hallth.mapper.MytyDengmiTempMapper;
import com.hallth.service.MytyDengmiTempService;
import com.hallth.utils.DatabaseUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public Map<String, Object> selectByUserIdPageQuery(String loginUserId, int currentPage, int pageSize) {
        MytyDengmiTemp dengmiTemp = new MytyDengmiTemp();
        dengmiTemp.setDmAuthor(loginUserId);
        dengmiTemp.setPageSize(pageSize);
        dengmiTemp.setStartRow(DatabaseUtils.getStartRow(currentPage,pageSize));
        List<MytyDengmiTemp> list = dengmiTempMapper.selectByUserIdPageQuery(dengmiTemp);
        int total = dengmiTempMapper.selectByUserIdPageQueryCount(dengmiTemp);
        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("total", total);
//        map.put("list", list);
//        map.put("pageCount", pageCount);
//        map.put("pageSize", pageSize);
//        map.put("currentPage", currentPage);
        map.put("code", 0);
        map.put("msg", "");
        map.put("count",total);
        map.put("data",list);
        return map;
    }

    @Override
    public Map<String, Object> selectNoAnswersPageQuery(String loginUserId, int currentPage, int pageSize) {
        MytyDengmiTemp dengmiTemp = new MytyDengmiTemp();
        dengmiTemp.setDmAuthor(loginUserId);
        dengmiTemp.setPageSize(pageSize);
        dengmiTemp.setStartRow(DatabaseUtils.getStartRow(currentPage,pageSize));
        List<MytyDengmiTemp> list = dengmiTempMapper.selectNoAnswersPageQuery(dengmiTemp);
        int total = dengmiTempMapper.selectNoAnswersPageQueryCount(dengmiTemp);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count",total);
        map.put("data",list);
        return map;
    }

//    @Override
//    public List<MytyDengmiTemp> getUnjudgedSubject(String userId, int currentPage, int pageSize) {
//        MytyDengmiTemp dengmiTemp = new MytyDengmiTemp();
//        dengmiTemp.setDmAuthor(userId);
//        dengmiTemp.setPageSize(pageSize);
//        dengmiTemp.setStartRow(DatabaseUtils.getStartRow(currentPage, pageSize));
//        List<MytyDengmiTemp> list = dengmiTempMapper.getUnjudgedSubject(dengmiTemp);
//        return list;
//    }
//
//    @Override
//    public int countUnjudgedSubject(String userId) {
//        MytyDengmiTemp dengmiTemp = new MytyDengmiTemp();
//        dengmiTemp.setDmAuthor(userId);
//        int total = dengmiTempMapper.getUnjudgedSubjectCount(dengmiTemp);
//        return total;
//    }
}
