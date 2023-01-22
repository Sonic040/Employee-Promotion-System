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
<h1>Transfer List</h1>
<%! List<Transfer> TransferList; %>
<table cellpadding="5" cellspacing="5" border="1">
<tr>
<th>name</th>
<th>count</th>
<th>new department</th>
<th>role</th>
</tr>
<%
String admin=request.getParameter("Admin");
TransferList = (List<Transfer>)request.getAttribute("TransferList");
if(TransferList != null && !TransferList.isEmpty()) {
for(int i=0;i<TransferList.size();i++) {		
%>
<tr>
<td><%=TransferList.get(i).getEmpname() %></td>
<td><%=TransferList.get(i).getCount() %></td>
<td><%=TransferList.get(i).getDepid() %></td>
<td><%=TransferList.get(i).getRoleid() %></td>
<td><a href="editTransfer?empname=<%=TransferList.get(i).getEmpname() %>&Admin=<%=admin %>&count=<%=TransferList.get(i).getCount() %>">Accept</a></td>
<td><a href="deleteTransfer?empname=<%=TransferList.get(i).getEmpname() %>&Admin=<%=admin %>">Decline</a></td>
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