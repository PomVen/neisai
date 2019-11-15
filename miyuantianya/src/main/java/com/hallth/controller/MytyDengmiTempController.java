package com.hallth.controller;

import com.hallth.domain.MytyAgenda;
import com.hallth.domain.MytyDengmiTemp;
import com.hallth.domain.MytyUser;
import com.hallth.service.impl.MytyAgendaServiceImpl;
import com.hallth.service.impl.MytyDengmiTempServiceImpl;
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

    @RequestMapping(value="/toMySubject", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> toMySubject( HttpServletRequest request, Model model){
        logger.info("查询灯谜信息，param");
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int pageSize = Integer.parseInt(request.getParameter("limit"));
        MytyUser userInfo = (MytyUser)request.getSession().getAttribute("loginUserInfo");
        String loginUserId = userInfo.getUserId();
        Map<String, Object> map = dengmiTempService.selectByUserIdPageQuery(loginUserId, currentPage, pageSize);
        model.addAttribute("data",map);
        return map;
    }

    @RequestMapping(value="/noAnswerSubject", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> noAnswerSubject( HttpServletRequest request, Model model){
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int pageSize = Integer.parseInt(request.getParameter("limit"));
        MytyUser userInfo = (MytyUser)request.getSession().getAttribute("loginUserInfo");
        String loginUserId = userInfo.getUserId();
        Map<String, Object> map = dengmiTempService.selectNoAnswersPageQuery(loginUserId, currentPage, pageSize);
        model.addAttribute("data",map);
        return map;
    }

    @RequestMapping(value="/inputMySubject", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> inputMySubject( HttpServletRequest request, Model model){
        MytyAgenda agenda = agendaService.getNewAgenda();
        int inputCount = agenda.getInputCount();
        List<MytyDengmiTemp> list = new ArrayList<>(inputCount);
        for(int i = 0; i < inputCount; i ++){
            list.add(new MytyDengmiTemp());
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count",inputCount);
        map.put("data",list);
        return map;
    }

    @RequestMapping(value="/submitMySubject", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> submitMySubject(@RequestParam("list")List<MytyDengmiTemp> list, HttpServletRequest request, Model model){
        logger.info("添加我的谜题,");
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "添加成功！");
        return map;
    }

//    @RequestMapping(value="/pingfen", method = {RequestMethod.GET, RequestMethod.POST})
//    public Map<String, Object> pingfen(HttpServletRequest request, Model model){
//        logger.info("评分,");
//        Map<String, Object> map = new HashMap<>();
//        MytyUser loginUserInfo = (MytyUser)request.getSession().getAttribute("loginUserInfo");
//        String userId = loginUserInfo.getUserId();
//        logger.info("查询需要用户评分的灯谜");
//        int currentPage = Integer.parseInt(request.getParameter("page"));
//        int pageSize = Integer.parseInt(request.getParameter("limit"));
//        List<MytyDengmiTemp> list = dengmiTempService.getUnjudgedSubject(userId, currentPage, pageSize);
//        int count = dengmiTempService.countUnjudgedSubject(userId);
//        map.put("code", 0);
//        map.put("msg", "");
//        map.put("count",count);
//        map.put("data",list);
//        return map;
//    }

}
