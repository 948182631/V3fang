package com.fang.prp.weixin;

import java.util.Map;

public class text {
	private String touser;
	private String msgtype;
	private String  agentid;
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	public String getAgentid() {
		return agentid;
	}
	public void setAgentid(String agentid) {
		this.agentid = agentid;
	}
	public Map getText() {
		return text;
	}
	public void setText(Map text) {
		this.text = text;
	}
	private Map text;
	
	
	
}
