package com.basic.bustation.listener;

import com.basic.bustation.dao.LinestationDAO;
import com.basic.bustation.dao.RoadlineDAO;
import com.basic.bustation.dao.RoadstationDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by dell-pc on 2016/4/24.
 */

/**
 * 初始化监听事件
 */
@WebListener
@Transactional(propagation= Propagation.REQUIRED)
public class IniitDataListener implements ServletContextListener{

    private RoadlineDAO roadlineDAO;

    private LinestationDAO linestationDAO;

    private RoadstationDAO roadstationDAO;

    private ApplicationContext applicationContext=null;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("init");
        applicationContext=applicationContext= WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
//        roadlineDAO=(RoadlineDAO) applicationContext.getBean("roadlineDAO");
//        linestationDAO=(LinestationDAO) applicationContext.getBean("linestationDAO");
//        roadstationDAO=(RoadstationDAO) applicationContext.getBean("roadstationDAO");
//
//        roadlineDAO.findAll();
//        linestationDAO.findAll();
//        roadstationDAO.findAll();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("destory");
    }
}
