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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String un = request.getParameter("username");
        String pw = request.getParameter("password");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empsys","root","");
		    PreparedStatement ps = con.prepareStatement("select count from transfer where empname=?");
            ps.setString(1, un);
            ResultSet rs = ps.executeQuery();
            int s0=0;
            while (rs.next()) {
            	s0=rs.getInt(1);	
            }
		    ps = con.prepareStatement("select empname,password,roleid,depid from employee where empname=? and password=?");
            ps.setString(1, un);
            ps.setString(2, pw);
            rs = ps.executeQuery();

            while (rs.next()) {
            	int s=rs.getInt(3);
            	if(s==1)
                response.sendRedirect("Employeedash.jsp?name=" + un+"&st="+s0);
            	else if(s==2)
            		response.sendRedirect("mangerdash.jsp?name=" + un+"&st="+s0);
            	else if(s==3)
            		response.sendRedirect("directordash.jsp?name=" + un+"&st="+s0);
            	else if(s==4)
            		response.sendRedirect("vicedash.jsp?name=" + un+"&st="+s0);
            	else 
            		response.sendRedirect("prdash.jsp?name=" + un+"&st="+s0);
            	session.setAttribute("username", un);
            	session.setAttribute("depid", rs.getInt(4));
            	session.setAttribute("role", rs.getInt(3));
                return;
            }
            RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
            out.println("<font color=red>Password or username is wrong.</font>");
            rd.include(request, response);
            
            
            
           
       
            return;
        } catch (Exception e) {
               e.printStackTrace();
        }
		
		
		
		
		
		
		
		
		out.close();	
		
	}

}
