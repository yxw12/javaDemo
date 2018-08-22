package com.ht.ces.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "encoderFilter")
public class encoderFilter implements Filter {
    private String encoder;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //处理post乱码问题
        req.setCharacterEncoding(this.encoder);
        resp.setCharacterEncoding(this.encoder);
        resp.setContentType("text/html;charset="+this.encoder);
        //强制转换ServletRequest为HttpServletRequest用于获得请求方式
        HttpServletRequest request=(HttpServletRequest) req;
        //获得请求方式
        String method = request.getMethod();
        if (method.equalsIgnoreCase("get")){
            //创建装饰器的类
            request=new MyHttpServletRequestWrapper(request,this.encoder);
        }
        chain.doFilter(request, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        //获得当前过滤器的编码
        String paramEncoder=config.getInitParameter("encoder").trim();
        if(paramEncoder!=null && !"".equals(paramEncoder)){
            this.encoder=paramEncoder;
        }
    }

}
