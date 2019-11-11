package com.hallth.controller;

import com.hallth.domain.MytyAgenda;
import com.hallth.domain.MytyDengmiTemp;
import com.hallth.domain.MytyUser;
import com.hallth.service.impl.MytyAgendaServiceImpl;
import com.hallth.service.impl.MytyDengmiTempServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/page")
public class PageController {

    @Resource
    private MytyAgendaServiceImpl agendaService;
    @Resource
    private MytyDengmiTempServiceImpl dengmiTempService;

    @RequestMapping(value="/toInputMySubject", method = {RequestMethod.GET, RequestMethod.POST})
    public String toInputMySubject(HttpServletRequest request, Model model){
        MytyAgenda agenda = agendaService.getNewAgenda();
        int inputCount = agenda.getInputCount();
        List<MytyDengmiTemp> list = new ArrayList<>(inputCount);
        for(int i = 0; i < inputCount; i ++){
            list.add(new MytyDengmiTemp());
        }
        model.addAttribute("list", list);
        return "baseFunction/inputMySubject";
    }

    @RequestMapping(value = "/toChangePassword", method = {RequestMethod.GET, RequestMethod.POST})
    public String toChangePassword(HttpServletRequest request, Model model) {
        model.addAttribute("loginUserName", request.getSession().getAttribute("loginUserName"));
        return "baseFunction/changePassword";
    }

    @RequestMapping(value = "/toAddUser", method = {RequestMethod.GET, RequestMethod.POST})
    public String toAddUser(HttpServletRequest request, Model model) {
        model.addAttribute("loginUserName", request.getSession().getAttribute("loginUserName"));
        return "baseFunction/addUser";
    }

    @RequestMapping(value="/toNewAgenda", method = {RequestMethod.GET, RequestMethod.POST})
    public String toNewAgenda(HttpServletRequest request, Model model){
        MytyAgenda agenda = agendaService.getNewAgenda();
        int roundNo = 0;
        if(agenda == null){
            roundNo = 1;
        } else {
            roundNo = agenda.getRoundNo() + 1;
        }
        model.addAttribute("roundNo", roundNo);
        return "agenda/newAgenda";
    }

    @RequestMapping(value="/toMySubject", method = {RequestMethod.GET, RequestMethod.POST})
    public String toMySubject(HttpServletRequest request, Model model){
        MytyUser userInfo = (MytyUser)request.getSession().getAttribute("loginUserInfo");
        String loginUserId = userInfo.getUserId();
        List<MytyDengmiTemp> list = dengmiTempService.selectByUserId(loginUserId);
        model.addAttribute("list", list);
        return "baseFunction/mySubject";
    }


    @RequestMapping(value="/toInputAnswer", method = {RequestMethod.GET, RequestMethod.POST})
    public String toInputAnswer(HttpServletRequest request, Model model){
        MytyUser userInfo = (MytyUser)request.getSession().getAttribute("loginUserInfo");
        String loginUserId = userInfo.getUserId();
        List<MytyDengmiTemp> list = dengmiTempService.selectNoAnswers(loginUserId);
        model.addAttribute("list", list);
        return "baseFunction/inputAnswer";
    }
}
