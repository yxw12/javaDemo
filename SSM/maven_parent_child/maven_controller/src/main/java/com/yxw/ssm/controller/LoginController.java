package com.yxw.ssm.controller;

import com.yxw.ssm.controller.exceptionResolver.CustomException;
import com.yxw.ssm.entity.ActiveUser;
import com.yxw.ssm.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


/**
 * 
 * <p>Title: LoginController</p>
 * <p>Description: 用户登陆</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-2-9下午5:42:03
 * @version 1.0
 */
@Controller
public class LoginController {
	
	@Autowired
	private SysService sysService;
	public void tset111(){
		System.out.println("123");
	}

	//用户登陆提交
	@RequestMapping("/loginsubmit")
	public String loginsubmit(HttpSession session,String usercode,String password,String randomcode) throws Exception{

		System.out.println("123");
		//校验验证码
		//从session获取正确的验证码
		String validateCode = (String)session.getAttribute("validateCode");
		if(!randomcode.equals(validateCode)){
			//抛出异常：验证码错误
			throw new CustomException("验证码 错误 ！");
		}
		//用户身份认证
		ActiveUser activeUser = sysService.authenticat(usercode, password);
		
		//记录session
		session.setAttribute("activeUser", activeUser);
		
		return "redirect:first.action";
	}
	//退出
	@RequestMapping("/logout")
	public String logout(HttpSession httpSession) throws Exception{
		//清空session
		httpSession.invalidate();
		
		return "redirect:first.action";
	}
}
