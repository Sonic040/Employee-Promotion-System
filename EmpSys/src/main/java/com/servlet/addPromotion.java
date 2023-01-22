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
 * Servlet implementation class addPromotion
 */
@WebServlet("/addpro")
public class addPromotion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public addPromotion() {
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
            PreparedStatement ps = con.prepareStatement("select promotion.empname,promotion.count,employee.st from promotion,employee where promotion.empname=?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()) {
               int s=rs.getInt(3);
               int c=rs.getInt(2);
               System.out.println("s= "+s+"c ="+c);
               rd=request.getRequestDispatcher("Goal.jsp");
         	   if(s==1&&c>=2)
               out.println("<h1>Your promotion Status is: Accept  </h1>");
         	   else 
         	   out.println("<h1>Your promotion Status is: In Process  </h1>");
         	   rd.include(request, response);
         	   return;
            }
            ps=con.prepareStatement("insert into promotion(empname,count) values(?,?)");
            ps.setString(1, name);
            ps.setInt(2, 0);
            int i=ps.executeUpdate();
            ps=con.prepareStatement("select roleid from employee where empname=?");
            ps.setString(1, name);
            rs=ps.executeQuery();
            while(rs.next()) {
            int s=rs.getInt(1);	
            if(i==1) {
            	if(s==1) {
               rd=request.getRequestDispatcher("Goal.jsp");
         	   out.println("<h1>You are requssted to promotin successfully</h1>");
         	   rd.include(request, response);
         	   return;
            	}
                else if(s==2){
                    rd=request.getRequestDispatcher("Goal.jsp");
              	   out.println("<h1>You are requssted to promotin successfully </h1>");
              	   rd.include(request, response);
              	   return;
                 	}
            	else if(s==3){
                    rd=request.getRequestDispatcher("Goal.jsp");
              	   out.println("<h1>You are requssted to promotin successfully </h1>");
              	   rd.include(request, response);
              	   return;
                 	}
            	else if(s==4){
                    rd=request.getRequestDispatcher("Goal.jsp");
              	   out.println("<h1>You are requssted to promotin successfully </h1>");
              	   rd.include(request, response);
              	   return;
                 	}
            	else if(s==5){
                    rd=request.getRequestDispatcher("Goal.jsp");
              	   out.println("<h1>You are requssted to promotin successfully </h1>");
              	   rd.include(request, response);
              	   return;
                 	}
            }
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
