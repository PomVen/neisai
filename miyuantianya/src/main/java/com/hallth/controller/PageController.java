package com.hallth.controller;

import com.hallth.domain.MytyAgenda;
import com.hallth.domain.MytyDengmiTemp;
import com.hallth.service.impl.MytyAgendaServiceImpl;
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
}
