<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.*"%>
<%@page import="com.entity.*"%>
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
<h1>
            Hello
            <%=session.getAttribute("username")%>!
        </h1>
 <h1>Welcome to Employee dashboard</h1><br>
 
 <form action="goalachiveServlet" method="post">
    <input type="submit" value="Goal">
</form>
 <form action="Achive" method="post">
    <input type="submit" value="Achievment">
</form>
<br>
<form action="Logout.jsp" method="get">
    <input type="submit" value="Logout">
</form>
<br>
 <form action="addpro" method="post">
    <input type="submit" value="request the promotion">
</form>
<br>
 <form action="addTransfer" method="post">
          <input type="submit" value="request the Transfer">
         </form>
<%--
int i=Integer.parseInt(request.getParameter("st"));
     if (i==1) { 
          <form action="addTransfer" method="post">
          <input type="hidden" value="request the promotion">
         </form>
         <h1>you are requsted the transfer</h1>
      <% } else if(i>1&&i<5) { %>
         <form action="addTransfer" method="post">
    <input type="hidden" value="request the transfer">
        </form>
        <h1>transfer status is : in Process</h1>
         <% } else if(i==5) { %>
          <form action="addTransfer" method="post">
        <input type="hidden" value="request the transfer">
        </form>
        <h1>transfer status is : Accept</h1>
      <% } else if(i==0){ %>
          <form action="addtrans.jsp" method="post">
        <input type="submit" value="request the transfer">
        </form>
      <% }--%>



<body>
</html>