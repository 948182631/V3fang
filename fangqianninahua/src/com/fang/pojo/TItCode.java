package com.fang.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "T_IT_CODE", schema = "WEIXIN")
public class TItCode implements java.io.Serializable {

	private String  codeid;
	private String  codetype;
	private String  codeurl;
	private String  codestate;
	@Id
	@Column(name = "codeid", length = 32)
	public String getCodeid() {
		return codeid;
	}
	@Column(name = "codetype", length = 1)
	public String getCodetype() {
		return codetype;
	}
	@Column(name = "codeurl", length = 255)
	public String getCodeurl() {
		return codeurl;
	}
	@Column(name = "codestate", length = 1)
	public String getCodestate() {
		return codestate;
	}
	public void setCodeid(String codeid) {
		this.codeid = codeid;
	}
	public void setCodetype(String codetype) {
		this.codetype = codetype;
	}
	public void setCodeurl(String codeurl) {
		this.codeurl = codeurl;
	}
	public void setCodestate(String codestate) {
		this.codestate = codestate;
	}

}