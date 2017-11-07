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
<center>
<pre>
<h1>${head}</h1>

<h1>My Employee</h1>
<table border="1">
<tr><th>Employee Id</th><th>Name</th><th>EmailID</th><th>Password</th><th>ManagerID</th><th>Designation</th><th>EmpidID</th><th>Mobile</th><th>SupportId</th><th>Date-of-join</th><th>Status</th></tr>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach items= "${LIST}" var ="a1">
<tr>

<td>${a1.eid1}</td>
<td>${a1.name}</td>
<td>${a1.address}</td>
<td>${a1.mobile}</td>
<td>${a1.email}</td>
<td>${a1.password}</td>
<td>${a1.designation}</td>
<td>${a1.mid1}</td>
<td>${a1.sid}</td>
<td>${a1.dateofjoin}</td>
<td>${a1.status}</td>

<td>
<input type="hidden" value="${user}" name="mid" /></td>
</tr>

</c:forEach>
</table>
</pre>
</center>
</body>
</html>