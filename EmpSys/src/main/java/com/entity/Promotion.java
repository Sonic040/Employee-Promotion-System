package com.entity;

public class Promotion {

	private String empname;
	private int count=0;
	private int rank;
	private int evalution;
	private int roleid;
	public Promotion(String empname, int count, int rank, int evalution, int roleid) {
		super();
		this.empname = empname;
		this.count = count;
		this.rank = rank;
		this.evalution = evalution;
		this.roleid = roleid;
	}
	public Promotion() {
		super();
	}
	public String getEmpname() {
		return empname;
	}
	public int getCount() {
		return count;
	}
	public int getRank() {
		return rank;
	}
	public int getEvalution() {
		return evalution;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public void setEvalution(int evalution) {
		this.evalution = evalution;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	
}
