package com.bdqn.util;

public class PayConfigUtil {
	//公众号
	public final static String APP_ID = "wxdba3d7e99afcddc0";
	//开发者密钥
	//public final static String APP_SECRET = "0fd27d81fb8b88551164223cb1b0c8ab";
	//商户号
	public final static String MCH_ID = "1488010322";
	//商户密钥
	public final static String API_KEY = "wxdba3d7e99afcddwxdba3d7e99afcdd";
	//支付完成后回调函数
	public final static String NOTIFY_URL = "http://tp.cqbdqn.cn/wxZfDemo/wrController";
	//支付终端IP地址
	public final static String TRADE_TYPE = "NATIVE";//选择NAVITE那么上传的ip就可以是发机支付的本机ip
	//支付接口URL地址
	public final static String API_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
}
