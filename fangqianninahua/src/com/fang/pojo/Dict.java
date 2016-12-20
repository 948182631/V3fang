package com.fang.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "T_SYS_DICT")
public class Dict implements java.io.Serializable {
	/**
	 * 业务字典表
	 */
	private static final long serialVersionUID = 1L;
	private String   RECID;  //记录
	private String   dicttypeid;  //字典类型编号
	private String   dictid;   //字典项编号
	private String   dictname;  //字典项名称
	private String   status;  //状态
	
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "RECID", unique = true, nullable = false, length = 32)
	public String getRecid() {
		return RECID;
	}
	@Column(name = "dicttypeid", length = 128)
	public String getDicttypeid() {
		return dicttypeid;
	}
	@Column(name = "dictid", length = 128)
	public String getDictid() {
		return dictid;
	}
	@Column(name = "dictname", length = 255)
	public String getDictname() {
		return dictname;
	}
	@Column(name = "status", length = 10)
	public String getStatus() {
		return status;
	}
	public void setRecid(String recid) {
		this.RECID = recid;
	}
	public void setDicttypeid(String dicttypeid) {
		this.dicttypeid = dicttypeid;
	}
	public void setDictid(String dictid) {
		this.dictid = dictid;
	}
	public void setDictname(String dictname) {
		this.dictname = dictname;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
