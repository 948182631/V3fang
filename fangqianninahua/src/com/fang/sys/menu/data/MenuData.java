package com.fang.sys.menu.data;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fang.sys.menu.dao.MenuDaoImpl;
import com.fang.util.MuoUser;

@Controller
@RequestMapping("/menu")
public class MenuData {
	@Autowired
	private MenuDaoImpl menuDaoImpl;

	@RequestMapping("/menulist.json")
	public @ResponseBody
	String getDepartmentList(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		
		StringBuffer buffer = new StringBuffer();
		List<Object> lsit = menuDaoImpl.listMenus(	MuoUser.getUserAuth(request));
		String start="s";
		String end="d";
		for(int i =0;i<lsit.size();i++){
			Object[] menu = (Object[]) lsit.get(i);
			if(i!=0){//判断二级菜单是够循环完
				if("1".equals(menu[4])){
					buffer.append("	</ul></dd></dl>");
				}
			}
		
			if("1".equals(menu[4])){//生成一级菜单
				buffer.append("<dl id=\"menu-product\"><dt>");
				buffer.append("<i class=\"Hui-iconfont\">"+menu[8]+"</i>"+menu[2]+"<i class=\"Hui-iconfont menu_dropdown-arrow\">&#xe6d5;</i></dt>");
				start=menu[1].toString();
				
			}
			if(start.equals(menu[6])&&"2".equals(menu[4])){//判断是否有二级菜单
				buffer.append("<dd >");
				buffer.append("<ul>");
				start="s";
			}
			if("2".equals(menu[4])){//生成二级菜单
				buffer.append("<li ><a _href="+menu[3]+" id="+menu[1]+"  href=\"javascript:void(0)\">"+menu[2]+"</a></li>");
				end=menu[6].toString();
				if(i==lsit.size()-1){//最后生成菜单结尾
						buffer.append("	</ul></dd></dl>");
				}
			}
	
		}
		
		System.out.println(buffer.toString());
		
		return buffer.toString();
	}
}
