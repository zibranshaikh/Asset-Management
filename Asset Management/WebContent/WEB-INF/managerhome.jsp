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
<input type="submit" value="Logout" name="op" />
</form>
</p1>
<center>
<h1>Manager Home</h1>
<h1>Welcome ${user}</h1></center>
<a href ="./viewa">profile</a>
<br/><br/>
<a href ="./mpendingrequest">Pending request</a>
<br/><br/>
<a href ="./Managercreate">create request</a>
<br/><br/>
<a href ="./Mviewrequest">view my request</a>
<br/><br/>
<a href ="./managerasset">My Asset</a>
<br/><br/>
<a href ="./view">Asset Transfer</a>
<br/><br/>
<a href ="./viewMallemployee">My employees</a>
</body>

</html>