package com.fang.req;

/**
 * 图片消息
 * 
 * @author V3芳
 * @author 2015年1月27日
 */
public class ImageMessage extends BaseMessage {
	// 图片链接
	private String PicUrl;

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
}
