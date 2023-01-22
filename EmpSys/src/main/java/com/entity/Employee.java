package com.entity;

public class Employee {

	private int empid;
	private String empname;
	private String empCat;
	private int rank;
	private int password;
	private String goal;
	private String achive;
	private int evalution;
	private int salary;
	private int depid;
	private int roleid;
	
	public Employee() {
		super();
	}
	public Employee(String empname, String empCat, int rank, int password, String goal, String achive, int evalution,
			int salary, int depid, int roleid) {
		super();
		this.empname = empname;
		this.empCat = empCat;
		this.rank = rank;
		this.password = password;
		this.goal = goal;
		this.achive = achive;
		this.evalution = evalution;
		this.salary = salary;
		this.depid = depid;
		this.roleid = roleid;
	}
	public int getEmpid() {
		return empid;
	}
	public String getEmpname() {
		return empname;
	}
	public String getEmpCat() {
		return empCat;
	}
	public int getRank() {
		return rank;
	}
	public int getPassword() {
		return password;
	}
	public String getGoal() {
		return goal;
	}
	public String getAchive() {
		return achive;
	}
	public int getEvalution() {
		return evalution;
	}
	public int getSalary() {
		return salary;
	}
	public int getDepid() {
		return depid;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public void setEmpCat(String empCat) {
		this.empCat = empCat;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public void setAchive(String achive) {
		this.achive = achive;
	}
	public void setEvalution(int evalution) {
		this.evalution = evalution;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public void setDepid(int depid) {
		this.depid = depid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	
	
	
	
}
