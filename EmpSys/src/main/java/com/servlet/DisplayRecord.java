package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.dao.EmployeeDao;
import com.db.DBConnect;
import com.entity.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class DisplayRecord
 */
@WebServlet("/DisplayRecord")
public class DisplayRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DisplayRecord() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String un = request.getParameter("user");
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        EmployeeDao dao = new EmployeeDao(DBConnect.getcon());
        List<Employee> EmployeeList = null;
        RequestDispatcher dispatcher ;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/empsys","root","");
            PreparedStatement ps = con.prepareStatement("select employee.roleid,manage.mid from employee,manage where employee.empname=? and manage.empname=?");
            ps.setString(1, un);
            ps.setString(2, un);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	int s=rs.getInt(1);
            	int m=rs.getInt(2);
            	if(s==2)
            		EmployeeList=dao.getEmp(m);
            	else if(s==3)
            		EmployeeList=dao.getMng(m);
            	else if(s==4)
            		EmployeeList=dao.getdir(m);
            	else if(s==5)
            		EmployeeList=dao.getVice(m);
            	dispatcher=request.getRequestDispatcher("/EmployeeList..jsp?Admin="+un);
            	request.setAttribute("EmployeeList", EmployeeList);
        		dispatcher.forward(request, response);
        	
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
