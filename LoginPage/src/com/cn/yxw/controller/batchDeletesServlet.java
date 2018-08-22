package com.cn.yxw.controller;

import com.cn.yxw.service.Impl.UserServiceImpl;
import com.cn.yxw.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 批量删除
 * Created by Yan on 2018/7/12.
 */
@WebServlet(name = "batchDeletesServlet")
public class batchDeletesServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String items = request.getParameter("delitems");// System.out.println(items);
        String[] strs = items.split(",");
        UserService userService=new UserServiceImpl();
        for (int i = 0; i < strs.length; i++) {
            try {
                int a = Integer.parseInt(strs[i]);
                userService.deleteUser(a);
            } catch (Exception e) {
            }
        }
    }

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
