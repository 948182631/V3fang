package com.fang.util;

import java.util.List;

public class DataTable {
	/**
	 * list 查询集合 css 表格样式 multiple 是否需要多选 operation 是否需要操作
	 * 
	 * @author V3芳
	 * @date 2016年4月6日13:53:24
	 * */
	public static String dataTable(List<Object> list, String css,
			boolean multiple, boolean operation) {

		StringBuffer table = new StringBuffer();

		for (int i = 0; i < list.size(); i++) {
			Object[] object = (Object[]) list.get(i);

			table.append("<tr class='" + css + "' id = '" + object[0] + "TB"
					+ "'>");

			if (multiple) {
				table.append("<td><input type='checkbox' value='1' id ='"
						+ object[0] + "DX" + "'></td>");
			}
			int objectSize = object.length;
			for (int j = 1; j < object.length; j++) {

				table.append("<td >" + object[j] + "</td>");

			}
			if (operation) {
				table.append("<td ><i class='Hui-iconfont' style = 'font-size: 18' id='"
						+ object[0]
						+ "')' >&#xe6df;</i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class='Hui-iconfont' style='color:#FF6666;font-size: 30' onclick='delect("
						+ object[0] + ")' >&#xe6e2;</i></td>");
			}
			table.append("</tr>");

		}

		return table.toString();

	}

	public static String dataTable(List<Object> list, String css,
			boolean multiple, boolean operation, String add, String del,
			String updata, String qry) {

		StringBuffer table = new StringBuffer();

		for (int i = 0; i < list.size(); i++) {
			Object[] object = (Object[]) list.get(i);

			table.append("<tr class='" + css + "' id = '" + object[0] + "TB"
					+ "'>");

			if (multiple) {
				table.append("<td><input type='checkbox' value='1' id ='"
						+ object[0] + "DX" + "'></td>");
			}
			int objectSize = object.length;
			for (int j = 1; j < object.length; j++) {

				table.append("<td >" + object[j] + "</td>");

			}
			if (operation) {
				table.append("<td >");
				if (!qry.isEmpty()) {

					table.append("<i class='Hui-iconfont' onclick='qry("
							+ object[0] + ")'  style = 'font-size: 20' id='"
							+ object[0] + "' data-remodal-target='modal')' >"
							+ qry + ";</i>&nbsp;&nbsp;");
				}
				if (!add.isEmpty()) {

					table.append("<i class='Hui-iconfont' onclick='add("
							+ object[0] + ")'  style = 'font-size: 20' id='"
							+ object[0] + "' data-remodal-target='modal')' >"
							+ add + ";</i>&nbsp;&nbsp;");
				}
				if (!updata.isEmpty()) {

					table.append("<i class='Hui-iconfont' onclick='updata("
							+ object[0] + ")'  style = 'font-size: 20' id='"
							+ object[0] + "' data-remodal-target='modal')' >"
							+ updata + ";</i>&nbsp;&nbsp;");
				}
				if (!del.isEmpty()) {

					table.append("<i class='Hui-iconfont' onclick='del("
							+ object[0] + ")'  style = 'color:#FF6666;font-size: 22' id='"
							+ object[0] + "' data-remodal-target='modal')' >"
							+ del + ";</i>&nbsp;&nbsp;");
				}
			
			
				table.append("</td>");
			}
			table.append("</tr>");

		}

		return table.toString();

	}
}
