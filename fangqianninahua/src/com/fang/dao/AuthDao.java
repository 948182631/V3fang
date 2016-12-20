package com.fang.dao;

import java.util.List;

import com.fang.commdao.baseDaoHibernate;
import com.fang.pojo.AuthCode;

public interface AuthDao  extends baseDaoHibernate<AuthCode, Long>{
	public String  saveAuth(AuthCode authCode);//保存验证码
	public List<Object>  qryAuth(String empid,String time);
	public String  qryAuthcode(String empid,String time,String authcode);
}
