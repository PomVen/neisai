package com.hallth.controller;

import com.hallth.domain.MytyAgenda;
import com.hallth.service.impl.MytyAgendaServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/agenda")
public class AgendaController {

    private static Logger logger = Logger.getLogger(AgendaController.class.getName());

    @Resource
    private MytyAgendaServiceImpl agendaService;


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

    @RequestMapping(value="/newAgenda", method = {RequestMethod.GET, RequestMethod.POST})
    public String newAgenda(@RequestParam("roundNo")int roundNo, @RequestParam("startTime") String startTime, @RequestParam("doTime")String doTime,
                            @RequestParam("judgeTime")String judgeTime, @RequestParam("endTime")String endTime, @RequestParam("inputCount")int inputCount, HttpServletRequest request, Model model){
        MytyAgenda agenda = new MytyAgenda();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            agenda.setRoundNo(roundNo);
            agenda.setStartTime(sdf.parse(startTime));
            agenda.setDoTime(sdf.parse(doTime));
            agenda.setJudgeTime(sdf.parse(judgeTime));
            agenda.setEndTime(sdf.parse(endTime));
            agenda.setInputCount(inputCount);
            agendaService.insert(agenda);
        } catch (Exception e){
            logger.error("时间转换失败！" + e.getMessage());
            model.addAttribute("errMsg", e.getMessage());
        }
        return "agenda/newAgenda";
    }
}
