<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p1 align="right">
 <form action="./managerop" method="post">
<input type="hidden" value="${user}" name="userid" /> 
<input type="submit" value="Home" name="op" />
<input type="submit" value="Logout" name="op" />
</form>
</p1>
${msg}
<%@page import="java.util.ArrayList,beans.Employee" %>
<% 
Employee a1=(Employee)request.getAttribute("LIST");
%>
<form action="Manageropreation" method="post">
password   <input type="text" value="${a1.password}" name="password" />
<input type="hidden" value="${user}" name="mid" />
<input type="submit" value="Change Password" />
</form>
</body>
</html>