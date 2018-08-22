package com.ht.ces.controller;

import com.ht.ces.model.User;
import com.ht.ces.service.CSUsrService;
import com.ht.ces.service.Impl.CSUsrServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        CSUsrService csUsrService=new CSUsrServiceImpl();
        User user = csUsrService.getUserByNameAndPass(username, password);
        System.out.println(user);
        if (user!=null){
            HttpSession session=request.getSession();
            session.setAttribute("user",user);
            String path = request.getContextPath();
            response.sendRedirect(path+"/ces/tab.jsp");
        }else {
            response.getWriter().print("用户名或者密码错误");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
