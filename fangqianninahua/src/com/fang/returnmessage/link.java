package com.fang.returnmessage;



import java.util.Map;

import org.springframework.stereotype.Service;

import com.fang.service.BaseService;

@Service("link")
public class link implements BaseService  {
	public String init(String requestXml) {
		return "您发送的是链接消息！";
	}
	public String init(Map<String, String> map) {
		// TODO Auto-generated method stub
		return "您发送的是链接消息！";
	}
}
