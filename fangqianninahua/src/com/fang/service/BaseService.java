package com.fang.service;

import java.util.Map;


/**
 * 接收消息进行业务处理
 * 
 * @author think
 * 
 */
public interface BaseService {
	public String init(Map<String, String> map);

	public String init(String xml);
}
