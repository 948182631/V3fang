package com.fang.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.fang.commdao.baseDaoHibernateImpl;
import com.fang.pojo.User;
@Repository("UserImpDao")
public class UserImpDao extends baseDaoHibernateImpl<User, Long>  implements UserDao{
	@SuppressWarnings("unchecked")
	public List<Object> qryUser(String username) {
		// TODO 查询用户信息用于验证面和角色赋权
		StringBuffer authHql = new StringBuffer();
		authHql.append("select * from t_sys_user t where username = '"+username+"'");
		final String hql = authHql.toString();
		List<Object> counts = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createSQLQuery(hql);
						return query.list();
					}
				});
		return counts;
	}
}
