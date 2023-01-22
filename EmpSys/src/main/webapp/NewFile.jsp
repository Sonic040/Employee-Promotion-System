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
<h1>Welcome in Employee promotion system </h1>
<br>
<form action="Login.jsp" method="post">
    <input type="submit" value="Login">
</form>











<%/*Connection con=DBConnect.getcon(); 
out.print(con);
out.println();
System.out.println(con.isClosed());
Statement stm = con.createStatement();
String sqlQuery="SELECT * FROM department";
ResultSet s = stm.executeQuery(sqlQuery);
*/
%>


</body>
</html>