package com.fang.data;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fang.dao.AuthDaoImpl;
import com.fang.pojo.AuthCode;
import com.fang.util.ErrorCode;
import com.fang.util.Snippet;


/**
 * 生成验证码和再次生成验证码
 * */
@Controller
@RequestMapping("/auth")
public class GainAuthCodedata {
	@Autowired
	private AuthDaoImpl authDaoImpl;

	@RequestMapping("/produce.json")
	public @ResponseBody
	String getAuth(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		String authcode = Snippet.getRandomString(4);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date d = new Date();
		AuthCode authCode = new AuthCode();
		String  empid = request.getParameter("empid");
		List<Object> lsit = authDaoImpl.qryAuth(empid, df.format(new Date()));
		if (lsit != null && lsit.size() > 0) {
			Object[] auth = (Object[]) lsit.get(0);
			 authCode.setAuth_id((String)auth[0]);
			 authCode.setAuthcode(authcode);
			 authCode.setEmpid(empid);
			 authCode.setStarttime(df.format(new Date()));
			 authCode.setEndtime(df.format(new Date(d.getTime()+ 300000)));
			 authCode.setState("1");
			 String callbak =authDaoImpl.saveAuth( authCode);
			 if(callbak.equals("E000000")){
			 return authcode;
			 }else{
			 return ErrorCode.E000000; 
			 }
		}else{
			 authCode.setAuthcode(authcode);
			 authCode.setEmpid(empid);
			 authCode.setStarttime(df.format(new Date()));
			 authCode.setEndtime(df.format(new Date(d.getTime()+ 300000)));
			 authCode.setState("1");
			 String callbak =authDaoImpl.saveAuth( authCode);
			 if(callbak.equals("E000000")){
			 return authcode;
			 }else{
			 return ErrorCode.E000000;
			 }
		}

	}
}
