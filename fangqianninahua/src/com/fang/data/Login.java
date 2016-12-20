package com.fang.data;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fang.pojo.EmpLoyee;
import com.opensymphony.xwork2.ActionContext;

@Controller
@RequestMapping("/sys")
public class Login {

 
 
	@RequestMapping("/login.json")
	public @ResponseBody String login(HttpServletRequest request,HttpServletResponse reponse){
		SecurityContextImpl securityContextImpl = (SecurityContextImpl) request
		 .getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		return securityContextImpl.getAuthentication().getName();
	}
	//退出登录
	@RequestMapping("/logout.json")
	public @ResponseBody String logout(HttpServletRequest request,HttpServletResponse reponse){
	  request.removeAttribute("SPRING_SECURITY_LAST_USERNAME"); 
	 return"asd";
   }

	//josn test
	@RequestMapping("/test.json")
	public @ResponseBody String test(HttpServletRequest request,HttpServletResponse reponse){
	
	 return"{\"name\":\"Mike\",\"sex\":\"女\",\"age\":\"29\"} ";
   }
}
