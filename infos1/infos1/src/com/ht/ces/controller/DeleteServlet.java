package com.ht.ces.controller;

import com.ht.ces.service.CSUsrService;
import com.ht.ces.service.Impl.CSUsrServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userIdStr=request.getParameter("userId");
        Integer userId=null;
        if(userIdStr!=null){
            userId=new Integer(userIdStr);
            CSUsrService csUsrService=new CSUsrServiceImpl();
            csUsrService.daleteUser(userId);
            String path=request.getContextPath();
            response.sendRedirect(path+"/QuseryServlet");
        }
    }
}
