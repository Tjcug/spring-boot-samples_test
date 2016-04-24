package com.basic.springboot.controller;

import com.basic.springboot.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.io.IOException;
import java.io.Writer;

/**
 * Created by dell-pc on 2016/4/20.
 */

@Controller
@SessionAttributes("student")
public class SessionAttributeController extends BaseControlller{
    @RequestMapping("/setsessionAttribute")
    public String setSessionAttribute(Model model){
        model.addAttribute("student",new Student("tanjie",1,"xuedaxuan"));
        return "test2";
    }

    @RequestMapping("/usesessionAttribute")
    public void useSessionAttribuet(Writer out, @ModelAttribute("student") Student student) throws IOException {
        out.write(student.getName()+","+student.getId());
    }
}
