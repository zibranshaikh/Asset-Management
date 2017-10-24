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
 <form action="./adminop" method="post">
<input type="hidden" value="${user}" name="userid" /> 
<input type="submit" value="Home" name="op" />
<input type="submit" value="Logout" name="op" />
</form>
</p1>
<center>
<pre>
<%@page import="dao.EmpDao"%>
<h1>Change Password ${user}</h1>
<form action="./AdpwdChange" method="post">
Current password <input type="text" name="cpwd" required />
New password     <input type="text" name="npwd" required />
                 <input type="hidden" value="${user}" name="userid" />
Confirm password <input type="text" name="npwd1" required />
                 <input type="submit" value="Change" />
</form>
</pre>
</center>
</body>
</html>