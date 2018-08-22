package com.cn.yxw.controller;

import com.cn.yxw.model.PageBean;
import com.cn.yxw.model.User;
import com.cn.yxw.service.Impl.UserServiceImpl;
import com.cn.yxw.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Yan on 2018/7/10.
 */
@WebServlet(name="PageServlet" )
public class PageServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获得分页参数
        String pageNumberStr=request.getParameter("pageNumber");
        if(pageNumberStr==null) pageNumberStr="1";
        Integer pageNumber = Integer.parseInt(pageNumberStr);
        try {
            Integer.parseInt(pageNumberStr);
        }catch (Exception e){

        }
       Integer pageSize=9;
   //     Integer pageSize=Integer.parseInt(request.getParameter("pageSize"));
        // 2.通知service，查询所有用户
        UserService userService=new UserServiceImpl();
        PageBean<User> pageBean = userService.findAll(pageNumber,pageSize);
        //3.选择jsp
        //3.1将查询结果存放在request作用域中
        request.setAttribute("pageBean",pageBean);
        //3.2请求转发
        request.getRequestDispatcher("ces/tab.jsp").forward(request,response);

    }
}
