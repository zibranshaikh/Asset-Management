<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p align="left">
<form action="./">
<input type="submit" value="Go To Main Page" />
</form>
</p>
<center>
<h1>${head}</h1>
<h1>${msg} Login</h1>
<pre>
<form action="./check" method="post" >
User Name <input type="text" name="uid" />
Password  <input type="password" name="pwd" />
        <input type="submit" value="login" />
</form>
</pre>
</center>
</body>
</html>