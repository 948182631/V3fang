package com.fang.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fang.aes.AesException;
import com.fang.aes.WXBizMsgCrypt;
import com.fang.service.ChatService;
import com.fang.util.PropertiesUtil;
import com.fang.util.secret;

/**
 * 核心请求处理类
 * 
 * @author V3芳
 * @date 2015-02-18
 */
public class ChatServlet extends HttpServlet {

	private static String token = PropertiesUtil.getInstance().getProperty(
			"token");
	private static String encodingAESKey = PropertiesUtil.getInstance()
			.getProperty("encodingAESKey");
	private static String corpId = PropertiesUtil.getInstance().getProperty(
			"corpId"); // 你的企业号ID

	/**
	 * 确认请求来自微信服务器 CorpID wx8a6486f94e9c2d29
	 * 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 微信加密签名
		// String signature = request.getParameter("signature");
		// 企业号加密签名
		String msg_signature = request.getParameter("msg_signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");

		System.out.println("request=" + request.getRequestURL());

		PrintWriter out = response.getWriter();
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		String result = null;
		try {
			WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(token, encodingAESKey,
					corpId);
			result = wxcpt.VerifyURL(msg_signature, timestamp, nonce, echostr);
		} catch (AesException e) {
			e.printStackTrace();
		}
		if (result == null) {
			result = token;
		}
		out.print(result);
		out.close();
		out = null;
	}
	/**
	 * 处理微信服务器发来的消息
	 */
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 调用核心业务类接收消息、处理消息
		// 获得请求参数
		String sReqMsgSig = request.getParameter("msg_signature");
		String sReqTimeStamp = request.getParameter("timestamp");
		String sReqNonce = request.getParameter("nonce");
		// 获得post提交的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(request
				.getInputStream()));
		StringBuilder sbuff = new StringBuilder();
		String tmp = null;
		Map<String, String> map = new HashMap<String, String>();
		while ((tmp = br.readLine()) != null) {
			sbuff.append(tmp);
		}
		String sReqData = sbuff.toString(); // 获取加密的xml
		map = secret.decode(sReqMsgSig, sReqTimeStamp, sReqNonce, sReqData);
		String respMessage = ChatService.chatRequest(map);//设置回复内容
		String sEncryptMsg = secret.encryption(respMessage, sReqTimeStamp, sReqNonce);//对回复的内容加密
		PrintWriter out = response.getWriter();
		out.print(sEncryptMsg);
		out.close();
	}

}
