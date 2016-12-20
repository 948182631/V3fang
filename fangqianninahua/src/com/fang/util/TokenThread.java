package com.fang.util;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fang.token.AccessToken;
import com.fang.token.HttpUtil;

/**
 * 定时获取微信access_token的线程
 * 
 * @author V3芳
 * @date 2015年3月9日10:31:29
 */
public class TokenThread implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(TokenThread.class);
	// 第三方用户唯一凭证
	public static String appid = PropertiesUtil.getInstance().getProperty("corpId");;
	// 第三方用户唯一凭证密钥
	public static String appsecret = PropertiesUtil.getInstance().getProperty("appsecret");;
	public static AccessToken accessToken = null;
	public  static  String Token  = null;
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("現在時間：" + new Date());
		System.out.println(appid + "--" + appsecret);
		while (true) {
			
			try {
				accessToken = HttpUtil.getAccessToken(appid, appsecret);
				if (null != accessToken) {
					log.info("获取access_token成功，有效时长{}秒 token:{}", accessToken
							.getExpiresIn(), accessToken.getToken());
					
					Token=accessToken.getToken();
					
					// 休眠7000秒
					Thread.sleep((accessToken.getExpiresIn() - 200) * 1000);
				} else {
					// 如果access_token为null，60秒后再获取
					Thread.sleep(60 * 1000);
				}
			} catch (InterruptedException e) {
				try {
					Thread.sleep(60 * 1000);
				} catch (InterruptedException e1) {
					log.error("{}", e1);
				}
				log.error("{}", e);
			}
		}

	}
}