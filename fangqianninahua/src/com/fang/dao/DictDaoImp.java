package com.fang.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.fang.commdao.baseDaoHibernateImpl;
import com.fang.pojo.Dict;
import com.fang.pojo.Page;
@Repository("DictDaoImp")
public class DictDaoImp extends baseDaoHibernateImpl<Dict, Long> implements
		DictDao {
	private static org.slf4j.Logger log = LoggerFactory.getLogger(DictDaoImp.class);

	
	@SuppressWarnings("unchecked")
	public List<Object> qryDict( final Page page ,String dicttype, String dictname) {
		// TODO 查询用户信息用于验证面和角色赋权
		StringBuffer authHql = new StringBuffer();
		if(dictname==null)
			dictname="";
		if(dicttype==null)
			dicttype="";
		authHql.append("select * from t_sys_dict t where t.dicttypeid like '%"+dicttype+"%' and t.dictname like '%"+dictname+"%'");
		final String hql = authHql.toString();
		List<Object> counts = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createSQLQuery(hql);
						// 设置每页显示多少个，设置多大结果。
						query.setMaxResults(page.getEveryPage());
						// 设置起点
						query.setFirstResult(page.getBeginIndex());
						return query.list();
					}
				});
		return counts;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Object> qryDict( String dicttype, String dictname) {
		// TODO 查询用户信息用于验证面和角色赋权
		StringBuffer authHql = new StringBuffer();
		if(dictname==null)
			dictname="";
		if(dicttype==null)
			dicttype="";
		authHql.append("select t.recid ,t.dictid,t.dictname,decode(t.status,'0','停用','1','启用') from t_sys_dict t where t.dicttypeid like '%"+dicttype+"%' and t.dictname like '%"+dictname+"%'");
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
	@SuppressWarnings("unchecked")
	public int  qryDictCunt(String dicttype, String dictname) {
		StringBuffer authHql = new StringBuffer();
		if(dictname==null)
			dictname="";
		if(dicttype==null)
			dicttype="";
		authHql.append("select count(*) from t_sys_dict t where t.dicttypeid like '%"+dicttype+"%' and t.dictname like '%"+dictname+"%'");
		final String hql = authHql.toString();
		List<Object> counts = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createSQLQuery(hql);
						return query.list();
					}
				});
		return Integer.parseInt( counts.get(0).toString());
	}
/**
 * 根据id删除
 * */
	@SuppressWarnings("unchecked")
	public String deleteDict(final String id) {
		StringBuffer authHql = new StringBuffer();
		authHql.append("delete Dict  as t where t.recid ='"+id+"'");
		final String hql = authHql.toString();
		List<Object> counts = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						query.executeUpdate();
						session.beginTransaction().commit();
						
						List list= new ArrayList();
						list.add("0");
						return list;
					}
				});
		return counts.get(0).toString();
	}
	/**
	 * 
	 * 根据id查询字典
	 * */
	@SuppressWarnings("unchecked")
	public List<Object> qryDictByID(String id) {
		StringBuffer authHql = new StringBuffer();
		authHql.append("from Dict  t  where t.recid ="+id+"");
		final String hql = authHql.toString();
		List<Object> counts = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						return query.list();
					}
				});
		return counts;
	}
	/**
	 * 修改
	 * */
	@SuppressWarnings("unchecked")
	public String updatedict(Dict dict) {
		// TODO 0成功 1失败
		String msg = "1";
		try {
			this.saveOrUpdate(dict);
			msg ="0";
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e+"");
			msg = "1";
		}
		 return msg;
	}
		
}
