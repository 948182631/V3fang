package com.fang.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import jxl.format.Pattern;

import org.junit.Test;
import org.quartz.Matcher;

public class Snippet {
	@Test
		public void testGenerateToken(){
			
//			String token = new TokenProcessor().generateToken("Vicky",true);
//			
//			System.err.println(token);
//	
//			String token2 = new TokenProcessor().generateToken("Vicky",false);
		  Date d=new Date();   
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.err.println(df.format(new Date()));
			System.err.println(df.format(new Date(d.getTime()+ 300000)));
		}
	public static String getRandomString(int length) { //length表示生成字符串的长度
	    String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";   
	    Random random = new Random();   
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < length; i++) {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }   
	    return sb.toString();   
	 }   

}

