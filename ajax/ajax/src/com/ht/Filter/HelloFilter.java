package com.ht.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Enumeration;

@WebFilter(filterName = "HelloFilter")
public class HelloFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("过滤器启动...");
        chain.doFilter(req, resp);
        System.out.println("过滤器结束了...");
    }

    public void init(FilterConfig config) throws ServletException {
        //把xml中的值取出来，单值获取
        String name=config.getInitParameter("name");
        System.out.println(name);
        //多值获取,先获取各个值的name

        Enumeration<String> enume = config.getInitParameterNames();
        while (enume.hasMoreElements()){
            String parametrName=enume.nextElement();
            String parametrValue=config.getInitParameter(parametrName);
            System.out.println(parametrValue);
        }
    }

}
