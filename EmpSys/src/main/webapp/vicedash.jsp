<%@page import="com.db.DBConnect"%>
<%@page import="java.sql.*"%>
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
 <h1>Welcome to vice.prisidant dashboard</h1><br>
  <a href="DisplayRecord?user=<%=session.getAttribute("username")%>">Click here to get All Employee List</a>
 <br>
 <a href="PromotionList?user=<%=session.getAttribute("username")%>">Click here to get All Promotion List</a>
 <br>
  <a href="TransferList?user=<%=session.getAttribute("username")%>">Click here to get All Transfer List</a>
 <br>
<form action="Logout.jsp" method="get">
    <input type="submit" value="Logout">
</form>
<form action="goalachiveServlet" method="post">
    <input type="submit" value="Goal">
</form>
 <form action="Achive" method="post">
    <input type="submit" value="Achievment">
</form>
</body>
</html>