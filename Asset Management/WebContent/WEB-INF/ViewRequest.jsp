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
 <form action="./empop" method="post">
<input type="hidden" value="${user}" name="userid" /> 
<input type="submit" value="Home" name="op" />
<input type="submit" value="Logout" name="op" />
</form>
</p1>
<h1>Requested Assets</h1>
<table border="3">
<tr>
  <th>RequestID</th>
  <th>RequestDate</th>
  <th>AssetID</th>
  <th>AssetName</th>
  <th>Designation</th>
  <th>ManagerId</th>
  <th>SupportId</th>
  <th>Status</th>
  <th>Cancel Request</th>
  </tr>
<%@page import="java.util.ArrayList,beans.Request" %>
<%
ArrayList<Request> ar=(ArrayList<Request>)request.getAttribute("LIST");
for(Request cc:ar)
{
%>
<tr> 
<form action="./CancelRequest" method="post">
    <td><%=cc.getRequestid()%></td>
    <td><%=cc.getRequestdate()%></td>
    <td><%=cc.getAssetid()%></td>
    <td><%=cc.getAssetname()%></td>
    <td><%=cc.getDesignation()%></td>
    <td><%=cc.getMid1()%></td>
    <td><%=cc.getSid()%></td>
    <%  int st=0;
      String status="";
      st=cc.getStatus(); 
      if(st==0)
      {
    	  status="Pending With Manager";
      }
      else if(st==1)
      {
    	  status="Approved By Manager";
      }
      else if(st==2)
      {
    	  status="Cancelled By Manager";
      }
      else if(st==3)
      {
    	  status="Approved By Support";
      }
      else if(st==4)
      {
    	  status="Cancelled By Support";
      }
      %>
    <td><%=status%></td>  
    <td><input type="submit" value="cancel request" /></td>
    </form>
    </tr>
    <%
}
    %>

</body>
</table>
</html>