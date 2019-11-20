package com.hallth.controller;

import com.hallth.service.impl.MytyMenuServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuManageController {

    @Resource
    private MytyMenuServiceImpl menuService;

    @RequestMapping(value="/getAllMenu", method = {RequestMethod.GET, RequestMethod.POST})
    public Map getAllMenu(HttpServletRequest request){
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int pageSize = Integer.parseInt(request.getParameter("limit"));
        return menuService.getAllMenu(currentPage, pageSize);
    }
}
