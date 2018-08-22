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
 * Created by Yan on 2018/7/9.
 */
@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userIdStr=request.getParameter("userId");
        Integer userId=null;
        if(userIdStr!=null&&userIdStr!=""){
            userId=new Integer(userIdStr);
            UserService csUsrService=new UserServiceImpl();
            csUsrService.deleteUser(userId);
            String path=request.getContextPath();
            response.sendRedirect(path+"/PageServlet");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
