package com.fang.token;

public class JsapiTicket {
	// 获取到的凭证
	private String ticket;
	// 凭证有效时间，单位：秒
	private int timestamp;
	
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public int getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
