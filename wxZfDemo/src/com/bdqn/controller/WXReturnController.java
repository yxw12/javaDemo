package com.bdqn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("/wrController")
public class WXReturnController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(WXReturnController.class);
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("回调成功");
	}

}
