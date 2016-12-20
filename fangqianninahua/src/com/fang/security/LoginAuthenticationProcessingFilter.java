package com.fang.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 
 *
 */
public class LoginAuthenticationProcessingFilter extends
		UsernamePasswordAuthenticationFilter {

	/**
	 * 登录控制
	 **/
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {
		String Password = obtainPassword(request);
		
		System.out.println(Password);
		return super.attemptAuthentication(request, response);
	}
}
