<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Product</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
			
			
			$.ajax({
				
				url:'./fetchMid',
				type:'post',
				success:function(result){
				//	alert(eid);
					$("#mid").append(result);
				}
				
			});
			$.ajax({
				
				url:'./fetchSid',
				type:'post',
				success:function(result){
				//	alert(eid);
					$("#sid").append(result);
				}
				
			});
			
			
		
	});

</script>

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
 <form action="./UpdateAEmp" method="post">
 <%
Employee cc=(Employee)request.getAttribute("E");
 
   if(cc.getDesignation().equalsIgnoreCase("Manager"))
     {
  %>
 <tr><td>Employee ID        <input type="text" value="<%=(cc.getMid2())%>" name="mid2" readonly /></td></tr>
 <tr><td>Support ID         <input type="text" value="<%=(cc.getSid())%>" name="sid" required="required" /></td></tr>
<%
}
%>
     <% if(cc.getDesignation().equalsIgnoreCase("Employee"))
     {
  %>
 <tr><td>Employee ID</td><td><input type="text" value="<%=(cc.getEid1())%>" name="eid1" readonly /></td></tr>
 <tr><td>Manager ID</td><td><select name="mid1" id="mid" /></select>
                     </td></tr> 
<%
}
%>
     <% if(cc.getDesignation().equalsIgnoreCase("Support Team"))
     {
  %>
 <tr><td> Employee ID        <input type="text" value="<%=(cc.getEid2())%>" name="eid2" readonly /></td></tr>
<%
}
%>

 <tr><td>Name      <input type="text" value="<%=(cc.getName())%>" name="name" readonly /></td></tr>
 <tr><td>Address   <input type="text" value="<%=(cc.getAddress())%>" name="address" readonly /></td></tr>
 <tr><td>Email     <input type="email" value="<%=(cc.getEmail())%>" name="email" readonly /></td></tr>
 <tr><td>Mobile    <input type="text" value="<%=(cc.getMobile())%>" name="mobile" readonly /></td></tr>
 <tr><td>Designation <select name="designation" >
                       <option><%=(cc.getDesignation())%></option>
                       <option>Manager</option>
                       <option>Employee</option>
                       <option>Support Team</option>       
                     </select></td></tr>
 
  <tr><td><input type="submit" value="Update" onclick="return confirm('Are you sure')"/></td></tr>
  </form>
</body>
</html>