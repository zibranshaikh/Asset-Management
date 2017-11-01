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

<h1>${head}</h1>
<table border="1">
<tr><th>EID</th><th>Name</th><th>Address</th><th>Mobile</th><th>Email</th><th>Password</th><th>Designation</th><th>ManagerID</th><th>SID</th><th>Date-of-join</th><th>Status</th></tr>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach items= "${LIST}" var ="a1">

<tr>
<form action="Mupdatepassword" method="post">
<td>${a1.mid}</td>
<td>${a1.name}</td>
<td>${a1.address}</td>
<td>${a1.mobile}</td>
<td>${a1.email}</td>
<td>${a1.password}
<input type="submit" value="changePassword" name="opreation"/></td>
<td>${a1.designation}</td>
<td>${a1.mid}</td>
<td>${a1.sid}</td>
<td>${a1.dateofjoin}</td>
<td>${a1.status}</td>
<td>
<input type="hidden" name="managerid" value="${a1.mid}"/></td>
</form>
</tr>
</c:forEach>
</table>

</body>
</html>