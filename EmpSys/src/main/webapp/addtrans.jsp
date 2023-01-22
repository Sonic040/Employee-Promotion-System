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
            <%=session.getAttribute("username")%> in Transfer page.
        </h1><br>

<h2> your department is :  <%=session.getAttribute("depid")%></h2>


<form action="editdept?name=<%=session.getAttribute("username")%>" method="post">
    Enter your new department :<input type="text" name="deptid"> <br>
    <br>
    <input type="submit" value="submit">
</form>






</body>
</html>