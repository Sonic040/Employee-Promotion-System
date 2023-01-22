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
 * Servlet implementation class EditEmp
 */
@WebServlet("/updateemp")
public class EditEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EditEmp() {
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
        String name=request.getParameter("empname");
        String admin=request.getParameter("Admin");
        String rank=request.getParameter("rank");
        String evalution =request.getParameter("evalution");
try {
        	
        	Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empsys","root","");
            PreparedStatement ps = con.prepareStatement("update employee set rank_=?,evalution=? where empname =?");
            ps.setString(1,rank);
            ps.setString(2, evalution);
            ps.setString(3, name);
            int i=ps.executeUpdate();
            ps=con.prepareStatement("select roleid from employee where empname=?");
            ps.setString(1, admin);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()) {
            int s=rs.getInt(1);	
            if(i==1) {
            	if(s==2)
            		request.getRequestDispatcher("/mangerdash.jsp").forward(request, response);
            	else if(s==3)
            		request.getRequestDispatcher("/directordash.jsp").forward(request, response);
            	else if(s==4)
            		request.getRequestDispatcher("/vicedash.jsp").forward(request, response);
            	else if(s==5)
            		request.getRequestDispatcher("/prdash.jsp").forward(request, response);
            }
            else
            	System.out.println("error"+"name "+name+"rank "+rank);
            return;
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
