package com.hallth.controller;

import com.hallth.domain.MytyAgenda;
import com.hallth.domain.MytyAnswer;
import com.hallth.domain.MytyUser;
import com.hallth.service.impl.MytyAgendaServiceImpl;
import com.hallth.service.impl.MytyAnswerServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/answer")
public class AnswerController {
    private static Logger logger = Logger.getLogger(AnswerController.class.getName());
    @Resource
    private MytyAnswerServiceImpl answerService;
    @Resource
    private MytyAgendaServiceImpl agendaService;

    @RequestMapping(value="/saveMyAnswer", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> saveMyAnswer(@RequestParam("dmTempId")int dmTempId, @RequestParam("dmMidi")String dmMidi, HttpServletRequest request){
        MytyUser loginUser = (MytyUser)request.getSession().getAttribute("loginUserInfo");
        MytyAgenda agenda = agendaService.getNewAgenda();
        Map map = new HashMap();
        MytyAnswer answer = new MytyAnswer();
        answer.setDmId(dmTempId);
        answer.setUserAnswer(dmMidi);
        answer.setUserId(loginUser.getUserId());
        answer.setAgendaRoundNo(agenda.getRoundNo());
        //是否已回答
        MytyAnswer temp = answerService.getMyAnswer(answer);

        try{
            if(temp == null){
                answerService.saveMyAnswer(answer, "I");
            } else {
                answerService.saveMyAnswer(answer, "U");
            }
            map.put("result", true);
            map.put("msg", "操作成功！");
        } catch (Exception e){
            map.put("result", false);
            map.put("msg", "操作失败，请刷新页面重试");
        }
        return  map;
    }

    @RequestMapping(value="/saveMyJudge", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> saveMyJudge(@RequestParam("dmTempId")int dmTempId, @RequestParam("judge")int judge, HttpServletRequest request){
        MytyUser loginUser = (MytyUser)request.getSession().getAttribute("loginUserInfo");
        MytyAgenda agenda = agendaService.getNewAgenda();
        Map map = new HashMap();
        MytyAnswer answer = new MytyAnswer();
        answer.setDmId(dmTempId);
        answer.setUserJudge(judge);
        answer.setUserId(loginUser.getUserId());
        answer.setAgendaRoundNo(agenda.getRoundNo());
        //是否已回答
        MytyAnswer temp = answerService.getMyAnswer(answer);
        try{
            if(temp == null){
                answerService.saveMyAnswer(answer, "I");
            } else {
                answerService.saveMyAnswer(answer, "UJ");
            }
            map.put("result", true);
            map.put("msg", "操作成功！");
        } catch (Exception e){
            map.put("result", false);
            map.put("msg", "操作失败，请刷新页面重试");
        }
        return  map;
    }

    @RequestMapping(value="/saveIsright", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> saveIsright(@RequestParam("dmTempId")int dmTempId, @RequestParam("isRight")int isRight, @RequestParam("userId")String userId, HttpServletRequest request){
        MytyAgenda agenda = agendaService.getNewAgenda();
        Map map = new HashMap();
        MytyAnswer answer = new MytyAnswer();
        answer.setDmId(dmTempId);
        answer.setIsRight(isRight);
        answer.setUserId(userId);
        answer.setAgendaRoundNo(agenda.getRoundNo());
        //是否已回答
        MytyAnswer temp = answerService.getMyAnswer(answer);
        try{
            if(temp == null){
                answerService.saveMyAnswer(answer, "I");
            } else {
                answerService.saveMyAnswer(answer, "UR");
            }
            map.put("result", true);
            map.put("msg", "操作成功！");
        } catch (Exception e){
            map.put("result", false);
            map.put("msg", "操作失败，请刷新页面重试");
        }
        return  map;
    }
}
