package com.basic.springboot.controller;

import com.basic.springboot.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by dell-pc on 2016/4/19.
 */

@Controller
public class WebController extends BaseControlller{

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/student")
    public String student(){
        return "student";
    }

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test(@RequestParam("id")int id, @RequestParam("name")String name){
        return  "你好"+name+"你的id事"+id;
    }

    @RequestMapping("/test2")
    public String test2(@RequestParam("id")int id, @RequestParam("name")String name, HttpSession httpSession){
        httpSession.setAttribute("id",id);
        httpSession.setAttribute("name",name);
        return  "test";
    }

    @RequestMapping("/test3")
    public ModelAndView test3(@RequestParam("id")int id, @RequestParam("name")String name){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("id",id);
        modelAndView.addObject("name",name);
        modelAndView.addObject("hello","哈哈哈哈");
        return  modelAndView;
    }

    @RequestMapping("/test4")
    public void test4(@RequestParam("id")int id, @RequestParam("name")String name, HttpServletResponse httpServletResponse) throws IOException {
        Student student=new Student("tanjie",1,"谭杰");
        String josnstr= gson.toJson(student);
        httpServletResponse.getWriter().println(josnstr);
    }

    @RequestMapping("/test5")
    public void test5( HttpServletResponse httpServletResponse) throws IOException {
        List<Student> stuList=new ArrayList<Student>();
        Student student=new Student("tanjie",1,"谭杰");
        Student student2=new Student("xuedaxuan",2,"薛大暄");
        stuList.add(student);
        stuList.add(student2);

        String josnstr= gson.toJson(stuList);
        httpServletResponse.setContentType("text/html;charset=utf-8");
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.getWriter().println(josnstr);
    }

    @RequestMapping("/test6")
    public ModelAndView test6(HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest) throws IOException {

        List<Student> stuList=new ArrayList<Student>();
        Student student=new Student("tanjie",1,"谭杰");
        Student student2=new Student("xuedaxuan",2,"薛大暄");
        stuList.add(student);
        stuList.add(student2);

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("student/student2");
        modelAndView.addObject("studentList",stuList);
        Map map=new HashMap();
        map.put("studentList",stuList);

        return modelAndView;
    }

    @RequestMapping(value = "/test7")
    @ResponseBody
    public String test7(){
        log.info("hello vodi test");
        return "范德萨发斯蒂芬";
    }
}
