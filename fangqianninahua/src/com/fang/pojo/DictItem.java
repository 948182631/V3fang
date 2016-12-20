package com.fang.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "T_SYS_DICT_ITEM", schema = "WEIXIN")
public class DictItem implements java.io.Serializable {
	
	/**
	 * 业务字典项表
	 */
	private static final long serialVersionUID = 1L;
	private String  recid; //记录
	private String  dicttypeid; //字典类型编号
	private String  dictid; //字典项编号
	private String  dictname; //字典项名称
	private String  status; //状态
	private String  sortno; //排序字段
	private String  rank; //层级
	private String  parentid; //父字典项
	private String  seqno; //序列
	private String  filter1; //过滤字段1
	private String  filter2; //过滤字典2
	private String  modflag; //修改标志
	private String  lastupdate; //最新更新日期
	private String  updator; //修改人员
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "recid", unique = true, nullable = false, length = 32)
	public String getRecid() {
		return recid;
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
	@Column(name = "sortno", length = 10)
	public String getSortno() {
		return sortno;
	}
	@Column(name = "rank", length = 10)
	public String getRank() {
		return rank;
	}
	@Column(name = "parentid", length = 255)
	public String getParentid() {
		return parentid;
	}
	@Column(name = "seqno", length = 255)
	public String getSeqno() {
		return seqno;
	}
	@Column(name = "filter1", length = 255)
	public String getFilter1() {
		return filter1;
	}
	@Column(name = "filter2", length = 255)
	public String getFilter2() {
		return filter2;
	}
	@Column(name = "modflag", length = 1)
	public String getModflag() {
		return modflag;
	}
	@Column(name = "lastupdate", length = 32)
	public String getLastupdate() {
		return lastupdate;
	}
	@Column(name = "updator", length = 32)
	public String getUpdator() {
		return updator;
	}
	public void setRecid(String recid) {
		this.recid = recid;
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
	public void setSortno(String sortno) {
		this.sortno = sortno;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}
	public void setFilter1(String filter1) {
		this.filter1 = filter1;
	}
	public void setFilter2(String filter2) {
		this.filter2 = filter2;
	}
	public void setModflag(String modflag) {
		this.modflag = modflag;
	}
	public void setLastupdate(String lastupdate) {
		this.lastupdate = lastupdate;
	}
	public void setUpdator(String updator) {
		this.updator = updator;
	}


}
