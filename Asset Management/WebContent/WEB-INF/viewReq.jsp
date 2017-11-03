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
<pre>
<h1>Welcome ${user}</h1>
<h1>${msg}</h1>
<h1>${msg1}</h1>
<h1>${msg2}</h1>
<h1>Asset Requests</h1>
<table border="5">
<%@page import="java.util.ArrayList,beans.Request" %>
<tr><th>Employee ID </th><th>Mid/Sid<th>Designation</th><th>Asset Id</th><th>Asset Name</th><th>Request date</th><th>Request Status</th><th>Action</th></tr>
<%
ArrayList<Request> ar=(ArrayList<Request>)request.getAttribute("LIST");
for(Request cc:ar)
{
%>
<form action="./approveReq" method="post">
<tr>
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
      if(st==1)
      {
    	  status="New Request";
      }
      else if(st==3)
      {
    	  status="Approved";
      }
      %>
    <td><%=status%></td>  
<td><input type="submit" value="Approve" name="op" /><input type="submit" value="Reject" name="op" />
</td>
</tr>
</form>
</tr>
<% 
}
%>
</table>
</pre>
</center>
</body>
</html>