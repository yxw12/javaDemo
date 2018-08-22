package com.bdqn.controller;

import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jdom.JDOMException;

import com.bdqn.util.HttpUtil;
import com.bdqn.util.PayCommonUtil;
import com.bdqn.util.PayConfigUtil;
import com.bdqn.util.XMLUtil;

@WebServlet("/pay")
public class PayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(PayController.class);

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
		// 保存公众号
		packageParams.put("appid", PayConfigUtil.APP_ID);
		// 保存商户号
		packageParams.put("mch_id", PayConfigUtil.MCH_ID);
		// 随机字符串
		packageParams.put("nonce_str", String.valueOf(PayCommonUtil.buildRandom(30)));
		// 商品描述
		packageParams.put("body", request.getParameter("body"));
		// 商品订单
		packageParams.put("out_trade_no", request.getParameter("out_trade_no"));
		// 商品价格
		packageParams.put("total_fee", request.getParameter("total_fee"));
		// 终端IP
		packageParams.put("spbill_create_ip", PayCommonUtil.getHostIP());
		// 回掉地址
		packageParams.put("notify_url", PayConfigUtil.NOTIFY_URL);
		// 支付类型
		packageParams.put("trade_type", PayConfigUtil.TRADE_TYPE);
		logger.info("准备支付！");
		// 商户安全密钥
		String sign = PayCommonUtil.createSign("UTF-8", packageParams, PayConfigUtil.API_KEY);
		// 签名
		packageParams.put("sign", sign);
		logger.info("sign: " + sign);
		String requestXML = PayCommonUtil.getRequestXml(packageParams);
		logger.info("requestXML: " + requestXML);
		String resXml = HttpUtil.postData(PayConfigUtil.API_URL, requestXML);
		logger.info("resXml: " + resXml);
		@SuppressWarnings("rawtypes")
		Map map = null;
		try {
			map = XMLUtil.doXMLParse(resXml);
		} catch (JDOMException e) {
			logger.info("签名或者什么错误：" + e.getMessage());
			e.printStackTrace();
		}
		String urlCode = (String) map.get("code_url");
		logger.info("urlCode: " + urlCode);
		request.getSession().setAttribute("code_url", urlCode);
		request.getRequestDispatcher("pay.jsp").forward(request, response);
	}

}
