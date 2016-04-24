package com.basic.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Random;

/**
 * Created by dell-pc on 2016/4/21.
 */

@Controller
public class TemplateController extends BaseControlller{

    @RequestMapping("/iftemplate")
    public String iftemplate(Model model){
        model.addAttribute("random",new Random().nextInt(100));
        model.addAttribute("date",new Date());
        model.addAttribute("method","abcdefg");
        log.info("fsdfsd");
        return "template";
    }
}
