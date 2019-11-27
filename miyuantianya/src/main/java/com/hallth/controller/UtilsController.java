package com.hallth.controller;

import com.hallth.domain.MytyAgenda;
import com.hallth.domain.MytyUser;
import com.hallth.service.impl.MytyDengmiTempServiceImpl;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/util")
public class UtilsController {

    @Resource
    private MytyDengmiTempServiceImpl dengmiTempService;

    @RequestMapping(value = "/userCompetitionDetail", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> userCompetitionDetail(HttpServletRequest request, Model model) {
        MytyUser loginUser = (MytyUser)request.getSession().getAttribute("loginUserInfo");
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int pageSize = Integer.parseInt(request.getParameter("limit"));
        int roundNo = Integer.parseInt(request.getParameter("roundNo"));
        String userId = request.getParameter("userId");
        Map<String, Object> map = dengmiTempService.userCompetitionDetail(roundNo, userId, currentPage, pageSize);
        return map;
    }
}
