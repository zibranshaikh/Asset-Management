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
 <form action="./supop" method="post">
<input type="hidden" value="${user}" name="eid" /> 
<input type="submit" value="Home" name="op" />
<input type="submit" value="Logout" name="op" />
</form>
</p1>
<center>
<h1>Welcome ${user}</h1>
<h1>All Reports</h1>
<table border="5">
<%@page import="java.util.ArrayList,beans.Request" %>
<tr>
<th><h1>Request Id</h1></th>
<th><h1>Employee Id</h1></th>
<th><h1>MID/SID</h1></th>
<th><h1>Designation</h1></th>
<th><h1>Asset Id</h1></th>
<th><h1>Asset Name</h1></th>
<th><h1>Request date</h1></th>
<th><h1>Request Status</h1></th>
</tr>
<%
ArrayList<Request> ar=(ArrayList<Request>)request.getAttribute("LIST");
for(Request cc:ar)
{

%>
<tr>
<td><%=(cc.getRequestid())%></td>
<%
  if(cc.getDesignation().equalsIgnoreCase("Manager"))
     {
  %>
 <td>       <input type="text" value="<%=(cc.getMid2())%>" name="mid2" readonly /></td>
 <td>       <input type="text" value="<%=(cc.getSid())%>" name="sid" readonly /></td>
<%
}
%>
     <% if(cc.getDesignation().equalsIgnoreCase("Employee"))
     {
  %>
 <td>       <input type="text" value="<%=(cc.getEid1())%>" name="eid1" readonly /></td>
 <td>       <input type="text" value="<%=(cc.getMid1())%>" name="mid1" readonly /></td>
 <%
}
%>

<td><%=(cc.getDesignation())%></td>
<td><%=(cc.getAssetid())%></td>
<td><%=(cc.getAssetname())%></td>
<td><%=(cc.getRequestdate())%></td>

<%  int st=0;
      String status="";
      st=cc.getStatus(); 
      if(st==4)
      {
    	  status="Rejected by Support";
      }

      else if(st==0)
      {
    	  status="Pending with manager";
      }
      else if(st==1)
      {
    	  status="Approved by manager";
      }
      
      else if(st==2)
      {
    	  status="Reject by manager";
      }
      
      else if(st==3)
      {
    	  status="Approved by Support";
      }
      %>
    <td><%=status%></td>  
</tr>
<% 
}
%>
</table>
</center>
</body>
</html>