package com.yxw.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Yan on 2018/8/5.
 */
public class MyHandlerInterceptor implements HandlerInterceptor {
    // controller执行后且视图返回后调用此方法
    // 这里可得到执行controller时的异常信息
    // 这里可记录操作日志
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        System.out.println("页面渲染后 1");
    }

    // controller执行后但未返回视图前调用此方法
    // 这里可在返回用户前对模型数据进行加工处理，比如这里加入公用信息以便页面显示
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        System.out.println("方法后 1");
    }

    // Controller执行前调用此方法
    // 返回true表示继续执行，返回false中止执行
    // 这里可以加入登录校验、权限拦截等
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        System.out.println("方法前 1");
        //判断用户是否登陆  如果没有登陆  重定向到登陆页面   不放行   如果登陆了  就放行了
        // URL  http://localhost:8080/springmvc-mybatis/login.do
        //URI /login.do
        String requestURI = request.getRequestURI();
        if(!requestURI.contains("/login")){
            String username = (String) request.getSession().getAttribute("username");
            if(null == username){
                response.sendRedirect(request.getContextPath() + "/login.do");
                return false;
            }
        }
        return true;


    }


}
