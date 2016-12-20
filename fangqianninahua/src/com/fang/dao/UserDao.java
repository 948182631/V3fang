package com.fang.dao;

import java.util.List;

import com.fang.commdao.baseDaoHibernate;
import com.fang.pojo.User;

public interface UserDao  extends baseDaoHibernate<User, Long>{
	public List<Object>  qryUser(String username);//查询用户信息
}
