package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dao.PromotionDao;
import com.dao.TransferDao;
import com.db.DBConnect;
import com.entity.Promotion;
import com.entity.Transfer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class editTransfer
 */
@WebServlet("/editTransfer")
public class editTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public editTransfer() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String name=request.getParameter("empname");
		 String admin=request.getParameter("Admin");
		 int count=Integer.parseInt(request.getParameter("count"));
		 TransferDao dao=new TransferDao(DBConnect.getcon());
		 Transfer e=dao.editEmp(name);
		 response.setContentType("text/html");
	     PrintWriter out = response.getWriter();
	     HttpSession session = request.getSession();		
		
	     try {
	        	
	        	Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empsys","root","");
	            PreparedStatement ps = con.prepareStatement("update transfer set count=? where empname =?");
	            ps.setInt(1,(count+1));
	            ps.setString(2, name);
	            int i=ps.executeUpdate();
	            
	            ResultSet rs;
	            
	            ps=con.prepareStatement("select transfer.count,transfer.depid,employee.roleid from transfer,employee where transfer.empname=employee.empname and transfer.empname=?");
	            ps.setString(1, name);
	            rs=ps.executeQuery();
	            while(rs.next()) {
	            	int c=rs.getInt(1),r=rs.getInt(3), d=rs.getInt(2);
	            	if(r==1&&c==6||r==2&&c==4||r==3&&c==3) {
	    	            ps=con.prepareStatement(" update transfer set st="+1+" where empname=?");
	    	            ps.setString(1, name);
	    	            ps.executeUpdate();
	    	            ps=con.prepareStatement(" update employee set depid=? where empname=?");
	    	            ps.setInt(1, d);
	    	            ps.setString(2, name);
	    	            ps.executeUpdate();
	            		System.out.println("r= "+r+" c= "+c);
	            	}
	            }	
	            if(i==1) {
	            		request.getRequestDispatcher("/TransferList.jsp?"+admin).forward(request, response);
	            }
	            else
	            	System.out.println("error"+"name "+name+" count "+count);
	            return;
	            
	}
	catch(Exception e2) {
		e2.printStackTrace();
	}
	        
	      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
