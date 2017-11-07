<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>profile</title>
</head>
<center>
<body>
<p1 align="right">
 <form action="./empop" method="post">
<input type="hidden" value="${user}" name="userid" /> 
<input type="submit" value="Home" name="op" />
<input type="submit" value="Logout" name="op" />
</form>
</p1>
<h1>Your Profile</h1>
<table border="3">
<tr><th>EId</th><th>Name</th><th>Address</th><th>Mobile</th><th>Email</th><th>Password</th><th>Designation</th><th>Action</th></tr>
<%@page import="java.util.ArrayList,beans.Employee" %>

<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach items="${LIST}" var="e">
<h1>${msg}</h1>
<tr>
<form action="./controller" method="post">
    <td>${e.eid1}</td>
    <td>${e.name}</td>
    <td>${e.address}</td>
    <td>${e.mobile}</td>
    <td>${e.email}</td>
    <td>${e.password}</td>
    <td>${e.designation}</td>
    <td><input type="submit" value="update"></td>
 
</tr>

</c:forEach>

</form> 

</table>


</body>
</center>
</html>