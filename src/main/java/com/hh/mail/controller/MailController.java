package com.hh.mail.controller;

import com.hh.mail.pojo.MailBean;
import com.hh.mail.util.SendMailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MailController {

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping(value = "/send",method = RequestMethod.POST)
    @ResponseBody
    public String send(@RequestBody MailBean mailBean) {
        try {
            SendMailUtil bean = applicationContext.getBean(SendMailUtil.class);
            bean.sendMessage(mailBean);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "ok";
    }



}
