package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dao.PromotionDao;
import com.dao.TransferDao;
import com.db.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deleteTransfer
 */
@WebServlet("/deleteTransfer")
public class deleteTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public deleteTransfer() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("empname");
		String admin=request.getParameter("Admin");
		response.setContentType("text/html");
		TransferDao dao=new TransferDao(DBConnect.getcon());
		boolean e=dao.deleteEmp(name);
		System.out.println("e "+e);
		int s = 0;
		if(e) {
		try {
             request.getRequestDispatcher("/TransferList.jsp?"+admin).include(request, response);
	        }
		catch(Exception e2) {
			
			e2.printStackTrace();
		}
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
