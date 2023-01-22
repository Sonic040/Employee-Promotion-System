<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.*"%>
<%@page import="com.entity.*"%>
<%@page import="com.servlet.*"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" import="java.util.*, com.*"
contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Employee List</h1>
<%! List<Employee> EmployeeList; %>
<table cellpadding="5" cellspacing="5" border="1">
<tr>
<th>name</th>
<th>goal</th>
<th>Achive</th>
<th>rank</th>
<th>evalution</th>
</tr>
<%
String admin=request.getParameter("Admin");
EmployeeList = (List<Employee>)request.getAttribute("EmployeeList");
if(EmployeeList != null && !EmployeeList.isEmpty()) {
for(int i=0;i<EmployeeList.size();i++) {		
%>
<tr>
<td><%=EmployeeList.get(i).getEmpname() %></td>
<td><%=EmployeeList.get(i).getGoal() %></td>
<td><%=EmployeeList.get(i).getAchive() %></td>
<td><%=EmployeeList.get(i).getRank() %></td>
<td><%=EmployeeList.get(i).getEvalution() %></td>
<td><a href="editEmp.jsp?empname=<%=EmployeeList.get(i).getEmpname() %>&Admin=<%=admin %>">Review</a></td>
</tr>

<%
}
} else {
%>
<tr>
<td colspan="9" align="center">No Records Available</td>
</tr>
<%
}
%>





</table>
<br>
<br>


<%
int i=(int)session.getAttribute("role");
     if (i==1) { %>
     <a href="Employeedash.jsp?name=<%=admin %>">Dashboard</a>
      <% } else if(i==2) { %>
<a href="mangerdash.jsp?name=<%=admin %>">Dashboard</a>

         <% } else if(i==3) { %>
<a href="directordash.jsp?name=<%=admin %>">Dashboard</a>

      <% } else if(i==4){ %>
<a href="vicedash.jsp?name=<%=admin %>">Dashboard</a>
      <% } else if(i==5){ %>
<a href="prdash.jsp?name=<%=admin %>">Dashboard</a>

      <% } %>












</body>
</html>