package com.hallth.controller;

import com.hallth.domain.MytyUser;
import com.hallth.service.impl.MytyUserServiceImpl;
import com.hallth.utils.SeqCreate;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger logger = Logger.getLogger(UserController.class.getName());

    @Resource
    private MytyUserServiceImpl userService;

    @Resource
    private SeqCreate seqCreate;

    @RequestMapping(value="/addUser", method = {RequestMethod.GET, RequestMethod.POST})
    public String addUser(@RequestParam("userName")String userName, @RequestParam("userPassword")String userPassword, Model model){
        logger.info("=========== 添加用户 ==========");
        MytyUser user = new MytyUser();
        user.setUserName(userName);
        user = userService.getUserInfo(user);
        if(user != null){
            model.addAttribute("errMsg", "用户【" + userName + "】已存在");
        } else {
            String userId = seqCreate.getNextUserId();
            user = new MytyUser();
            user.setUserName(userName);
            user.setUserPassword(userPassword);
            user.setUserRole("0");
            user.setUserId(userId);
            int i = userService.insert(user);
            if(i < 1){
                model.addAttribute("errMsg","用户添加失败！");
            }
        }
        return "baseFunction/home";
    }

    @RequestMapping(value="/toChangePassword", method = {RequestMethod.GET, RequestMethod.POST})
    public String toChangePassword(HttpServletRequest request, Model model){
        model.addAttribute("loginUserName", request.getSession().getAttribute("loginUserName"));
        return "baseFunction/changePassword";
    }

    @RequestMapping(value="/toAddUser", method = {RequestMethod.GET, RequestMethod.POST})
    public String toAddUser(HttpServletRequest request, Model model){
        model.addAttribute("loginUserName", request.getSession().getAttribute("loginUserName"));
        return "baseFunction/addUser";
    }


    @RequestMapping(value="/changePassword", method = {RequestMethod.GET, RequestMethod.POST})
    public String changePassword(@RequestParam("userName")String userName, @RequestParam("userPassword")String userPassword,
                               @RequestParam("comfirmPassword")String comfirmPassword, @RequestParam("newPassword")String newPassword, Model model){
        MytyUser user = new MytyUser("",userName,"",userPassword);
        MytyUser loginUser = userService.loginCheck(user);
        if(!comfirmPassword.trim().equals(newPassword.trim())){
            model.addAttribute("errMsg", "两次输入的密码不一致！");
        } else {
            if(loginUser != null){
                user = new MytyUser("",userName,"",newPassword);
                int i = userService.changePassword(user);
                if(i > 0){
                    model.addAttribute("success","密码修改成功！");
                    return "baseFunction/home";
                } else {
                    model.addAttribute("errMsg", "密码修改失败！");
                }
            } else {
                model.addAttribute("errMsg", "旧密码错误！");
            }
        }
        return "baseFunction/changePassword";
    }


}
