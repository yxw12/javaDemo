package com.yxw.aop_anno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Yan on 2018/7/29.
 */
public class App {

    private ApplicationContext ac = new ClassPathXmlApplicationContext("com/yxw/aop_anno/spring-config.xml");

    //jdk代理（动态代理）
    @Test
    public void myTest(){
        // springIOC容器中获取对象，用接口接收！
//		IUserDao userDao = (IUserDao) ac.getBean("userDao");
//		System.out.println(userDao.getClass());
//		userDao.save();


        // springIOC容器中获取对象，用实现接收？   报错！！！！！！！！！
		/*
		 *  java.lang.ClassCastException:
		 *      $Proxy13 cannot be cast to cn.itcast.e_aop_anno.UserDao
		 */
        // 总结：在spring的aop编程中，符合切入点表达式的目标类，  如果目标对象有实现接口，从容器获取对象的时候，一定要通过接口接收！
        // 否则，包类型转换错误！
        UserDao userDao = (UserDao) ac.getBean("userDao");
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
