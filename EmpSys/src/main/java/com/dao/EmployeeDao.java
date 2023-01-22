package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConnect;
import com.entity.Employee;

public class EmployeeDao {

	private Connection con;

	public EmployeeDao(Connection con) {
		super();
		this.con=con;
	}
	
	public List<Employee> getEmp(int mid){
		
		List<Employee> list = new ArrayList<>();
		
		Employee e1 =null;
		String s;
		try {
			PreparedStatement ps = con.prepareStatement("select empname,goal,achiv,rank_,evalution from employee where roleid=1 and mid=?");
			ps.setInt(1, mid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				e1=new Employee();
				e1.setEmpname(rs.getString("empname"));
				e1.setGoal(rs.getString("goal"));
				e1.setAchive(rs.getString("achiv"));
				e1.setRank(rs.getInt("rank_"));
				e1.setEvalution(rs.getInt("evalution"));
				list.add(e1);
				
			}
			rs.close();ps.close();con.close();
		}
		
		
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;

		
	}
	public List<Employee> getMng(int mid){
		
		List<Employee> list = new ArrayList<>();
		
		Employee e1 =null;
		String s;
		try {
			PreparedStatement ps = con.prepareStatement("select empname,goal,achiv,rank_,evalution from employee where roleid=2 and mid=?");
			ps.setInt(1, mid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				e1=new Employee();
				e1.setEmpname(rs.getString("empname"));
				e1.setGoal(rs.getString("goal"));
				e1.setAchive(rs.getString("achiv"));
				e1.setRank(rs.getInt("rank_"));
				e1.setEvalution(rs.getInt("evalution"));
				list.add(e1);
				
			}
			rs.close();ps.close();con.close();
		}
		
		
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;

		
	}
	public List<Employee> getdir(int mid){
		
		List<Employee> list = new ArrayList<>();
		
		Employee e1 =null;
		String s;
		try {
			PreparedStatement ps = con.prepareStatement("select empname,goal,achiv,rank_,evalution from employee where roleid=3 and mid=?");
			ps.setInt(1, mid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				e1=new Employee();
				e1.setEmpname(rs.getString("empname"));
				e1.setGoal(rs.getString("goal"));
				e1.setAchive(rs.getString("achiv"));
				e1.setRank(rs.getInt("rank_"));
				e1.setEvalution(rs.getInt("evalution"));
				list.add(e1);
				
			}
			rs.close();ps.close();con.close();
		}
		
		
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;

		
	}
	public List<Employee> getVice(int mid){
		
		List<Employee> list = new ArrayList<>();
		
		Employee e1 =null;
		String s;
		try {
			PreparedStatement ps = con.prepareStatement("select empname,goal,achiv,rank_,evalution from employee where roleid=4 and mid=?");
			ps.setInt(1, mid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				e1=new Employee();
				e1.setEmpname(rs.getString("empname"));
				e1.setGoal(rs.getString("goal"));
				e1.setAchive(rs.getString("achiv"));
				e1.setRank(rs.getInt("rank_"));
				e1.setEvalution(rs.getInt("evalution"));
				list.add(e1);
				
			}
			rs.close();ps.close();con.close();
		}
		
		
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;

		
	}
public List<Employee> getincrease(){
		
		List<Employee> list = new ArrayList<>();
		
		Employee e1 =null;
		String s;
		try {
			PreparedStatement ps = con.prepareStatement("select empname,goal,achiv,rank_,evalution,salary from employee where evalution>60");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				e1=new Employee();
				e1.setEmpname(rs.getString("empname"));
				e1.setGoal(rs.getString("goal"));
				e1.setAchive(rs.getString("achiv"));
				e1.setRank(rs.getInt("rank_"));
				e1.setEvalution(rs.getInt("evalution"));
				e1.setSalary(rs.getInt("salary"));
				list.add(e1);
				
			}
			rs.close();ps.close();con.close();
		}
		
		
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;

		
	}
public Employee editEmp(String name){
		
		
		
		Employee e1 =null;
		try {
			PreparedStatement ps = con.prepareStatement("select empname,goal,achiv,rank_,evalution from employee where empname=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				e1=new Employee();
				e1.setEmpname(rs.getString("empname"));
				e1.setGoal(rs.getString("goal"));
				e1.setAchive(rs.getString("achiv"));
				e1.setRank(rs.getInt("rank_"));
				e1.setEvalution(rs.getInt("evalution"));
				
			}
			rs.close();ps.close();con.close();
		}
		
		
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return e1;

		
	}
public Employee editincrease(String name){
	
	
	
	Employee e1 =null;
	try {
		PreparedStatement ps = con.prepareStatement("select empname,goal,achiv,rank_,evalution,salary from employee where empname=? and inc=0");
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			e1=new Employee();
			e1.setEmpname(rs.getString("empname"));
			e1.setGoal(rs.getString("goal"));
			e1.setAchive(rs.getString("achiv"));
			e1.setRank(rs.getInt("rank_"));
			e1.setEvalution(rs.getInt("evalution"));
			e1.setSalary(rs.getInt("salary"));
		}
		rs.close();ps.close();con.close();
	}
	
	
	
	catch(Exception e) {
		e.printStackTrace();
	}
	return e1;

	
}

}
