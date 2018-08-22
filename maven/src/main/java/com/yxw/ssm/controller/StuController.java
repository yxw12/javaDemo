package com.yxw.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.yxw.ssm.entity.TStu;
import com.yxw.ssm.service.StuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Yan on 2018/8/10.
 */
@Controller
public class StuController {
    @Resource
    private StuService stuService;

    @RequestMapping("/student")
    public String selectStu(Model model,String sNo){
        TStu tStu = stuService.selectByPrimaryKey(sNo);
        model.addAttribute("tStu",tStu);
        return "index";
    }

    @RequestMapping("/studentAll")
    public String getAllStu(){
        List<TStu> tStuList = stuService.getAll();
        System.out.println(JSON.toJSONString(tStuList.toString(), true));
        return "index";
    }

    @RequestMapping("/studentAll2")
    public String getAllStu2(){
        List<TStu> tStuList = stuService.getAll2();
        for (TStu tstu:tStuList) {
            System.out.println(tstu.getsName()+"..."+JSON.toJSON(tstu));
        }
  //      System.out.println(tStuList);
    //        System.out.println(JSON.toJSONString(tStuList,true));

        return "index";
    }

}
