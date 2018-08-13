package com.amar.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dingmx
 * @date 2018/8/11 09:44
 */
@Controller
@RequestMapping("/report")
public class ReportController {

    @RequestMapping("/{view}")
    public String view(@PathVariable("view") String view) {
        return "report/" + view;
    }

}
