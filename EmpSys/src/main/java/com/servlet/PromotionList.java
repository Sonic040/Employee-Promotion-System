package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


import com.dao.PromotionDao;
import com.db.DBConnect;

import com.entity.Promotion;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class PromotionList
 */
@WebServlet("/PromotionList")
public class PromotionList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PromotionList() {
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
        PromotionDao dao = new PromotionDao(DBConnect.getcon());
        List<Promotion> PromotionList = null;
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
            		PromotionList=dao.getEmp(m);
            	else if(s==3)
            		PromotionList=dao.getMng(m);
            	else if(s==4)
            		PromotionList=dao.getdir(m);
            	else if(s==5)
            		PromotionList=dao.getVice(m);
            	dispatcher=request.getRequestDispatcher("/PromotionList.jsp?Admin="+un);
            	request.setAttribute("PromotionList", PromotionList);
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
