package com.fang.returnmessage;



import java.util.Map;

import org.springframework.stereotype.Service;

import com.fang.service.BaseService;
import com.fang.util.MessageUtil;

@Service("event")
public class event implements BaseService  {
	
	
	public String init(String requestXml) {
		return "事件";
	}
	
	public String init(Map<String, String> map) {
		// TODO Auto-generated method stub
		String respContent = "请求处理异常，请稍候尝试！";
		// 事件类型
		String eventType = map.get("Event");
		// 订阅
		if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
			
			respContent = "谢谢您的关注！";
		}
		// 取消订阅
		else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
			// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
			System.out.println("s");
		}
		// 自定义菜单点击事件
		else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
			// TODO 自定义菜单权没有开放，暂不处理该类消息
			String eventKey = map.get("EventKey");  
			if (eventKey.equals("11")) {  
                respContent = "<a  href=\"http://y948182631.vicp.cc/www/index.jsp?openid="+"\">点击绑定</a>";  
			}
			if (eventKey.equals("12")) {  
                respContent = "好大的优惠";  
			}
		}
		
		return respContent;
	}
}
