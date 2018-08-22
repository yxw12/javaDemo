package com.bdqn.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bdqn.util.QRCodeUtil;

@WebServlet("/qrcode")
public class QRCodeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(QRCodeController.class);
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println(request.getSession().getAttribute("code_url"));
		String code_url = (String)request.getSession().getAttribute("code_url");
        try {
			QRCodeUtil.encode(code_url,response.getOutputStream());
			logger.info("生成二维码成功");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("生成二维码失败："+e.getMessage());
		}
	}

}

