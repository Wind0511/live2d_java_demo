package com.wind.live2dDemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("/demo")
    public String showDemo(){
        return "hello";
    }
    @RequestMapping("/index")
    public String showIndex(){
        return "index";
    }
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "success";
    }
}
