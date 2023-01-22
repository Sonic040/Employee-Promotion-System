package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dao.TransferDao;
import com.db.DBConnect;
import com.entity.Transfer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class addTransfer
 */
@WebServlet("/addTransfer")
public class addTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public addTransfer() {
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
            PreparedStatement ps = con.prepareStatement("select empname,count,st,depid from transfer where empname=?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()) {
               int s=rs.getInt(3);
               int c=rs.getInt(2);
               System.out.println("s= "+s+"c ="+c);
               rd=request.getRequestDispatcher("Goal.jsp");
         	   if(s==1&&c>=2)
               out.println("<h1>Your transfer Status is: Accept  </h1>");
         	   else 
         	   out.println("<h1>Your transfer Status is: In Process  </h1>");
         	   rd.include(request, response);
         	   return;
            }
            
            Transfer t=new Transfer(name);
            TransferDao dao=new TransferDao(DBConnect.getcon());
            
            if(dao.addEmp(t)) {
            	System.out.println("good");
            	request.getRequestDispatcher("/addtrans.jsp").forward(request, response);
                return;
            }
            else 
            {
            	System.out.println("bad");
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
