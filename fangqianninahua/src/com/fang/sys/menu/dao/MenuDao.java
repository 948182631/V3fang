package com.fang.sys.menu.dao;

import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import com.fang.commdao.baseDaoHibernate;
import com.fang.sys.menu.pojo.Menu;
public interface MenuDao  extends baseDaoHibernate<Menu, Long> {
	public List<Object>  listMenus(List<GrantedAuthority> auth);
}
