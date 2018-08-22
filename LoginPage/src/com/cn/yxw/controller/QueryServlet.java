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
import java.util.List;

/**
 * Created by Yan on 2018/7/9.
 */
@WebServlet(name = "QueryServlet")
public class QueryServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService=new UserServiceImpl();
        List<User> userList = userService.listUser();
        System.out.println(userList);
        request.setAttribute("userList",userList);
        request.getRequestDispatcher("ces/tab.jsp").forward(request,response);

    }
}
