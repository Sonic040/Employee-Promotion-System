package com.entity;

public class Transfer {

	private int count=0;
	private int st=0;
	private int depid;
	private String empname;
	private int roleid;
	public Transfer() {
		super();
	}
	public Transfer(int count, int st, int depid, String empname, int roleid) {
		super();
		this.count = count;
		this.st = st;
		this.depid = depid;
		this.empname = empname;
		this.roleid=roleid;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public Transfer( int depid, String empname) {
		super();
		this.depid = depid;
		this.empname = empname;
	}
	public Transfer(String empname) {
		super();
		this.empname = empname;
	}
	public int getCount() {
		return count;
	}
	public int getSt() {
		return st;
	}
	public int getDepid() {
		return depid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setSt(int st) {
		this.st = st;
	}
	public void setDepid(int depid) {
		this.depid = depid;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	
}
