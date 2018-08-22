package com.bdqn.modules.permission;

import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.Contended;

/**
 * Created by Yan on 2018/8/19.
 */
@Contended
public class testController {
    @RequestMapping("index")
    public String hahah(){
        return "index";
    }
}
