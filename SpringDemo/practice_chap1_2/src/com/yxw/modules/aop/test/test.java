package com.yxw.modules.aop.test;

import com.yxw.modules.aop.servlet.UserServlet;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Yan on 2018/7/31.
 */
@Component
public class test {
    private static  UserServlet userServlet;

    @Resource
    public void setUserServlet(UserServlet userServlet) {
        this.userServlet = userServlet;
    }
    @Test
    public void test(){
        new ClassPathXmlApplicationContext("com/yxw/modules/aop/spring-config.xml");
        String name="zhangsan";
        userServlet.save(name);
    }

    @Test
    public void testQuery(){
        new ClassPathXmlApplicationContext("com/yxw/modules/aop/spring-config.xml");
        userServlet.query();
    }
}
