package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConnect;
import com.entity.Employee;
import com.entity.Promotion;
public class PromotionDao {

	private Connection con;

	public PromotionDao(Connection con) {
		super();
		this.con = con;
	}
	
public List<Promotion> getEmp(int mid){
		
	 List<Promotion> list = new ArrayList<>();
		
	    Promotion e1 =null;
		String s;
		try {
			PreparedStatement ps = con.prepareStatement("select promotion.empname,promotion.count,employee.rank_,employee.evalution,employee.roleid from promotion,employee where promotion.empname=employee.empname and promotion.count=0 and employee.roleid=1 and employee.evalution>80 and employee.mid=?");
			ps.setInt(1, mid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				e1=new Promotion();
				e1.setEmpname(rs.getString(1));
				e1.setCount(rs.getInt(2));
				e1.setRank(rs.getInt(3));
				e1.setEvalution(rs.getInt(4));
				e1.setRoleid(rs.getInt(5));
				list.add(e1);
				
			}
			rs.close();
			ps.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	
	
  }

public List<Promotion> getMng(int mid){
	
	 List<Promotion> list = new ArrayList<>();
		
	    Promotion e1 =null;
		String s;
		try {
			PreparedStatement ps = con.prepareStatement("select promotion.empname,promotion.count,employee.rank_,employee.evalution,employee.roleid from promotion,employee where promotion.empname=employee.empname and employee.evalution>80 and (promotion.count=1 and employee.roleid=1) or (promotion.count=0 and employee.roleid=2) and employee.mid=?");
			ps.setInt(1, mid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				e1=new Promotion();
				e1.setEmpname(rs.getString(1));
				e1.setCount(rs.getInt(2));
				e1.setRank(rs.getInt(3));
				e1.setEvalution(rs.getInt(4));
				e1.setRoleid(rs.getInt(5));
				list.add(e1);
				
			}
			rs.close();
			ps.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	
	
 }
public List<Promotion> getdir(int mid){
	
	 List<Promotion> list = new ArrayList<>();
		
	    Promotion e1 =null;
		String s;
		try {
			PreparedStatement ps = con.prepareStatement("select promotion.empname,promotion.count,employee.rank_,employee.evalution,employee.roleid from promotion,employee where promotion.empname=employee.empname and (promotion.count=2 and employee.roleid=1) or (promotion.count=1 and employee.roleid=2) or (promotion.count=0 and employee.roleid=3) and employee.evalution>80 and employee.mid=?");
			ps.setInt(1, mid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				e1=new Promotion();
				e1.setEmpname(rs.getString(1));
				e1.setCount(rs.getInt(2));
				e1.setRank(rs.getInt(3));
				e1.setEvalution(rs.getInt(4));
				e1.setRoleid(rs.getInt(5));
				list.add(e1);
				
			}
			rs.close();
			ps.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	
	
 }
public List<Promotion> getVice(int mid){
	
	 List<Promotion> list = new ArrayList<>();
		
	    Promotion e1 =null;
		String s;
		try {
			PreparedStatement ps = con.prepareStatement("select promotion.empname,promotion.count,employee.rank_,employee.evalution,employee.roleid from promotion,employee where promotion.empname=employee.empname and (promotion.count=3 and employee.roleid=1) or (promotion.count=2 and employee.roleid=2) or (promotion.count=1 and employee.roleid=3) or (promotion.count=0 and employee.roleid=4) and employee.evalution>80");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				e1=new Promotion();
				e1.setEmpname(rs.getString(1));
				e1.setCount(rs.getInt(2));
				e1.setRank(rs.getInt(3));
				e1.setEvalution(rs.getInt(4));
				e1.setRoleid(rs.getInt(5));
				list.add(e1);
				
			}
			rs.close();
			ps.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	
	
 }
public Promotion editEmp(String name){
	
	
	
	Promotion e1 =null;
	try {
		PreparedStatement ps = con.prepareStatement("select empname,count from promotion where empname=?");
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			e1=new Promotion();
			e1.setEmpname(rs.getString(1));
			e1.setCount(rs.getInt(2));
			e1.setRank(rs.getInt(3));
			e1.setEvalution(rs.getInt(4));
			e1.setRoleid(rs.getInt(5));
			
		}
		rs.close();ps.close();con.close();
	}
	
	
	
	catch(Exception e) {
		e.printStackTrace();
	}
	return e1;

	
}
public boolean deleteEmp(String name){
	
	boolean f= false;
	
	try {
		PreparedStatement ps = con.prepareStatement("delete from promotion where empname=?");
		ps.setString(1, name);
        int i=ps.executeUpdate();
        if(i==1) {
        	f=true;
        }
		ps.close();con.close();
	}
	
	
	
	catch(Exception e) {
		e.printStackTrace();
	}
	return f;

	
}
}