package com.fang.dao;

import java.util.List;

import com.fang.commdao.baseDaoHibernate;
import com.fang.pojo.Dict;
import com.fang.pojo.Page;
public interface DictDao  extends baseDaoHibernate<Dict, Long>{
	public List<Object>  qryDict( Page page,String dicttype,String dictname);//查询字典主表
	public List<Object>  qryDict(String dicttype,String dictname);//查询字典主表不带页数

	public int  qryDictCunt(String dicttype, String dictname);//查询字典主表总条数
	public String  deleteDict (String id);
	public List<Object>  qryDictByID(String id);
	public String  updatedict (Dict dict);
}
