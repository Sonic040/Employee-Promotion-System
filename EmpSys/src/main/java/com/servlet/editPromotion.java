package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dao.PromotionDao;
import com.db.DBConnect;
import com.entity.Promotion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class editPromotion
 */
@WebServlet("/editPromotion")
public class editPromotion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public editPromotion() {
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
		 PromotionDao dao=new PromotionDao(DBConnect.getcon());
		 Promotion e=dao.editEmp(name);
		 response.setContentType("text/html");
	     PrintWriter out = response.getWriter();
	     HttpSession session = request.getSession();		
		
	     try {
	        	
	        	Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empsys","root","");
	            PreparedStatement ps = con.prepareStatement("update promotion set count=? where empname =?");
	            ps.setInt(1,(count+1));
	            ps.setString(2, name);
	            int i=ps.executeUpdate();
	            
	            ResultSet rs;
	            
	            ps=con.prepareStatement("select promotion.count,employee.roleid from promotion,employee where promotion.empname=?");
	            ps.setString(1, name);
	            rs=ps.executeQuery();
	            while(rs.next()) {
	            	int c=rs.getInt(1),r=rs.getInt(2);
	            	if(r==1&&c==4||r==2&&c==3||r==3||c==2) {
	    	            ps=con.prepareStatement(" update employee set st="+1+" where empname=?");
	    	            ps.setInt(1, r+1);
	    	            ps.setString(2, name);
	    	            ps.executeUpdate();
	            	}
	            }
	            ps=con.prepareStatement("select roleid from employee where empname=?");
	            ps.setString(1, admin);
	            rs=ps.executeQuery();
	            while(rs.next()) {
	            int s=rs.getInt(1);	
	            if(i==1) {
            		request.getRequestDispatcher("/PromotionList.jsp?"+admin).forward(request, response);
            }
	            else
	            	System.out.println("error"+"name "+name+" count "+count);
	            return;
	        }
	            
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
