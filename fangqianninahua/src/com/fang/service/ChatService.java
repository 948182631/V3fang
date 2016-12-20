package com.fang.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fang.req.TextMessage;
import com.fang.util.MessageUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
/**
 * 核心服务类
 * 
 * @author V3芳
 * @author 2015年1月27日
 */
public class ChatService {
	/**
	 * 处理微信发来的请求
	 * 
	 * @param map
	 * @return
	 */
	public static String chatRequest(Map<String, String> map) {
		String respMessage = null;
		HashMap<String,String> msgmap = new HashMap<String, String>();
		
		try {
			// 默认返回的文本消息内容
			String respContent = "请求处理异常，请稍候尝试！";

			// xml请求解析
			Map<String, String> requestMap = map;

			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");
			//发送人
			String userid = requestMap.get("FromUserName");
			
			// 消息内容
			String content = requestMap.get("Content");

			// 回复文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName); //oZ1l8t1pnl2kEuWuzr1oGoilqJ6U
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			//根据不同的返回类行进行不同的类访问
			ApplicationContext ctx = ContextLoaderListener.getCurrentWebApplicationContext();
			BaseService service = (BaseService) ctx.getBean(msgType);
			respContent =  service.init(map); 
			textMessage.setContent(respContent);  
		    respMessage = MessageUtil.textMessageToXml(textMessage);  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respMessage;
	}
}
