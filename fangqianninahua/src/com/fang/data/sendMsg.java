package com.fang.data;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fang.token.HttpUtil;
@Controller
@RequestMapping("/msg")
public class sendMsg {

	/**
	 * @param args
	 */
	@RequestMapping("/sendMsg.json")
	public @ResponseBody
	String login(HttpServletRequest request, HttpServletResponse reponse)
			throws UnsupportedEncodingException {

		String url= "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token="+"sMSfEvJhrbmmcC2ONkC1Utrg9PyejOEMIGHQOOnemJSXUqNCKoL76LpPsShuSRh5";
	
		HashMap map = new HashMap();
		Map<String, String> maps = new HashMap<String, String>();
		
		// 发送方帐号（open_id）
		 map.put("touser", "yubin");
		
		// 消息类型msgtype	
		 map.put("msgtype", "text");
		//发送人
		 map.put("agentid", 8);
		 maps.put("content", "ssss");
		 map.put("text", maps);
		// 消息内容
		//声明JSONArray对象并输入JSON字符串
		 JSONObject array = JSONObject.fromObject(map);
		 
		 
		System.out.println( array.toString());
		String a =HttpUtil.httpRequest(url, "POST", array.toString()).toString();
		return a;
	}

}
