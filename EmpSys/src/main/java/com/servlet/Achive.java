package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Achive
 */
@WebServlet("/Achive")
public class Achive extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Achive() {
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
        RequestDispatcher rd;
        try {
        	
        	Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empsys","root","");
            PreparedStatement ps = con.prepareStatement("select achiv from employee where empname=?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            if ( rs.getString(1) == null ||  rs.getString(1).trim().length() == 0 ) {
                request.getRequestDispatcher("/Achive.jsp").forward(request, response);
                return;
                
            
                
            }
           String achive= rs.getString(1);
        	   rd=request.getRequestDispatcher("Goal.jsp");
        	   out.println("<h1>Your achivements is "+achive+" </h1>");
        	   rd.include(request, response);
        	   return;
           
            }
        }
      		catch(Exception e ) {
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
