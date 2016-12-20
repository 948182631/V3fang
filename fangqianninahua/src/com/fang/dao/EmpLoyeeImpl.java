package com.fang.dao;

import java.sql.SQLException;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.fang.commdao.baseDaoHibernateImpl;
import com.fang.pojo.EmpLoyee;

@Repository("UserDaoImpl")
public class EmpLoyeeImpl extends baseDaoHibernateImpl<EmpLoyee, Long>  implements EmpLoyeeDao  {
	public String listUsers() {
		
		StringBuffer userHql = new StringBuffer();
		userHql.append("select T_SYS_TODO_SEQ.nextval from dual");
		final String hql = userHql.toString();
		 List counts = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createSQLQuery(hql);
				return query.list();
			}});
		String  seq = counts.get(0).toString();
		 return  seq;
	}
}