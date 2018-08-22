package com.ht.ces.Listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        countPerson(httpSessionEvent.getSession().getServletContext(),true);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        countPerson(httpSessionEvent.getSession().getServletContext(),false);
    }

    public void countPerson(ServletContext sc,boolean isadd){
        //并发处理加锁为了防止多线程并发问题加锁
        synchronized (sc){
            //获得当前的在线人数
            Integer count = (Integer) sc.getAttribute("count");
            if(isadd){
                sc.setAttribute("count",++count);
            }else{
                sc.setAttribute("count",--count);
            }
        }
    }
}
