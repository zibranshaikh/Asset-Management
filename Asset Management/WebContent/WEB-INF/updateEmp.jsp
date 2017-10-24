<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Product</title>
</head>
<body> 
<p1 align="right">
 <form action="./adminop" method="post">
<input type="hidden" value="${user}" name="userid" /> 
<input type="submit" value="Home" name="op" />
<input type="submit" value="Logout" name="op" />
</form>
</p1>
<h1>${head}</h1>
<h1>Welcome ${user}</h1>

 <table border="3">
 
<%@page import="beans.Employee" %>
 <form action="./UpdateEmp" method="post">
 <%
Employee cc=(Employee)request.getAttribute("E");
%>
                   <input type="hidden" value="<%=(cc.getEid())%>" name="eid1" />
 <tr><td>ID        <input type="text" value="<%=(cc.getEid())%>" name="eid" /></td></tr>
 <tr><td>Name      <input type="text" value="<%=(cc.getName())%>" name="name" /></td></tr>
 <tr><td>Address   <input type="text" value="<%=(cc.getAddress())%>" name="address" /></td></tr>
 <tr><td>Email     <input type="email" value="<%=(cc.getEmail())%>" name="email" /></td></tr>
 <tr><td>Mobile    <input type="text" value="<%=(cc.getMobile())%>" name="mobile" /></td></tr>
 <tr><td>Password  <input type="password" value="<%=(cc.getPassword())%>" name="password" /></td></tr>
 <tr><td>Designation <select value="<%=(cc.getDesignation())%>" name="designation">
                     <option>Manager</option>
                     <option>Employee</option>
                     <option>SupportTeam</option>
                     </select></td></tr>
 
  <tr><td><input type="submit" value="Update" /></td></tr>
  </form>
</body>
</html>