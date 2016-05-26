package com.basic.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

/**
 * Created by dell-pc on 2016/5/10.
 */
@Controller

@SessionAttributes("username")
public class UserController {

    @RequestMapping("/userLogin")
    public String login(@RequestParam String usernanme, @RequestParam String password, HttpSession session
    , Model model){
        System.out.println(usernanme);
        if("admin".equals(usernanme)&&"admin".equals(password)){
            //校验成功
            model.addAttribute("username",usernanme);
            return "redirect:/send_success";
        }else{
            //校验失败
            return "redirect:/send_error";
        }
    }
}
