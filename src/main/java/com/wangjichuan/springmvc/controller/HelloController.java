package com.wangjichuan.springmvc.controller;

import com.wangjichuan.springmvc.po.School;
import com.wangjichuan.springmvc.service.HelloService;
import com.wangjichuan.springmvc.service.SchoolService;
import com.wangjichuan.springmvc.utils.CommonUtils;
import com.wangjichuan.springmvc.utils.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by wangjichuan on 17/4/10.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private HelloService helloService;
    @Autowired
    private SchoolService schoolService;
    @RequestMapping("/first")
    public ModelAndView first(ModelAndView modelAndView){
        modelAndView.addObject("name","wangjichuan");
        modelAndView.setViewName("first");
        CommonUtils.print("thread-----"+Thread.currentThread().getName()+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        helloService.hello();
        return modelAndView;
    }
    @RequestMapping("/save")
    @ResponseBody
    public boolean save(@RequestParam(name="name")String schoolName){
        School school = new School();
        school.setName(schoolName);
        school.setCreateTime(DateFormatUtils.currentTime());
        school.setId(new Random().nextLong());
        return schoolService.save(school);
    }
    @RequestMapping("/list")
    @ResponseBody
    public List list(){
        return schoolService.list();
    }
}
