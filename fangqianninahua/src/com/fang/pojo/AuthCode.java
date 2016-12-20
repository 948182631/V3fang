package com.fang.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "T_AUTH_CODE")
public class AuthCode implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String auth_id;
	private String empid;
	private String starttime;
	private String endtime;
	private String state;
	private String authcode;
	
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "auth_id", unique = true, nullable = false, length = 32)
	public String getAuth_id() {
		return auth_id;
	}

	public void setAuth_id(String authId) {
		auth_id = authId;
	}
	@Column(name = "empid", length = 32)
	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}
	@Column(name = "starttime", length = 32)
	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	@Column(name = "endtime", length = 32)
	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	@Column(name = "state", length = 1)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	@Column(name = "authcode", length = 8)
	public String getAuthcode() {
		return authcode;
	}

	public void setAuthcode(String authcode) {
		this.authcode = authcode;
	}

}
