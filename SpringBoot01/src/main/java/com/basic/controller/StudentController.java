package com.basic.controller;

import com.basic.dao.StudentDao;
import com.basic.model.Grade;
import com.basic.model.Student;
import com.basic.util.HibernateProxyTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import java.util.Iterator;

/**
 * Created by dell-pc on 2016/1/15.
 */
@Controller
@RequestMapping("/student")
@Transactional
public class StudentController {
    private Gson gson = new GsonBuilder()
            .registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY)
             .create();

   // public String
    @Autowired
    private StudentDao studentDao;

    @RequestMapping("/add")
    @ResponseBody
    public String addStudent(String name,String age,String gradeName){
        studentDao.save(new Student(name,age,new Grade(gradeName)));
        return "add success";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String deleteStudent(long id){
        studentDao.delete(id);
        return "delete success";
    }

    @RequestMapping("/update")
        @ResponseBody
        public String updateStudent(long id,String name, String age){
            Student stu= studentDao.findOne(id);
            stu.setName(name);
            stu.setAge(age);
            return "update success";
    }

    @RequestMapping("/search")
    @ResponseBody
    public String searchByStudent(String name){
        Student stu=studentDao.findByName(name);
        return gson.toJson(stu);
    }

    @RequestMapping("/findALL")
    @ResponseBody
    public String fidnALl(){
        Iterator<Student> it= studentDao.findAll().iterator();
        String str="";
        while(it.hasNext()){
            str+=it.next().getName()+" ";
        }
        return str;
    }

    @RequestMapping("/updateAge")
    @ResponseBody
    public String updateAgeThen(){
        studentDao.updateStudentAgeThen("10","20");
        return "HelloWorld";
    }

    @RequestMapping("/pageAge")
    @ResponseBody
    public String pageAgeThen(){
        String str="";
        for(Student s :studentDao.findStudentByAgeThen("10",new PageRequest(0,2))){
            str+=s.getName()+" ";
        }
        return str;
    }

    @RequestMapping("/")
    public String student(Model model){
        model.addAttribute("students",studentDao.findAll());
        return "public/student";
    }
}
