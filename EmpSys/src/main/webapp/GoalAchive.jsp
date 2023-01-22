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
        </h1><br>
        
<form action="Goal" method="post">  
    Enter Your goal :<input style="width:300px;height:100px" type="text" name="goal" > <br>
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>