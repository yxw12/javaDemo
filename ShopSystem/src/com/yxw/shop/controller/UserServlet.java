package com.yxw.shop.controller;

import com.yxw.shop.modal.User;
import com.yxw.shop.service.Impl.UserServiceImpl;
import com.yxw.shop.service.UserService;
import com.yxw.shop.utils.CommonsUtils;
import com.yxw.shop.utils.MailUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by Yan on 2018/7/19.
 */
@WebServlet(name="UserServlet",urlPatterns="/user")
public class UserServlet extends BaseServlet {

    /**
     * 退出登录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void loginout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        HttpSession session = request.getSession();
        //从session中将user删除
        session.removeAttribute("user");

        //将存储在客户端的cookie删除掉
        Cookie cookie_username = new Cookie("cookie_username","");
        cookie_username.setMaxAge(0);
        //创建存储密码的cookie
        Cookie cookie_password = new Cookie("cookie_password","");
        cookie_password.setMaxAge(0);

        response.addCookie(cookie_username);
        response.addCookie(cookie_password);


        response.sendRedirect(request.getContextPath()+"/login.jsp");

    }

    /**
     * 注册
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //获得表单数据
        Map<String,String[]> properties = request.getParameterMap();
        User user = new User();
        //自己写一个类型转换器（将String转换为Date）
        try{
            ConvertUtils.register(new Converter() {
                @Override
                public Object convert(Class aClass, Object o) {
                    //将String转换为date
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date parse = null;
                    try {
                        parse = format.parse(o.toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return parse;
                }
            },Date.class);
            //映射封装
            BeanUtils.populate(user,properties);
        }catch (Exception e){
            e.printStackTrace();
        }

        user.setUid(CommonsUtils.getUUID());
        user.setTelephone(null);
        user.setState(0);
        String activeCode = CommonsUtils.getUUID();//激活码
        user.setCode(activeCode);

        //将user传递给service层
        UserService userService = new UserServiceImpl();
        Integer isRegisterSuccess = userService.regist(user);

        //是否注册成功
        if(isRegisterSuccess == 1){
            //发送激活邮件
            String emailMsg = "恭喜您注册成功，请点击下面的连接进行激活账户"
                    +"<a href='http://localhost:8080/ShopSystem/user?method=action&activeCode="+activeCode+"'>"
                    + "http://localhost:8080/ShopSystem/user?method=action&activeCode="+activeCode+"</a>";
            try {
                MailUtils.sendMail(user.getEmail(),emailMsg);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            //注册成功跳转成功界面
            response.sendRedirect(request.getContextPath()+"registerSuccess.jsp");
        }else {
            //注册失败跳转失败界面
            response.sendRedirect(request.getContextPath()+"registerFail.jsp");
        }
    }

    /**
     * 激活用户
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void action(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //获得激活码
        String activeCode = request.getParameter("activeCode");

        UserService service = new UserServiceImpl();
        service.active(activeCode);

        //跳转到登录页面
        response.sendRedirect(request.getContextPath()+"/login.jsp");
    }

    /**
     * 检查用户名
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void checkName(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获得用户名
        String username = request.getParameter("username");

        UserService service = new UserServiceImpl();
        Long exist = service.checkUsername(username);
        boolean isExist = false;
        if(exist>0) {
            isExist = true;
            String json = "{\"isExist\":"+isExist+"}";
            response.getWriter().write(json);
            return;
        }
        String json = "{\"isExist\":"+isExist+"}";
        response.getWriter().write(json);
    }

    /**
     * 判断用户是否登录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        HttpSession session = request.getSession();
        //编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
   //     boolean bool=false;
        //获取验证码校验
        String code1 = request.getParameter("checkcode_session");
        String code2 =(String)request.getSession().getAttribute("checkcode_session");
        request.getSession().removeAttribute("checkcode_session");
        if(!code1.equalsIgnoreCase(code2)||code1==null||code1==""){
            //验证码有错误
        //    response.getWriter().print(bool);
            request.setAttribute("loginError", "验证码为空或错误！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return ;
        }


        //获得输入的用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //对密码进行加密
        //password = MD5Utils.md5(password);

        //将用户名和密码传递给service层
        UserService userService = new UserServiceImpl();
        User user = userService.findUserByNamePass(username,password);

        //判断用户是否登录成功 user是否是null
        if(user!=null){
            //登录成功
            //***************判断用户是否勾选了自动登录*****************
            String autoLogin = request.getParameter("autoLogin");
            if("true".equals(autoLogin)){
                //要自动登录
                //创建存储用户名的cookie
                Cookie cookie_username = new Cookie("cookie_username",user.getUsername());
                cookie_username.setMaxAge(10*60);
                //创建存储密码的cookie
                Cookie cookie_password = new Cookie("cookie_password",user.getPassword());
                cookie_password.setMaxAge(10*60);

                response.addCookie(cookie_username);
                response.addCookie(cookie_password);

            }

            //***************************************************
            //将user对象存到session中
            session.setAttribute("user", user);

            //重定向到首页
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else{
            request.setAttribute("loginError", "用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
