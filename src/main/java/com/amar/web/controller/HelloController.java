package com.amar.web.controller;

import com.amar.domain.Message;
import com.amar.util.common.JacksonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author dingmx
 * @date 2018/8/10 22:57
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/message")
    public String getData() {
        return "message";
    }

    @ResponseBody
    @RequestMapping("/getMessage")
    public String getMessage() {
        Message message = new Message();
        message.setId("101");
        message.setType("weChat");
        message.setLength(100L);
        return JacksonUtils.toJson(message);
    }
}
