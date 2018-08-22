package com.yxw.modules.aop.servlet;

import com.yxw.modules.aop.service.UserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by Yan on 2018/7/31.
 */
@Controller
public class UserServlet {
    @Resource
    private UserService userService;
    public void save(String s){
        userService.save(s);
    }

    public void query() {
        userService.query();
    }
}
