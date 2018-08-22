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
import java.util.List;

@WebServlet(name = "QuseryServlet")
public class QuseryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CSUsrService csUsrService=new CSUsrServiceImpl();
        List<User> userList = csUsrService.listUser();
        request.setAttribute("userList",userList);
        request.getRequestDispatcher("ces/tab.jsp").forward(request,response);
    }
}
