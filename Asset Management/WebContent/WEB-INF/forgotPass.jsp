<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password</title>
</head>
<body bgcolor=#4db8ff>
<center>
<img src="images/zappy-logo.png"></img>
<pre>
<%
String m=(String)request.getAttribute("msg");
if(m!=null)
	out.println(m);
%>
<h1 style="background-color:white">Enter your email so we can send password to it</h1>
<form action="SendPassController" method="post">
<h3>Email<input type="email" name="email" required="required" /></h3>
<input type="submit" value="send password" />
</form>
</pre>
 <footer class="container-fluid text-center">
  <p><h2 style="background-color:white">@ Copyright Zappy FoodShop Powered and Developed By Systango</h2></p>
</footer>

</center>
</body>
</html>