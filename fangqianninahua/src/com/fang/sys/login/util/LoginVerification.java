package com.fang.sys.login.util;

import javax.servlet.http.HttpServletRequest;

import com.fang.pojo.EmpLoyee;

public class LoginVerification {

	
		public boolean loginVerification (HttpServletRequest request){
			EmpLoyee  user = new EmpLoyee();
			user = (EmpLoyee) request.getSession().getAttribute("user");
			if(user!=null){
				 return true;	
			}
			return false;
		}
	
}
