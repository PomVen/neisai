package com.hallth.controller;

import com.hallth.domain.MytyAgenda;
import com.hallth.domain.MytyMenu;
import com.hallth.domain.MytyUser;
import com.hallth.service.impl.MytyAgendaServiceImpl;
import com.hallth.service.impl.MytyMenuServiceImpl;
import com.hallth.service.impl.MytyUserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @Resource
    private MytyMenuServiceImpl menuService;

    @RequestMapping(value="/loginPage", method = {RequestMethod.GET, RequestMethod.POST})
    public String loginPage(HttpServletRequest request){
        String loginName = (String)request.getSession().getAttribute("loginUserName");
        if(loginName == null || "".equals(loginName)){
            return "login/login";
        } else {
            return "login/login";
        }
    }


    @RequestMapping(value="/loginCheck", method = {RequestMethod.GET, RequestMethod.POST})
    public String addUser(@RequestParam("userName")String userName, @RequestParam("userPassword")String userPassword,
                          HttpServletRequest request, Model model){
        logger.info("用户【" + userName + "】登录校验");
        MytyAgenda agenda = agendaService.getNewAgenda();
        if(userName.trim().isEmpty() || userPassword.trim().isEmpty()){
            logger.info("用户名或密码为空");
            model.addAttribute("errMsg","用户名或密码为空！");
            return "login/login";
        }
        MytyUser user = new MytyUser("",userName,"",userPassword);
        MytyUser loginUser = userService.loginCheck(user);
        if(loginUser != null){
            logger.info("用户【" + userName + "】登录校验通过！");
            model.addAttribute("roundNo", agenda == null ? 1 : agenda.getRoundNo());
            HttpSession session = request.getSession();
            session.setAttribute("loginUserName", userName);
            session.setAttribute("loginUserInfo", loginUser);
            //获取菜单
            List<MytyMenu> menuList = menuService.getMenuListByUserRole(loginUser);
            session.setAttribute("userMenuList", menuList);
            model.addAttribute("menu", menuList);
            model.addAttribute("actived", 0);
            return "baseFunction/home";
        } else {
            logger.info("用户【" + userName + "】不存在或密码错误！");
            model.addAttribute("errMsg","用户【" + userName + "】不存在或密码错误！");
            return "login/login";
        }
    }

    @RequestMapping(value="/agendaDetail", method = {RequestMethod.GET, RequestMethod.POST})
    public String agendaDetail(HttpServletRequest request, Model model){
        logger.info("查询内赛日程安排\n获取最新一轮的轮次号");
        MytyAgenda newAgenda = agendaService.getNewAgenda();
        Date date = newAgenda.getEndTime();
        String startTime = "已结束";
        String doTime = "已结束";
        String judgeTime = "已结束";
        String endTime = "已结束";
        if(date.getTime() > System.currentTimeMillis()){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            startTime = sdf.format(newAgenda.getStartTime());
            doTime = sdf.format(newAgenda.getDoTime());
            judgeTime = sdf.format(newAgenda.getJudgeTime());
            endTime = sdf.format(newAgenda.getEndTime());
        }
        model.addAttribute("startTime",startTime);
        model.addAttribute("doTime",doTime);
        model.addAttribute("judgeTime",judgeTime);
        model.addAttribute("endTime",endTime);
        String loginName = (String)request.getSession().getAttribute("loginUserName");
        if(loginName == null || "".equals(loginName)){
            return "baseFunction/agendaDetail";
        } else {
            return "baseFunction/agenda";
        }
    }

    @RequestMapping(value="/loginOut", method = {RequestMethod.GET, RequestMethod.POST})
    public String loginOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();//删除session
        return "login/login";
    }

}
