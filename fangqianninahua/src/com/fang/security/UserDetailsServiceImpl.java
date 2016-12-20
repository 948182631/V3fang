package com.fang.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.fang.dao.UserDao;
import com.fang.dao.UserImpDao;
import com.fang.util.Md5;

/**
 * 
 * 认证管理器
 */
@Component("userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserImpDao userImpDao;

	/**
	 * 读取登录用户信息
	 */
	public UserDetails loadUserByUsername(final String username)
			throws UsernameNotFoundException, DataAccessException {
		System.out.println("查找名称：" + username);
		List<Object> userlist = userImpDao.qryUser(username);
		if (userlist.size() <= 0) {
			throw new AuthenticationServiceException("用户名不存在");
		} else {
			Object[] userobject = (Object[]) userlist.get(0);
			Collection<GrantedAuthority> grantedAuths;
			if (userobject[3] != null) {
				grantedAuths = obtionGrantedAuthorities(username, userobject[3]
						.toString());// 设置权限
			} else {
				grantedAuths = obtionGrantedAuthorities(username, "");// 设置权限
			}

			User user = new User(username, userobject[2].toString(), true,
					true, true, true, grantedAuths);
			return user;
		}
	}

	// 取得用户的权限
	private List<GrantedAuthority> obtionGrantedAuthorities(String userName,
			String ROLE) {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		if (!ROLE.isEmpty()) {
			String[] roleStrArray = ROLE.split(",");
			for (int i = 0; i < roleStrArray.length; i++) {
				System.out.println("用户权限：" + i + roleStrArray[i]);
				grantedAuthorities
						.add(new GrantedAuthorityImpl(roleStrArray[i]));
			}
		}

		return grantedAuthorities;
	}

}
