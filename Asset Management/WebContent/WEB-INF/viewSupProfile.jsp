<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>profile</title>
</head>
<center>
<body>
<p1 align="right">
 <form action="./supop" method="post">
<input type="hidden" value="${user}" name="eid" /> 
<input type="submit" value="Home" name="op" />
<input type="submit" value="Logout" name="op" />
</form>
</p1>
<h1>Your Profile</h1>
<%@page import="java.util.ArrayList,beans.Employee" %>

<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach items="${LIST}" var="e">
<h1>${msg}</h1>
<form action="./controller" method="post">
<h3><font color="blue">Eid        </font>:${e.eid2}</h3>
<h3><font color="blue">Name       </font>:${e.name}</h3>
<h3><font color="blue">Address    </font>:${e.address}</h3>
<h3><font color="blue">Mobile     </font>:${e.mobile}</h3>
<h3><font color="blue">Email      </font>:${e.email}</h3>
<h3><font color="blue">Designation</font>:${e.designation}</h3>
    
                <h1><input type="submit" value="update"></h1>
 

</c:forEach>
</form> 
</body>
</center>
</html>