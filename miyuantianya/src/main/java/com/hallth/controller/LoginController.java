package com.hallth.controller;

import com.hallth.domain.MytyAgenda;
import com.hallth.domain.MytyUser;
import com.hallth.service.impl.MytyAgendaServiceImpl;
import com.hallth.service.impl.MytyUserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {
    private static Logger logger = Logger.getLogger(LoginController.class.getName());

    @Resource
    private MytyUserServiceImpl userService;
    @Resource
    private MytyAgendaServiceImpl agendaService;

    @RequestMapping(value="/loginPage", method = {RequestMethod.GET, RequestMethod.POST})
    public String loginPage(){
        return "login/login";
    }


    @RequestMapping(value="/loginCheck", method = {RequestMethod.GET, RequestMethod.POST})
    public String addUser(@RequestParam("userName")String userName, @RequestParam("userPassword")String userPassword, Model model){
        logger.info("用户【" + userName + "】登录校验");
        if(userName.trim().isEmpty() || userPassword.trim().isEmpty()){
            logger.info("用户名或密码为空");
            model.addAttribute("errMsg","用户名或密码为空！");
            return "login/login";
        }
        MytyUser user = new MytyUser("",userName,"",userPassword);
        boolean loginCheckRes = userService.loginCheck(user);
        if(loginCheckRes){
            logger.info("用户【" + userName + "】登录校验通过！");
            return "baseFunction/home";
        } else {
            logger.info("用户【" + userName + "】不存在或密码错误！");
            model.addAttribute("errMsg","用户【" + userName + "】不存在或密码错误！");
            return "login/login";
        }
    }

    @RequestMapping(value="/agendaDetail", method = {RequestMethod.GET, RequestMethod.POST})
    public String agendaDetail(Model model){
        logger.info("查询内赛日程安排\n获取最新一轮的轮次号");
        MytyAgenda newAgenda = agendaService.getNewAgenda();
        Date date = newAgenda.getProgressDate();
        String startTime = "已结束";
        String doTime = "已结束";
        String judgeTime = "已结束";
        String endTime = "已结束";
        if(date.getTime() > System.currentTimeMillis()){
            int roundNo = newAgenda.getRoundNo();
            logger.info("获取最新一轮的日程安排");
            List<MytyAgenda> agendaDetail = agendaService.getNewAgendaDetail(roundNo);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for(MytyAgenda agenda : agendaDetail){
                if(agenda.getProgressPoint().equals("开始时间")){
                    startTime = sdf.format(agenda.getProgressDate());
                } else if(agenda.getProgressPoint().equals("猜射时间")){
                    doTime = sdf.format(agenda.getProgressDate());
                } else if(agenda.getProgressPoint().equals("评分列中时间")){
                    judgeTime = sdf.format(agenda.getProgressDate());
                } else {
                    endTime = sdf.format(agenda.getProgressDate());
                }
            }
        }
        model.addAttribute("startTime",startTime);
        model.addAttribute("doTime",doTime);
        model.addAttribute("judgeTime",judgeTime);
        model.addAttribute("endTime",endTime);
        return "baseFunction/agendaDetail";
    }
}
