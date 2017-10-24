<p1 align="right">
 <form action="./adminop" method="post">
<input type="hidden" value="${user}" name="userid" /> 
<input type="submit" value="Home" name="op" />
<input type="submit" value="Logout" name="op" />
</form>
</p1>
<pre>
<center>
<h1>Employee Details</h1>
<font color="green">
<h1>${msg}</h1>
<h1>${msg1}</h1>
</font>
<table border="1">
<tr><th>EID</th><th>Name</th><th>Address</th><th>Mobile</th><th>MailID</th><th>Password</th><th>Designation</th><th>Support Id</th><th></th><th>Date of Joining</th><th>Status</th><th>Action</th></tr>

<%@page import="java.util.ArrayList,beans.Employee" %>
<%
ArrayList<Employee> ar=(ArrayList<Employee>)request.getAttribute("LIST");
for(Employee cc:ar)
{
	%>
<tr>
     <form action="./empAD" method="post">
    <%if(cc.getDesignation().equalsIgnoreCase("Manager"))
    	{ 
    	%>
    	<td><%=(cc.getMid())%></td>
    <%
    } 
    else
    {
    %>
    <td><%=(cc.getEid())%></td>
    <%
    }
    %>
    <input type="hidden" value="<%=cc.getEid() %>" name="eid" />
    <td><%=cc.getName()%></td>
    <td><%=cc.getAddress()%></td>
    <td><%=cc.getEmail()%></td>
    <td><%=cc.getMobile()%></td>
    <td><%=cc.getPassword()%></td>
    <td><%=cc.getDesignation()%></td>
    <%
    if(cc.getDesignation().equalsIgnoreCase("Manager"))
    	{ 
    	%>
    	<td><%=(cc.getSid())%></td>
    <%
    } 
    else
    {
    %>
    <td>Not Available<td>
    <%
    } 
    %>
    <td><%=cc.getDateofjoin()%></td>
    
    <%  int st=0;
      String status;
      st=cc.getStatus(); 
      if(st==1)
      {
    	  status="Activated";
      }
      else
      {
    	  status="Deactivated";
      }
      %>
    <td><%=status%></td>  
    <td><input type="submit" value="Activate" name="op" />
        <input type="submit" value="Deactivate" name="op" />
        <input type="submit" value="Update" name="op">
    </td>
    </form>
</tr>
<% 
}
%>

</table>
<!--  //<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach items="${LIST}" var="e">
<tr>  
   <td>${e.eid}</td>
   <td>${e.name}</td>
   <td>${e.address}</td>
   <td>${e.email}</td>
   <td>${e.mobile}</td>
</tr>
</c:forEach>
-->
</center>
</pre>