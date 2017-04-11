package com.wangjichuan.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wangjichuan on 17/4/10.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/first")
    public ModelAndView first(ModelAndView modelAndView){
        modelAndView.addObject("name","wangjichuan");
        modelAndView.setViewName("first");
        return modelAndView;
    }
}
