package com.fang.data;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fang.dao.AuthDaoImpl;

/**
 * 验证验证码
 * */

@Controller
@RequestMapping("/auth")
public class VerificationAuth {
	@Autowired
	private AuthDaoImpl authDaoImpl;

	@RequestMapping("/verification.json")
	public @ResponseBody
	String getDepartmentList(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		try {
			String  empid = request.getParameter("empid");
			String  authcode = request.getParameter("authcode");
			return authDaoImpl.qryAuthcode(empid, df.format(new Date()), authcode);
		} catch (Exception e) {
			// TODO: handle exception
			return "E000004";
		}
		
		
	}
}
