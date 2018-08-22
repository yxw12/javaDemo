package com.yxw.aop_txJdbc;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by Yan on 2018/7/30.
 */
@Controller
public class UserServlet {
    @Resource
    private UserService userService;
    public void save(User user){
        userService.save(user);
    }

}
