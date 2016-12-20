package com.fang.sys.menu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "T_SYS_MENU")
public class Menu {
	String menu_id;
	String menu_ids; // 菜单id
	String menu_name; // 菜单名字
	String menu_href; // 菜单列链接
	String menu_level; // 菜单级别
	String menu_seq; // 菜单序列
	String menu_parent; // 上级菜单
	String menu_role;//使用角色
	
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "menu_id", unique = true, nullable = false, length = 32)
	public String getMenu_id() {
		return menu_id;
	}
	@Column(name = "menu_ids", length = 32)
	public String getMenu_ids() {
		return menu_ids;
	}
	public void setMenu_role(String menuRole) {
		menu_role = menuRole;
	}
	@Column(name = "menu_name", length = 255)
	public String getMenu_name() {
		return menu_name;
	}
	@Column(name = "menu_href", length = 1024)
	public String getMenu_href() {
		return menu_href;
	}
	@Column(name = "menu_level", length = 10)
	public String getMenu_level() {
		return menu_level;
	}
	@Column(name = "menu_seq", length = 512)
	public String getMenu_seq() {
		return menu_seq;
	}
	@Column(name = "menu_parent", length = 512)
	public String getMenu_parent() {
		return menu_parent;
	}
	@Column(name = "menu_role", length = 2048)
	public String getMenu_role() {
		return menu_role;
	}
	
	
	public void setMenu_id(String menuId) {
		menu_id = menuId;
	}

	public void setMenu_ids(String menuIds) {
		menu_ids = menuIds;
	}

	public void setMenu_name(String menuName) {
		menu_name = menuName;
	}

	public void setMenu_href(String menuHref) {
		menu_href = menuHref;
	}

	public void setMenu_level(String menuLevel) {
		menu_level = menuLevel;
	}

	public void setMenu_seq(String menuSeq) {
		menu_seq = menuSeq;
	}

	public void setMenu_parent(String menuParent) {
		menu_parent = menuParent;
	}
}
