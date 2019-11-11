package com.hallth.controller;

import com.hallth.domain.MytyUser;
import com.hallth.service.impl.MytyUserServiceImpl;
import com.hallth.utils.SeqCreate;
import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private static Logger logger = Logger.getLogger(UserController.class.getName());

    @Resource
    private MytyUserServiceImpl userService;

    @Resource
    private SeqCreate seqCreate;

    @RequestMapping(value = "/addUser", method = {RequestMethod.GET, RequestMethod.POST})
    public Map addUser(@RequestParam("userName") String userName, @RequestParam("userPassword") String userPassword, HttpServletRequest request, Model model) {
        logger.info("=========== 添加用户 ==========");
//        ModelAndView mv = new ModelAndView();
        Map map = new HashMap();
        MytyUser user = new MytyUser();
        user.setUserName(userName);
        user = userService.getUserInfo(user);
        if (user != null) {
            model.addAttribute("errMsg", "用户【" + userName + "】已存在");
            map.put("status", false);
            map.put("msg", "用户【" + userName + "】已存在");
//            mv.addObject("errMsg", "用户【" + userName + "】已存在");
        } else {
            String userId = seqCreate.getNextUserId();
            user = new MytyUser();
            user.setUserName(userName);
            user.setUserPassword(userPassword);
            user.setUserRole("0");
            user.setUserId(userId);
            int i = userService.insert(user);
            if (i < 1) {
                model.addAttribute("errMsg", "用户添加失败！");
                map.put("status", false);
                map.put("msg", "用户添加失败");
//                mv.addObject("errMsg", "用户添加失败");
            } else {
                model.addAttribute("errMsg", "用户添加成功！");
                map.put("status", true);
                map.put("msg", "用户添加成功");
//                mv.addObject("errMsg", "用户添加成功");
            }
//            model.addAttribute("isLogined", true);
//            model.addAttribute("userMenuList", request.getSession().getAttribute("userMenuList"));
//            model.addAttribute("actived", 1);
        }
//        return mv;
        return map;
    }

    @RequestMapping(value = "/changePassword", method = {RequestMethod.GET, RequestMethod.POST})
    public Map changePassword(@RequestParam("userName") String userName, @RequestParam("userPassword") String userPassword,
                                 @RequestParam("comfirmPassword") String comfirmPassword, @RequestParam("newPassword") String newPassword, Model model) {
        MytyUser user = new MytyUser("", userName, "", userPassword);
        MytyUser loginUser = userService.loginCheck(user);
        Map map = new HashMap();
        if (!comfirmPassword.trim().equals(newPassword.trim())) {
            model.addAttribute("errMsg", "两次输入的密码不一致！");
            map.put("result", false);
            map.put("msg", "两次输入的密码不一致！");
        } else {
            if (loginUser != null) {
                user = new MytyUser("", userName, "", newPassword);
                int i = userService.changePassword(user);
                if (i > 0) {
                    model.addAttribute("success", "密码修改成功！");
                    map.put("result", true);
                    map.put("msg", "用户【" + userName + "】密码修改成功！");
                } else {
                    model.addAttribute("errMsg", "密码修改失败！");
                    map.put("result", false);
                    map.put("msg", "用户【" + userName + "】密码修改失败！");
                }
            } else {
                model.addAttribute("errMsg", "旧密码错误！");
                map.put("result", false);
                map.put("msg", "用户【" + userName + "】旧密码错误！");
            }
        }
        return map;
    }


}
