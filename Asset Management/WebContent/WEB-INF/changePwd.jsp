<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" >
 function checkCpwd()
 {

	 var cpwd=document.getElementById("cpwd").value;
	 
	    
	   
 }
</script>
<p1 align="right">
 <form action="./supop" method="post">
<input type="hidden" value="${user}" name="eid" /> 
<input type="submit" value="Home" name="op" />
<input type="submit" value="Logout" name="op" />
</form>
</p1>
<center>
<pre>
<h1>Change Password ${user}</h1>
<form action="./pwdChange" method="post">
Current password <input type="text" name="cpwd" id="cpwd" onblur="checkCpwd()" required="required" />
<%@page import="dao.EmpDao"%>
<%String cpwd=null;%>
<%EmpDao ed=new EmpDao();
         //ed.checkCpwd();
   %>
New password     <input type="text" name="npwd" required="required" />
<input type="hidden" value="${user}" name="eid" />
Confirm password <input type="text" name="npwd1" required="required" />
                 <input type="submit" value="Change" />
</form>
</pre>
</center>
</body>
</html>