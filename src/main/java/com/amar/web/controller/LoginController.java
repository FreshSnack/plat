package com.amar.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author dingmx
 * @date 2018/8/12 21:07
 */
@Controller
public class LoginController {

    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value="/login.do",method = RequestMethod.POST)
    public String loginAction(String username, String password, Map<String, Object> map) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch(AuthenticationException e) {
            return "login";
        }
        subject.isRemembered();
        return "hello";
    }
}
