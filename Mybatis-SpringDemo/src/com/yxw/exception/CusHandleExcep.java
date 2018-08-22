package com.yxw.exception;

import com.yxw.modal.MyException;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * 自定义异常处理器
 * Created by Yan on 2018/8/5.
 */
public class CusHandleExcep implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @Nullable Object o, Exception e) {
        // 定义异常信息
        String msg="未知异常";

        // 判断异常类型
        if (e instanceof MyException) {
            // 如果是自定义异常，读取异常信息
            msg = e.getMessage();
        } else {
            // 如果是运行时异常，则取错误堆栈，从堆栈中获取异常信息
            Writer out = new StringWriter();
            PrintWriter s = new PrintWriter(out);
            e.printStackTrace(s);
      //      msg = out.toString();
            msg ="系统异常";
        }

        // 把错误信息发给相关人员,邮件,短信等方式
        // TODO

        // 返回错误页面，给用户友好页面显示错误信息
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", msg);
        modelAndView.setViewName("error");

        return modelAndView;
    }

}

