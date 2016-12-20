package com.fang.sys.menu.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

import sun.swing.BakedArrayList;

import com.fang.commdao.baseDaoHibernateImpl;
import com.fang.sys.menu.pojo.Menu;

@Repository("MenuDaoImpl")
public class MenuDaoImpl extends baseDaoHibernateImpl<Menu, Long> implements
		MenuDao {

	@SuppressWarnings("unchecked")
	public List<Object> listMenus(List<GrantedAuthority> auth) {
		
			
	
		
		
		StringBuffer userHql = new StringBuffer();
		userHql.append("SELECT T.*  FROM T_SYS_MENU T where   ");
		int authsize =auth.size();
		for(int i=0;i<authsize;i++){
			GrantedAuthority grantedAuthority = auth.get(i);
			if(grantedAuthority.getAuthority().equals("SYSADMIN")){//超级用户
				userHql.delete(0,userHql.length());
				userHql.append("SELECT T.*  FROM T_SYS_MENU T where   ");
				userHql.append("1=1 or ");
				break;
			}
			if(authsize!=1){
			if(i==authsize-1){
				userHql.append("t.menu_role like '%"+grantedAuthority.getAuthority()+"%' ) and ");
			}else if(i==0){
				userHql.append("(t.menu_role like '%"+grantedAuthority.getAuthority()+"%' or ");
			}else{
				userHql.append("t.menu_role like '%"+grantedAuthority.getAuthority()+"%' or ");
			}}else{
				userHql.append("t.menu_role like '%"+grantedAuthority.getAuthority()+"%' and ");
			}
		}
				userHql.append(" t.menu_role is not null ORDER BY MENU_SEQ");
		final String hql = userHql.toString();
		List counts = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createSQLQuery(hql);
//						query.setFirstResult(0);//设置起始行
//						query.setMaxResults(1);//每页条数
						return query.list();
					}
				});
		return counts;
	}

}