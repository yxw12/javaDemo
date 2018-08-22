package com.ht.ces.controller;

import com.ht.ces.model.User;
import com.ht.ces.service.CSUsrService;
import com.ht.ces.service.Impl.CSUsrServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "QuerySingleUser")
public class QuerySingleUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userIdStr=request.getParameter("userId");
        Integer userId=null;
        if(userIdStr!=null){
            userId=new Integer(userIdStr);
        }
        CSUsrService csUsrService=new CSUsrServiceImpl();
        User user = csUsrService.getUserById(userId);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/ces/toUpdate.jsp").forward(request,response);
    }
}
