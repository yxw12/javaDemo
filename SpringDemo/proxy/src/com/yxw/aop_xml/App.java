package com.yxw.aop_xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Yan on 2018/7/29.
 */
public class App {

    private ApplicationContext ac = new ClassPathXmlApplicationContext("com/yxw/aop_xml/spring-config.xml");

    //jdk代理（动态代理）
    @Test
    public void myTest(){
        // springIOC容器中获取对象，用接口接收！
		IUserDao userDao = (IUserDao) ac.getBean("userDao");
		System.out.println(userDao.getClass());
        userDao.save();
    }

    //cglib代理
    @Test
    public void myTest1(){
        UserDao userDao = (UserDao) ac.getBean("userDao");
        System.out.println(userDao.getClass());//class com.yxw.aop_anno.UserDao$$EnhancerBySpringCGLIB$$5967df04
        userDao.save();
    }

    //没有代理对象，因为没有切入点表达式拦截
    @Test
    public void myTest_order(){
        OrderDao orderDao = (OrderDao) ac.getBean("orderDao");
        System.out.println(orderDao.getClass());//class com.yxw.aop_anno.UserDao$$EnhancerBySpringCGLIB$$5967df04
        orderDao.save();
    }

}
