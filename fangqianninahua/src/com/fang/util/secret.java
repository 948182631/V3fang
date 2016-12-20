package com.fang.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.fang.aes.AesException;
import com.fang.aes.WXBizMsgCrypt;

public class secret {
	
	private static String token = PropertiesUtil.getInstance().getProperty("token");
	private static String encodingAESKey = PropertiesUtil.getInstance().getProperty("encodingAESKey");
	private static String corpId = PropertiesUtil.getInstance().getProperty("corpId"); 
	
	@SuppressWarnings("unchecked")
	public static  Map decode(String sReqMsgSig,String sReqTimeStamp, String sReqNonce, String sReqData) {
		// TODO Auto-generated method stub
		 WXBizMsgCrypt wxcpt;
		 Map<String, String> map = new HashMap<String, String>();
         //解密
			try {
				wxcpt = new WXBizMsgCrypt(token, encodingAESKey,corpId);
				String sMsg = wxcpt.DecryptMsg(sReqMsgSig, sReqTimeStamp, sReqNonce, sReqData);
				Document doc = null;
				doc = DocumentHelper.parseText(sMsg);
				Element rootElt = doc.getRootElement();
				List<Element> elementList = rootElt.elements();
				for (Element e : elementList){
						map.put(e.getName(), e.getText());
				}
				return map;
			} catch (AesException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				map.put("error", ErrorCode.E000001);
			}   catch (DocumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				map.put("error", ErrorCode.E000001);
			} 
		return map;
	}
	
	public static  String  encryption(String respMessage, String sReqTimeStamp, String sReqNonce){
		
		 WXBizMsgCrypt wxcpt;
		 String callBak ="错误代码：E000005"+ErrorCode.E000005;
		try {
			wxcpt = new WXBizMsgCrypt(token, encodingAESKey,corpId);
			callBak = wxcpt.EncryptMsg(respMessage, sReqTimeStamp, sReqNonce);//对回复的内容加密
		} catch (AesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return callBak;
	}
}
