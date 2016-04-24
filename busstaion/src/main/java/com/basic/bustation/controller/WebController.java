package com.basic.bustation.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dell-pc on 2016/4/21.
 */
@Controller
@EnableAutoConfiguration
public class WebController extends  BaseController{

    @RequestMapping(value = "/",produces = "text/html;charset=UTF-8")
    public String index(){
        return "index";
    }

    @RequestMapping("send_{var1}_{var2}.action")
    public String sendFunc(@PathVariable("var1") String var1,@PathVariable("var2") String var2){
        return var1+"/"+var2;
    }
}
