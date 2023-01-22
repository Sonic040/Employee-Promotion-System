package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class IncreaseSalary
 */
@WebServlet("/IncreaseSalary")
public class IncreaseSalary extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public IncreaseSalary() {
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
        int ev=Integer.parseInt(request.getParameter("evalution"));
        int s=Integer.parseInt(request.getParameter("s"));
        int res=(int) ((0.1*(ev/100)*s)+s+50);
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empsys","root","");
            PreparedStatement ps = con.prepareStatement("update employee set salary=?,inc=? where empname=? and inc=?");
            ps.setInt(1,res);
            //ps.setInt(1, 1);
            ps.setString(3, name);
            ps.setInt(2,1);
            ps.setInt(4,0);
            int i=ps.executeUpdate();
        	request.getRequestDispatcher("/increaselist.jsp?"+admin).forward(request, response);
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
