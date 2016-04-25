package com.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dell-pc on 2016/1/15.
 */
@Controller
public class WebController {
    @RequestMapping("/")
    @ResponseBody
    public String hello(){
        return "Hello Spring BOOT";
    }
}
