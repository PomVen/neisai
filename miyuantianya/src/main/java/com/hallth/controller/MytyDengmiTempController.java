package com.hallth.controller;

import com.hallth.domain.MytyAgenda;
import com.hallth.domain.MytyDengmiTemp;
import com.hallth.domain.MytySeq;
import com.hallth.domain.MytyUser;
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
        Map<String, Object> map = dengmiTempService.selectByUserIdPageQuery(loginUserId, currentPage, pageSize);
        model.addAttribute("data", map);
        return map;
    }

    @RequestMapping(value = "/noAnswerSubject", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> noAnswerSubject(HttpServletRequest request, Model model) {
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int pageSize = Integer.parseInt(request.getParameter("limit"));
        MytyUser userInfo = (MytyUser) request.getSession().getAttribute("loginUserInfo");
        String loginUserId = userInfo.getUserId();
        Map<String, Object> map = dengmiTempService.selectNoAnswersPageQuery(loginUserId, currentPage, pageSize);
        model.addAttribute("data", map);
        return map;
    }

    @RequestMapping(value = "/inputMySubject", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> inputMySubject(HttpServletRequest request, Model model) {
        MytyAgenda agenda = agendaService.getNewAgenda();
        int inputCount = agenda.getInputCount();
        List<MytyDengmiTemp> list = new ArrayList<>(inputCount);
        for (int i = 0; i < inputCount; i++) {
            list.add(new MytyDengmiTemp());
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", inputCount);
        map.put("data", list);
        return map;
    }

    @RequestMapping(value = "/submitMySubject", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> submitMySubject(HttpServletRequest request, Model model) {
        logger.info("添加我的谜题,");
        MytyAgenda agenda = agendaService.getNewAgenda();
        Map<String, Object> map = new HashMap<>();
        int inputCount = agenda.getInputCount();
        MytyUser loginUserInfo = (MytyUser) request.getSession().getAttribute("loginUserInfo");
        for (int i = 0; i < inputCount; i++) {
            int dengmiTempId = Integer.parseInt(request.getParameter("dmTempId" + i));
            String mimian = request.getParameter("dmMimian" + i);
            String mimu = request.getParameter("dmMimu" + i);
            String midi = request.getParameter("dmMidi" + i);
            String mimianzhu = request.getParameter("dmMimianzhu" + i);
            String midizhu = request.getParameter("dmMidizhu" + i);
            MytyDengmiTemp dengmiTemp = new MytyDengmiTemp();
            dengmiTemp.setDmMimian(mimian);
            dengmiTemp.setDmMimu(mimu);
            dengmiTemp.setDmMidi(midi);
            dengmiTemp.setDmMimianzhu(mimianzhu);
            dengmiTemp.setDmMidizhu(midizhu);
            dengmiTemp.setDmAuthor(loginUserInfo.getUserId());
            dengmiTemp.setDmTempId(dengmiTempId);
            //是否存在
            MytyDengmiTemp dengmiTemp2 = dengmiTempService.selectDengmiByTempId(dengmiTemp);
            int a = -999;
            try {
                if (dengmiTemp2 == null) {
                    a = dengmiTempService.insertSingle(dengmiTemp);
                } else {
                    a = dengmiTempService.update(dengmiTemp);
                }
            } catch (Exception e) {
                logger.info("添加失败！请刷新页面重试！" + e.getMessage());
                map.put("msg", "添加失败！请刷新页面重试！" + e.getMessage());
            }
        }
        map.put("msg", "添加成功！");
        return map;
    }

    @RequestMapping(value = "/pingfen", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> pingfen(HttpServletRequest request, Model model) {
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int pageSize = Integer.parseInt(request.getParameter("limit"));
        MytyUser userInfo = (MytyUser) request.getSession().getAttribute("loginUserInfo");
        String loginUserId = userInfo.getUserId();
        Map<String, Object> map = dengmiTempService.selectNoJudgePageQuery(loginUserId, currentPage, pageSize);
        model.addAttribute("data", map);
        return map;
    }

}
