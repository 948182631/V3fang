/**
 * 
 */
package com.fang.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author V3芳
 * 
 * @date 2015-10-09
 */
@Entity
@Table(name = "T_SYS_EMPLOYEE")
public class EmpLoyee implements java.io.Serializable {
	/**
	 * 人员信息表
	 */
	private static final long serialVersionUID = 1451922543620000588L;
	private String empid; // id
	private String empcode; // 员工代码
	private String empname; // 员工姓名
	private String realname; // 姓名简称
	private String gender; // 性别
	private String birthdate; // 出生日期
	private String position; // 岗位
	private String empstatus; // 0-正常，1-离职，2-停用
	private String cardtype; // 证件类型：1-身份证，2-护照
	private String cardno; // 证件号码CARDNO
	private String indate; // 入职日期
	private String outdate; // 离职日期
	private String otel; // 办公电话
	private String oaddress; // 办公地址
	private String ozipcode; // 办公邮编
	private String oemail; // 办公邮件
	private String faxno; // 传真号码
	private String mobileno; // 手机号码
	private String msn; // MSN号
	private String htel; // 家庭电话
	private String haddress; // 家庭地址
	private String hzipcode; // 家庭邮编
	private String pemail; // 私人电子邮箱
	private String party; // 政治面貌
	private String degree; // 职务
	private String major; // 直接主管
	private String specialty; // 可授权角色
	private String workexp; // 工作描述
	private String regdate; // 注册日期
	private String createtime; // 创建时间
	private String lastmodytime; // 最新更新日期
	private String orgidlist; // 可管理机构
	private String orgid; // 主机构ID
	private String remark; // 备注
	private String empysryid1; // 映射员工ID

	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "empid", unique = true, nullable = false, length = 32)
	public String getEmpid() {
		return empid;
	}

	@Column(name = "empcode", length = 30)
	public String getEmpcode() {
		return empcode;
	}

	@Column(name = "empname", length = 50)
	public String getEmpname() {
		return empname;
	}

	@Column(name = "realname", length = 50)
	public String getRealname() {
		return realname;
	}

	@Column(name = "gender", length = 10)
	public String getGender() {
		return gender;
	}

	@Column(name = "birthdate", length = 30)
	public String getBirthdate() {
		return birthdate;
	}

	@Column(name = "position", length = 10)
	public String getPosition() {
		return position;
	}

	@Column(name = "empstatus", length = 1)
	public String getEmpstatus() {
		return empstatus;
	}

	@Column(name = "cardtype", length = 1)
	public String getCardtype() {
		return cardtype;
	}

	@Column(name = "cardno", length = 20)
	public String getCardno() {
		return cardno;
	}

	@Column(name = "indate", length = 30)
	public String getIndate() {
		return indate;
	}

	@Column(name = "outdate", length = 30)
	public String getOutdate() {
		return outdate;
	}

	@Column(name = "otel", length = 20)
	public String getOtel() {
		return otel;
	}

	@Column(name = "oaddress", length = 255)
	public String getOaddress() {
		return oaddress;
	}

	@Column(name = "ozipcode", length = 10)
	public String getOzipcode() {
		return ozipcode;
	}

	@Column(name = "oemail", length = 128)
	public String getOemail() {
		return oemail;
	}

	@Column(name = "faxno", length = 14)
	public String getFaxno() {
		return faxno;
	}

	@Column(name = "mobileno", length = 14)
	public String getMobileno() {
		return mobileno;
	}

	@Column(name = "msn", length = 16)
	public String getMsn() {
		return msn;
	}

	@Column(name = "htel", length = 12)
	public String getHtel() {
		return htel;
	}

	@Column(name = "haddress", length = 128)
	public String getHaddress() {
		return haddress;
	}

	@Column(name = "hzipcode", length = 10)
	public String getHzipcode() {
		return hzipcode;
	}

	@Column(name = "pemail", length = 128)
	public String getPemail() {
		return pemail;
	}

	@Column(name = "party", length = 255)
	public String getParty() {
		return party;
	}

	@Column(name = "degree", length = 255)
	public String getDegree() {
		return degree;
	}

	@Column(name = "major", length = 10)
	public String getMajor() {
		return major;
	}

	@Column(name = "specialty", length = 1024)
	public String getSpecialty() {
		return specialty;
	}

	@Column(name = "workexp", length = 512)
	public String getWorkexp() {
		return workexp;
	}

	@Column(name = "regdate", length = 30)
	public String getRegdate() {
		return regdate;
	}

	@Column(name = "createtime", length = 30)
	public String getCreatetime() {
		return createtime;
	}

	@Column(name = "lastmodytime", length = 30)
	public String getLastmodytime() {
		return lastmodytime;
	}

	@Column(name = "orgidlist", length = 1280)
	public String getOrgidlist() {
		return orgidlist;
	}

	@Column(name = "orgid", length = 10)
	public String getOrgid() {
		return orgid;
	}

	@Column(name = "remark", length = 512)
	public String getRemark() {
		return remark;
	}

	@Column(name = "empysryid1", length = 10)
	public String getEmpysryid1() {
		return empysryid1;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public void setEmpcode(String empcode) {
		this.empcode = empcode;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setEmpstatus(String empstatus) {
		this.empstatus = empstatus;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	public void setOutdate(String outdate) {
		this.outdate = outdate;
	}

	public void setOtel(String otel) {
		this.otel = otel;
	}

	public void setOaddress(String oaddress) {
		this.oaddress = oaddress;
	}

	public void setOzipcode(String ozipcode) {
		this.ozipcode = ozipcode;
	}

	public void setOemail(String oemail) {
		this.oemail = oemail;
	}

	public void setFaxno(String faxno) {
		this.faxno = faxno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public void setHtel(String htel) {
		this.htel = htel;
	}

	public void setHaddress(String haddress) {
		this.haddress = haddress;
	}

	public void setHzipcode(String hzipcode) {
		this.hzipcode = hzipcode;
	}

	public void setPemail(String pemail) {
		this.pemail = pemail;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public void setWorkexp(String workexp) {
		this.workexp = workexp;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public void setLastmodytime(String lastmodytime) {
		this.lastmodytime = lastmodytime;
	}

	public void setOrgidlist(String orgidlist) {
		this.orgidlist = orgidlist;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setEmpysryid1(String empysryid1) {
		this.empysryid1 = empysryid1;
	}

}
