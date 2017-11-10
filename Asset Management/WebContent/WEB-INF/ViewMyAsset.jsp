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
<h1>My Assets</h1>
<table border="3">
<tr>
  <th>AssetID</th>
  <th>AssetName</th>
  <th>EmployeeId</th>
  <th>ManagerId</th>
  <th>Status</th>
  </tr>
<%@page import="java.util.ArrayList,beans.AllotedAsset" %>
<%
ArrayList<AllotedAsset> ar=(ArrayList<AllotedAsset>)request.getAttribute("LIST");
for(AllotedAsset cc:ar)
{
%>
<tr> 
    <td><%=cc.getAssetid()%></td>
    <td><%=cc.getAssetname()%></td>
    <td><%=cc.getEid1()%></td>
    <td><%=cc.getMid1()%></td>
    <%  int st=0;
      String status="";
      st=cc.getStatus(); 
      if(st==1)
      {
    	  status="Allocated";
      }
       %>
    <td><%=status%></td>  
    </form>
    </tr>
    <%
}
    %>

</body>
</table>
</html>