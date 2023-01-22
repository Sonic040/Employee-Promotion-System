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
<h1>Promotion List</h1>
<%! List<Promotion> PromotionList; %>
<table cellpadding="5" cellspacing="5" border="1">
<tr>
<th>name</th>
<th>count</th>
<th>rank</th>
<th>evalution</th>
<th>role</th>
</tr>
<%
String admin=request.getParameter("Admin");
PromotionList = (List<Promotion>)request.getAttribute("PromotionList");
if(PromotionList != null && !PromotionList.isEmpty()) {
for(int i=0;i<PromotionList.size();i++) {		
%>
<tr>
<td><%=PromotionList.get(i).getEmpname() %></td>
<td><%=PromotionList.get(i).getCount() %></td>
<td><%=PromotionList.get(i).getRank() %></td>
<td><%=PromotionList.get(i).getEvalution() %></td>
<td><%=PromotionList.get(i).getRoleid() %></td>
<td><a href="editPromotion?empname=<%=PromotionList.get(i).getEmpname() %>&Admin=<%=admin %>&count=<%=PromotionList.get(i).getCount() %>">Accept</a></td>
<td><a href="deletePromotion?empname=<%=PromotionList.get(i).getEmpname() %>&Admin=<%=admin %>">Decline</a></td>
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