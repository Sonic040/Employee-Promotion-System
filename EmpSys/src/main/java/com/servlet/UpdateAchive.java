package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateAchive
 */
@WebServlet("/UpdateAchive")
public class UpdateAchive extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UpdateAchive() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String name=session.getAttribute("username").toString();
        String achive=request.getParameter("achive");
        try {
        	
        	Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empsys","root","");
            PreparedStatement ps = con.prepareStatement("update employee set achiv=? where empname =?");
            ps.setString(1, achive);
            ps.setString(2, name);
            int i=ps.executeUpdate();
            ps=con.prepareStatement("select roleid from employee where empname=?");
            ps.setString(1,name);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
            int role=rs.getInt(1);
            if(role==1) {
            	request.getRequestDispatcher("/Employeedash.jsp").forward(request, response);	
            }
            else if(role==2) {
            	request.getRequestDispatcher("/mangerdash.jsp").forward(request, response);
            }
            else if(role==3)
            	request.getRequestDispatcher("/directordash.jsp").forward(request, response);
            else
            	request.getRequestDispatcher("/vicedash.jsp").forward(request, response);

            }
        	
        	
        	
        	
        	
        }
        catch(Exception e) {
        	e.printStackTrace();
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
