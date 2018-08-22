package com.ht.ces.filter;

import com.ht.ces.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //把servletRequest转换成HttpservletRequest
        HttpServletRequest request=(HttpServletRequest)req;
        //获得Session
        HttpSession session=request.getSession();
        //从Session 中获取user
        User user= (User) session.getAttribute("user");
        if(user==null){
            HttpServletResponse response= (HttpServletResponse) resp;
            String path = request.getContextPath();
            response.sendRedirect(path+"/Login.jsp");
        }else{
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
