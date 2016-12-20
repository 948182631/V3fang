package com.fang.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextImpl;

public class MuoUser {
		//获取当前登录用户权限
		public static List<GrantedAuthority> getUserAuth(HttpServletRequest request) {
			SecurityContextImpl securityContextImpl = (SecurityContextImpl) request
			 .getSession().getAttribute("SPRING_SECURITY_CONTEXT");
			 List<GrantedAuthority> authorities = (List<GrantedAuthority>) securityContextImpl
		     .getAuthentication().getAuthorities();
			return authorities;
			
		}
}
