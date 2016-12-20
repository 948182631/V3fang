package com.fang.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntUrlPathMatcher;
import org.springframework.security.web.util.UrlMatcher;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 *         一个自定义的filter，必须包含authenticationManager,
 *         accessDecisionManager,securityMetadataSource三个属性,所有控制将在这三个类中实现
 *         authenticationManager-用户拥有的权限
 *         accessDecisionManager-访问决策器：用来决定用户是否拥有访问权限的关键类
 *         ，其接口为AccessDecisionManager
 *         securityMetadataSource-资源权限获取器：用来取得访问某个URL或者方法所需要的权限
 *         ，接口为SecurityMetadataSource 资源角色授权器需要单独自定义注入
 */
@Transactional
public class SpringmvcFilterInvocation implements
		FilterInvocationSecurityMetadataSource {

//	@Autowired
//	private RoleDao roleDao;
	
	private UrlMatcher urlMatcher = new AntUrlPathMatcher();;
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	// 由spring调用
	public SpringmvcFilterInvocation() {
		//System.out.println("ssss");
		loadResourceDefine();
	}

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.access.SecurityMetadataSource#getAttributes
	 * (java.lang.Object)
	 */
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {

		FilterInvocation fi = (FilterInvocation) object;

		String url = fi.getRequestUrl();
		String httpMethod = fi.getRequest().getMethod();

		//System.out.println("~~~reqURL~~~:" + url + " --- " + httpMethod);

//		// 构造角色
//		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
//		Collection<ConfigAttribute> attributes = new ArrayList<ConfigAttribute>();
//		ConfigAttribute ca = new SecurityConfig("ROLE_USER");
//		attributes.add(ca);
//		resourceMap.put("/index.jsp", attributes);

		Iterator<String> ite = resourceMap.keySet().iterator();
		while (ite.hasNext()) {
			String resURL = ite.next();
			if (urlMatcher.pathMatchesUrl(resURL, url)) {
				//System.out.println("~~~resURL~~~:" + resURL);
				return resourceMap.get(resURL);
			}
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.access.SecurityMetadataSource#
	 * getAllConfigAttributes()
	 */
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.access.SecurityMetadataSource#supports(java
	 * .lang.Class)
	 */
	public boolean supports(Class<?> clazz) {
		return FilterInvocation.class.isAssignableFrom(clazz);
	}

	// 加载权限-资源
	private void loadResourceDefine() {
		if (resourceMap == null) {
			// 构造角色
			resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
			Collection<ConfigAttribute> attributes = new ArrayList<ConfigAttribute>();
			//默认
			ConfigAttribute ca = new SecurityConfig("ROLE_USER");
		
			attributes.add(ca);
			resourceMap.put("/index.jsp", attributes);
		}
	}
}