package com.ht.ces.Listener;

import com.ht.ces.task.ScheduleServlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {
    Thread t=null;
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("监听器被创建了...");
        t=new Thread(new ScheduleServlet());
        t.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("监听器被销毁了...");
        t.stop();
    }
}
