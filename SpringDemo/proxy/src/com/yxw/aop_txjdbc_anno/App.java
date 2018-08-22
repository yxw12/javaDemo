package com.yxw.aop_txjdbc_anno;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Yan on 2018/7/30.
 */
@Component
public class App {

    private  static UserServlet userServlet;
    @Resource
    public void setUserServlet(UserServlet userServlet) {
        this.userServlet = userServlet;
    }

    @Test
    public void test(){
        new ClassPathXmlApplicationContext("com/yxw/aop_txjdbc_anno/spring-config.xml");
        User user=new User();
    //    user.setUid(16);
        user.setUsername("yanwenxin");
        user.setPassword("yanwenxin");
        userServlet.save(user);
    }
}
