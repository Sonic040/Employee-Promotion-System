<%@page import="com.db.DBConnect"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<h1>Login Page </h1>
<br>
<form action="Login" method="post">
    Enter username :<input type="text" name="username"> <br>
    <br>
    Enter password :<input type="password" name="password"><br>
    <input type="submit" value="Login">
</form>

</body>
</html>