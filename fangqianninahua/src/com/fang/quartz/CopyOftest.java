package com.fang.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CopyOftest {



	 public void work() {
		  
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  Date date =  new Date();
		  System.out.println(sdf.format(date) + "  9执行Quartz定时器");
		   
		 }
	
	
}
