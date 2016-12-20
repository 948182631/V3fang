package com.fang.dao;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;
import com.fang.commdao.baseDaoHibernateImpl;
import com.fang.pojo.AuthCode;

@Repository("AuthDaoImpl")
public class AuthDaoImpl extends baseDaoHibernateImpl<AuthCode, Long> implements
		AuthDao {

	@SuppressWarnings("unchecked")
	public List<Object> qryAuth(String empid, String time) {
		// TODO 验证码是否存在
		StringBuffer authHql = new StringBuffer();
		authHql.append("select * from t_auth_code t where t.starttime < '"
				+ time + "' and t.endtime > '" + time + "' and empid= " + empid
				+ " and t.state ='1'");
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
	public String saveAuth(AuthCode authCode) {
		// TODO Auto-generated method stub
		try {
			this.saveOrUpdate(authCode);
		} catch (Exception e) {
			// TODO: handle exception
			return "E000006";
		}
		return "E000000";
	}
	@SuppressWarnings("unchecked")
	public String qryAuthcode(String empid, String time, String authcode) {
		// TODO 验证验证码是是否正确
		StringBuffer authHql = new StringBuffer();
		authHql.append("select * from t_auth_code t where t.starttime < '"
				+ time + "' and t.endtime > '" + time + "' and empid= " + empid
				+ " and t.state ='1' and lower(t.authcode) = lower('"+authcode+"') ");
		final String hql = authHql.toString();
		List<Object> counts = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createSQLQuery(hql);
						return query.list();
					}
				});
		if (counts.size() == 0) {
			return "E000007";
		} else {
			return "E000000";
		}

	}

}
