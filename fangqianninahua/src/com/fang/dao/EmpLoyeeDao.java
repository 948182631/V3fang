package com.fang.dao;

import com.fang.commdao.baseDaoHibernate;
import com.fang.pojo.EmpLoyee;
public interface EmpLoyeeDao  extends baseDaoHibernate<EmpLoyee, Long> {
	public String  listUsers();
}
