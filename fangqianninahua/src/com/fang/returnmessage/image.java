package com.fang.returnmessage;



import java.util.Map;

import org.springframework.stereotype.Service;

import com.fang.service.BaseService;

@Service("image")
public class image implements BaseService  {
	public String init(String requestXml) {
		return "您发送的是图片消息！";
	}
	
	public String init(Map<String, String> map) {
		// TODO Auto-generated method stub
		return "您发送的是图片消息！";
	}
}
