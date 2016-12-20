package com.fang.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fang.token.HttpUtil;

/**
 * 初始化servlet
 * 
 * @author V3芳
 * @date 2015年3月9日11:16:30
 */
public class StartServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(HttpUtil.class);

	public void init() throws ServletException {
			new Thread(new TokenThread()).start();
	}
}