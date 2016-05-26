package com.basic.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by dell-pc on 2016/5/10.
 */

@Controller
public class WebController extends BaseControlller{

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String HelloWorld(){
        return "HelloWorld谭杰!";
    }

    @RequestMapping(value = "/send_{var1}")
    public String web(@PathVariable("var1") String var1){
        return var1;
    }

    @RequestMapping("/asyncfilter")
    @ResponseBody
    public String AsyncFilter(){
        return "AsyncFilter";
    }
    //异步的方法

    @RequestMapping(value = "/async",method = RequestMethod.GET)
    public void Async(HttpServletRequest request, HttpServletResponse response){
        System.out.println("Servlet开始时间" +new Date());
        AsyncContext asyncContext=request.startAsync();
        Executor executor=new Executor(asyncContext);
        executor.run();
        System.out.println("Servlet结束时间" +new Date());
    }


    //异步操作类
    public class Executor implements Runnable{
        private AsyncContext asyncContext;

        public Executor(AsyncContext asyncContext) {
            this.asyncContext = asyncContext;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000*10);
                asyncContext.getRequest();
                asyncContext.getResponse();
                System.out.println("业务执行完成时间" +new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
