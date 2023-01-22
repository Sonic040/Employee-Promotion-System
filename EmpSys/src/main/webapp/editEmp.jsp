<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.EmployeeDao"%>
<%@page import="com.entity.Employee"%>
<%@page import="com.servlet.*"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>UPdate Employee</h1>
<br>
<%
 String name=request.getParameter("empname");
 String admin=request.getParameter("Admin");
 EmployeeDao dao=new EmployeeDao(DBConnect.getcon());
 Employee e=dao.editEmp(name);
 


%>
<form action="updateemp?empname=<%= e.getEmpname()%>&Admin=<%= admin%>" method="post">
    <h1>Emp name : <%=e.getEmpname() %></h1>
    <br>
    <h1>Emp Goal : <%=e.getGoal() %></h1>
    <br>
    <h1>Emp achievment : <%=e.getAchive() %></h1>
    <br>
    Enter Employee Rank (1-5) :<input type="text" name="rank" value="<%=e.getRank()%>"> <br>
    <br>
    Enter Employee evalution (100) :<input type="text" name="evalution" value="<%=e.getEvalution()%>"><br>
    <input type="submit" value="Update">
</form>
















</body>
</html>