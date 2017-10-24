<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<center>
<p1 align="right">
 <form action="./empop" method="post">
<input type="hidden" value="${user}" name="userid" /> 
<input type="submit" value="Home" name="op" />
<input type="submit" value="Logout" name="op" />
</form>
</p1>
<h3>${change}</h3>
<h3>${chng}</h3>
<h1>Change Password</h1>
<body>
<form action="changePassword" method="post">
<table>
<tr><td>Current Password</td><td><input type="password" name="current"></td></tr>
<tr><td>New Password</td><td><input type="password" name="new"></td></tr>
<tr><td>Confirm Password</td><td><input type="password" name="confirm"></td></tr>
<tr><td><input type="submit" value="ChangePassword"></td></tr>
</table>

</form>
</center>

</body>
</html>