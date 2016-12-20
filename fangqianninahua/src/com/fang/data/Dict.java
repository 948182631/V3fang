package com.fang.data;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fang.dao.DictDaoImp;
import com.fang.pojo.Page;
import com.fang.util.DataTable;
import com.fang.util.PageUtil;

@Controller
@RequestMapping("/sys")
public class Dict {

	@Autowired
	private DictDaoImp dictDaoImp;

	@RequestMapping("/dict.json")
	public @ResponseBody
	String login(HttpServletRequest request, HttpServletResponse reponse)
			throws UnsupportedEncodingException {

		String  dicttype = request.getParameter("dicttype");
		String  dictname = request.getParameter("dictname");

		List list = dictDaoImp.qryDict(dicttype,dictname);
		JSONObject json = new JSONObject();
		StringBuffer table = new StringBuffer();
		StringBuffer boot = new StringBuffer();


		
		json.put("table", DataTable.dataTable(list, "text-c", true , true,"","&#xe6e2","&#xe6df","&#xe665"));

		return json.toString();
	}
	
	//删除
	@RequestMapping("/dictdelete.json")
	public @ResponseBody
	String delete(HttpServletRequest request, HttpServletResponse reponse)
			throws UnsupportedEncodingException {
		String id =request.getParameter("id");
		return dictDaoImp.deleteDict(id);
	}
	//根基id查询
	@RequestMapping("/qryDictbyid.json")
	public @ResponseBody
	String qryDictbyid(HttpServletRequest request, HttpServletResponse reponse)
			throws UnsupportedEncodingException {
		String id =request.getParameter("id");
		List list = dictDaoImp.qryDictByID(id);
		if(list.size()==0){
			return "";
		}else{
			JSONObject jsonObject = JSONObject.fromObject(list.get(0));
			return jsonObject.toString();
		}
	}
	
	//新增
	@RequestMapping("/addDictby.json")
	public @ResponseBody
	String addDictby(HttpServletRequest request, HttpServletResponse reponse)
			throws UnsupportedEncodingException {
		 request.getParameterMap();  
		
		String s =request.getParameter("b");
		request.getParameter("list[0].username");
		request.getParameter("list");
	
			return "";
		
	}
	
}
