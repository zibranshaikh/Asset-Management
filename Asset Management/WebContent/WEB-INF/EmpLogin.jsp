<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p align="Left">
<form action="./">
<input type="submit" value="Go To Main Page" />
</form>
</p>
<center>
<pre>
<h1>${msg} Login</h1>
<form action="./empcheck" method="post">
User Name <input type="text" name="eid" />
Password  <input type="password" name="pwd" />
        <input type="submit" value="login" />
</form>
</pre>
</center>
</body>
</html>