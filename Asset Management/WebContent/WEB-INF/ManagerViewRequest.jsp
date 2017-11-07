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
<tr><th>Managerid</th><th>Assetid</th><th>Assetname</th><th>Requestid</th><th>Date</th><th>Status</th></tr>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach items= "${LIST}" var ="a1">
<tr>
<td>${a1.mid2}</td>
<td>${a1.assetid}</td>
<td>${a1.assetname}</td>
<td>${a1.requestid}</td>
<td>${a1.requestdate}</td>
<td>${a1.status}</td>

</tr>

</c:forEach>
</table>
</body>

</html>