<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<h1 style="background-color:Tomato">Update Profile</h1>
<body>
<p1 align="right">
 <form action="./empop" method="post">
<input type="hidden" value="${user}" name="userid" /> 
<input type="submit" value="Home" name="op" />
<input type="submit" value="Logout" name="op" />
</form>
</p1>
<%@page import="java.util.ArrayList,beans.Employee" %>
<table border="3">
 <%
ArrayList<Employee> ar=(ArrayList)request.getAttribute("LIST");
for(Employee cc:ar)
{
	%>
<pre>
<form action="UpdateEmp" method="post">
 ID        <input type="text" value="<%=(cc.getEid())%>" name="eid" readonly />
 Name      <input type="text" value="<%=(cc.getName())%>" name="name" />
 Address   <input type="text" value="<%=(cc.getAddress())%>" name="address" />
 Email     <input type="email" value="<%=(cc.getEmail())%>" name="email" />
 Mobile    <input type="text" value="<%=(cc.getMobile())%>" name="mobile" />
 Password  <input type="password" value="<%=(cc.getPassword())%>" name="password" readonly />
 Designation <select value="<%=(cc.getDesignation())%>" name="designation" readonly />
                     <option>Developer</option>
                     <option>Manager</option>
                     <option>SupportTeam</option>
                     </select>
 <input type="submit" value="Update" />
  </form>
  <% 
}
%>
</pre>
  </table>
</body>
</html>