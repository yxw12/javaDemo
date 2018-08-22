package com.yxw.aop_txjdbc_anno;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.Serializable;

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
    public void delete(Serializable id){
        userService.delete(id);
    }

}
