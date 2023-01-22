package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConnect;
import com.entity.Transfer;
import com.entity.Transfer;
public class TransferDao {

	private Connection con;

	public TransferDao(Connection con) {
		super();
		this.con = con;
	}

	public List<Transfer> getEmp(int mid,int d){
		
		 List<Transfer> list = new ArrayList<>();
			
		    Transfer e1 =null;
			String s;
			try {
				
				 PreparedStatement ps= con.prepareStatement("select transfer.depid,employee.depid from transfer,employee where transfer.empname=employee.empname and  employee.roleid=1 and transfer.count=1 or transfer.count=2 ");
				 ResultSet rs = ps.executeQuery();
				 while(rs.next()) {
					 if(rs.getInt(2)==d) {
						 ps= con.prepareStatement("select transfer.empname,transfer.count,transfer.st,transfer.depid,employee.roleid,employee.depid from transfer,employee where transfer.empname=employee.empname and (transfer.count=1 and employee.roleid=1) and employee.mid=?");
						 ps.setInt(1, mid);
						 rs = ps.executeQuery();
						 System.out.println("line 1");
					 }
						 else if(rs.getInt(1)==d){
							 ps= con.prepareStatement("select transfer.empname,transfer.count,transfer.st,transfer.depid,employee.roleid,employee.depid from transfer,employee where transfer.empname=employee.empname and (transfer.count=2 and employee.roleid=1) and transfer.depid=?");
							 ps.setInt(1, d);
							 rs = ps.executeQuery();
							 System.out.println("line2");
						 }
						 while(rs.next()) {
								e1=new Transfer();
								e1.setEmpname(rs.getString(1));
								e1.setCount(rs.getInt(2));
								e1.setSt(rs.getInt(3));
								e1.setDepid(rs.getInt(4));
								e1.setRoleid(rs.getInt(5));
								list.add(e1);
						 }
					 
					 
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

	public List<Transfer> getMng(){
		
		 List<Transfer> list = new ArrayList<>();
			
		    Transfer e1 =null;
			String s;
			try {
				PreparedStatement ps = con.prepareStatement("select transfer.empname,transfer.count,transfer.st,transfer.depid,employee.roleid from transfer,employee where transfer.empname=employee.empname and (transfer.count=3 and employee.roleid=1) or (transfer.count=1 and employee.roleid=2)");
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					e1=new Transfer();
					e1.setEmpname(rs.getString(1));
					e1.setCount(rs.getInt(2));
					e1.setSt(rs.getInt(3));
					e1.setDepid(rs.getInt(4));
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
	public List<Transfer> getdir(){
		
		 List<Transfer> list = new ArrayList<>();
			
		    Transfer e1 =null;
			String s;
			try {
				PreparedStatement ps = con.prepareStatement("select transfer.empname,transfer.count,transfer.st,transfer.depid,employee.roleid from transfer,employee where transfer.empname=employee.empname and (transfer.count=4 and employee.roleid=1) or (transfer.count=2 and employee.roleid=2) or (transfer.count=1 and employee.roleid=3)");
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					e1=new Transfer();
					e1.setEmpname(rs.getString(1));
					e1.setCount(rs.getInt(2));
					e1.setSt(rs.getInt(3));
					e1.setDepid(rs.getInt(4));
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
	public List<Transfer> getVice(){
		
		 List<Transfer> list = new ArrayList<>();
			
		    Transfer e1 =null;
			String s;
			try {
				PreparedStatement ps = con.prepareStatement("select transfer.empname,transfer.count,transfer.st,transfer.depid,employee.roleid from transfer,employee where transfer.empname=employee.empname and (transfer.count=5 and employee.roleid=1) or (transfer.count=3 and employee.roleid=2) or (transfer.count=2 and employee.roleid=3) or (transfer.count=1 and employee.roleid=4)");
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					e1=new Transfer();
					e1.setEmpname(rs.getString(1));
					e1.setCount(rs.getInt(2));
					e1.setSt(rs.getInt(3));
					e1.setDepid(rs.getInt(4));
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
	public Transfer editEmp(String name){
		
		
		
		Transfer e1 =null;
		try {
			PreparedStatement ps = con.prepareStatement("select transfer.empname,transfer.count,transfer.st,transfer.depid,employee.roleid from transfer,employee where transfer.empname=employee.empname and transfer.empname=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				e1=new Transfer();
				e1.setEmpname(rs.getString(1));
				e1.setCount(rs.getInt(2));
				e1.setSt(rs.getInt(3));
				e1.setDepid(rs.getInt(4));
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
			PreparedStatement ps = con.prepareStatement("delete from transfer where empname=?");
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
	public boolean addEmp(Transfer t){
		
		boolean f= false;
		
		try {
			PreparedStatement ps = con.prepareStatement("insert into transfer(empname,depid,count,st) values(?,?,?,?)");
			 ps.setString(1, t.getEmpname());
	         ps.setInt(2, 1);
	         ps.setInt(3, 1);
	         ps.setInt(4, 0);
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
