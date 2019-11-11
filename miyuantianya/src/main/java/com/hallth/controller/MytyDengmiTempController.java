package com.hallth.controller;

import com.hallth.domain.MytyDengmiTemp;
import com.hallth.domain.MytyUser;
import com.hallth.service.impl.MytyDengmiTempServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/dengmiTemp")
public class MytyDengmiTempController {
    private static Logger logger = Logger.getLogger(MytyDengmiTempController.class.getName());

    @Resource
    private MytyDengmiTempServiceImpl dengmiTempService;


}
