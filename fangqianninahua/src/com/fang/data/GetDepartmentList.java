package com.fang.data;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ContextLoaderListener;

import com.fang.dao.EmpLoyeeImpl;
import com.fang.pojo.EmpLoyee;
import com.fang.service.BaseService;

@Controller
@RequestMapping("/getDepartmentList")
public class GetDepartmentList {
	/**
	 * 1注解方式
	 * @Autowired
	 * private UserDaoImpl daoImpl; 
	 * */
	
	
	/**
	 * 2
	 * */
	private EmpLoyeeImpl daoImpl; 
	
	@RequestMapping("/getDepartmentList.json")
	public @ResponseBody String getDepartmentList(HttpServletRequest request,HttpServletResponse reponse){
		//daoImpl = (UserDaoImpl) ContextLoader.getCurrentWebApplicationContext().getBean("UserDaoImpl");
		ApplicationContext ctx = ContextLoaderListener.getCurrentWebApplicationContext();
		BaseService service = (BaseService) ctx.getBean("TXN_100010");
		System.out.println(service.init(""));
		return service.init("");
	}
}
