package com.basic.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dell-pc on 2016/4/20.
 */

@Controller
public class ModelAttributeController extends BaseControlller{

    @ModelAttribute("hello")
    public String getModel(){
       log.info("----------hello--------");
        return "hello";
    }

    @ModelAttribute("intValue")
    public Integer getintValue(){
        log.info("----------intVaule--------发放时");
        return 10;
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@ModelAttribute("hello")String hello,@ModelAttribute("intValue") int intVaule){
        return hello+","+intVaule;
    }
}
