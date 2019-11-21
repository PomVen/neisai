package com.hallth.controller;

import com.hallth.domain.*;
import com.hallth.service.impl.MytyAgendaServiceImpl;
import com.hallth.service.impl.MytyDengmiTempServiceImpl;
import com.hallth.service.impl.MytySeqServiceImpl;
import com.hallth.utils.SeqCreate;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dengmiTemp")
public class MytyDengmiTempController {
    private static Logger logger = Logger.getLogger(MytyDengmiTempController.class.getName());

    @Resource
    private MytyDengmiTempServiceImpl dengmiTempService;
    @Resource
    private MytyAgendaServiceImpl agendaService;
    @Resource
    private SeqCreate seqCreate;

    @RequestMapping(value = "/toMySubject", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> toMySubject(HttpServletRequest request, Model model) {
        logger.info("查询灯谜信息，param");
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int pageSize = Integer.parseInt(request.getParameter("limit"));
        MytyUser userInfo = (MytyUser) request.getSession().getAttribute("loginUserInfo");
        String loginUserId = userInfo.getUserId();
        MytyAgenda agenda = agendaService.getNewAgenda();
        Map<String, Object> map = dengmiTempService.selectByUserIdPageQuery(agenda.getRoundNo(), loginUserId, currentPage, pageSize);
        return map;
    }

    @RequestMapping(value = "/noAnswerSubject", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> noAnswerSubject(HttpServletRequest request, Model model) {
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int pageSize = Integer.parseInt(request.getParameter("limit"));
        MytyUser userInfo = (MytyUser) request.getSession().getAttribute("loginUserInfo");
        String loginUserId = userInfo.getUserId();
        MytyAgenda agenda = agendaService.getNewAgenda();
        Map<String, Object> map = dengmiTempService.selectNoAnswersPageQuery(agenda.getRoundNo(), loginUserId, currentPage, pageSize);
        return map;
    }

    @RequestMapping(value = "/inputMySubject", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> inputMySubject(HttpServletRequest request, Model model) {
        MytyAgenda agenda = agendaService.getNewAgenda();
        int inputCount = agenda.getInputCount();
        MytyUser userInfo = (MytyUser)request.getSession().getAttribute("loginUserInfo");
        String loginUserId = userInfo.getUserId();
        Map<String, Object> map = dengmiTempService.selectByUserIdPageQuery(agenda.getRoundNo(),loginUserId, 1, Integer.MAX_VALUE);
        List<MytyDengmiTemp> list = (List<MytyDengmiTemp>)map.get("data");
        if(list == null || list.size() == 0){
            for(int i = 0; i < inputCount; i ++){
                MytyDengmiTemp dengmi = createDengmiTemp();
                list.add(dengmi);
            }
        } else {
            for(int i = 0; i < inputCount - list.size(); i ++){
                MytyDengmiTemp dengmi = createDengmiTemp();
                list.add(dengmi);
            }
        }
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", inputCount);
        map.put("data", list);
        return map;
    }

    public MytyDengmiTemp createDengmiTemp(){
        int dengmiTempId = seqCreate.getNextDengmiTempId();
        MytyDengmiTemp dengmi = new MytyDengmiTemp();
        dengmi.setDmTempId(dengmiTempId);
        return dengmi;
    }

    @RequestMapping(value = "/submitMySubject", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> submitMySubject(@RequestParam("dmTempId")int dmTempId, @RequestParam("colName")String colName, @RequestParam("colValue") String colValue,  HttpServletRequest request, Model model) {
        logger.info("添加我的谜题,");
        MytyAgenda agenda = agendaService.getNewAgenda();
        Map<String, Object> map = new HashMap<>();
        int inputCount = agenda.getInputCount();
        MytyUser loginUserInfo = (MytyUser) request.getSession().getAttribute("loginUserInfo");
        for (int i = 0; i < inputCount; i++) {
            MytyDengmiTemp dengmiTemp = new MytyDengmiTemp();
            if(colName.equals("dmMimian")){
                dengmiTemp.setDmMimian(colValue);
            } else if(colName.equals("dmMimu")){
                dengmiTemp.setDmMimu(colValue);
            } else if(colName.equals("dmMidi")){
                dengmiTemp.setDmMidi(colValue);
            } else if(colName.equals("dmMimianzhu")){
                dengmiTemp.setDmMimianzhu(colValue);
            } else if(colName.equals("dmMidizhu")){
                dengmiTemp.setDmMidizhu(colValue);
            }
            dengmiTemp.setDmAuthor(loginUserInfo.getUserId());
            dengmiTemp.setDmTempId(dmTempId);
            dengmiTemp.setAgendaRoundNo(agenda.getRoundNo());
            //是否存在
            MytyDengmiTemp dengmiTemp2 = dengmiTempService.selectDengmiByTempId(dengmiTemp);
            int a = -999;
            try {
                if (dengmiTemp2 == null) {
                    a = dengmiTempService.insertSingle(dengmiTemp);
                } else {
                    a = dengmiTempService.update(dengmiTemp);
                }
                map.put("result", true);
                map.put("msg", "添加成功！");
            } catch (Exception e) {
                logger.info("添加失败！请刷新页面重试！" + e.getMessage());
                map.put("result", false);
                map.put("msg", "添加失败！请刷新页面重试！" + e.getMessage());
            }
        }
        return map;
    }

    @RequestMapping(value = "/pingfen", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> pingfen(HttpServletRequest request, Model model) {
        MytyAgenda agenda = agendaService.getNewAgenda();
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int pageSize = Integer.parseInt(request.getParameter("limit"));
        MytyUser userInfo = (MytyUser) request.getSession().getAttribute("loginUserInfo");
        String loginUserId = userInfo.getUserId();
        Map<String, Object> map = dengmiTempService.selectNoJudgePageQuery(agenda.getRoundNo(), loginUserId, currentPage, pageSize);
        return map;
    }

    @RequestMapping(value = "/liezhong", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> liezhong(HttpServletRequest request, Model model) {
        MytyAgenda agenda = agendaService.getNewAgenda();
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int pageSize = Integer.parseInt(request.getParameter("limit"));
        MytyUser userInfo = (MytyUser) request.getSession().getAttribute("loginUserInfo");
        String loginUserId = userInfo.getUserId();
        Map<String, Object> map = dengmiTempService.selectYidi(agenda.getRoundNo(), loginUserId, currentPage, pageSize);
        return map;
    }

    @RequestMapping(value = "/getDengmiByRoundNo", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> getDengmiByRoundNo(HttpServletRequest request, Model model) {
        MytyAgenda agenda = agendaService.getNewAgenda();
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int pageSize = Integer.parseInt(request.getParameter("limit"));
        int roundNo = agenda.getRoundNo();
        if(request.getParameter("roundNo") == null || request.getParameter("roundNo").equals("")){
            roundNo = agenda.getRoundNo();
        } else {
            roundNo = Integer.parseInt(request.getParameter("roundNo"));
        }
        Map<String, Object> map = dengmiTempService.getDengmiByRoundNo(roundNo, currentPage, pageSize);
        return map;
    }

    @RequestMapping(value = "/goodSubject", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> goodSubject(HttpServletRequest request, Model model) {
        MytyAgenda agenda = agendaService.getNewAgenda();
        int roundNo = agenda.getRoundNo();
        if(request.getParameter("roundNo") == null || request.getParameter("roundNo").equals("")){
            roundNo = agenda.getRoundNo();
        } else {
            roundNo = Integer.parseInt(request.getParameter("roundNo"));
        }
        Map<String, Object> map = dengmiTempService.getGoodSubjectByRoundNo(roundNo);
        return map;
    }
}
