package com.fang.token;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fang.util.TokenThread;



public class JsapiTicketThread implements Runnable{
	private static Logger log = LoggerFactory.getLogger(TokenThread.class);
	public static JsapiTicket jsapiTicket = null;
	public static String ticket = null;
	public static String token;
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		//定时执行的代码
		System.out.println("現在時間：" + new Date()); 
		while(true){
			try {
				jsapiTicket = HttpUtil.getJsapiTicket(getToken());
				if (null != jsapiTicket) {
					log.info("获取ticket成功，有效时长{}秒 token:{}", jsapiTicket.getTimestamp(), jsapiTicket.getTicket());
					ticket=jsapiTicket.getTicket();
					// 休眠7000秒
					Thread.sleep((jsapiTicket.getTimestamp() - 200) * 1000);
				} else {
					token = getToken();
					// 如果ticket为null，60秒后再获取
					Thread.sleep(60 * 1000);
				}
			} catch (Exception e) {
				token = getToken();
				try {
					Thread.sleep(60 * 1000);
				} catch (InterruptedException e1) {
					log.error("{}", e1);
				}
				log.error("{}", e);	
			}
		}
	}
	public String getToken(){
		return TokenThread.Token;
	} 
	
}
