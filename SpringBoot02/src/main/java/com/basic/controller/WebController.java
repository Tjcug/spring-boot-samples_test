package com.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dell-pc on 2016/1/16.
 */
@Controller
public class WebController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/student")
    public String Student(){
        return "student";
    }
}
