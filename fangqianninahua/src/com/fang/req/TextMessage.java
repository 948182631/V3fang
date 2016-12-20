package com.fang.req;

/**
 * 文本消息
 * 
 * @author V3芳
 * @author 2015年1月27日
 */
public class TextMessage extends BaseMessage {
	// 消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}