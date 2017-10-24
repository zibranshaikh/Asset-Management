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
<tr><th>AssetID</th><th>AssetName</th><th>RequestDate</th><th>Designation</th><th>Status</th></tr>
<%@page import="java.util.ArrayList,beans.Asset" %>
<%
ArrayList<Asset> ar=(ArrayList)request.getAttribute("LIST");
for(Asset cc:ar)
{
%>
<tr> 
    <td><%=cc.getAssetid()%></td>
    <td><%=cc.getAssetname()%></td>
    <td><%=cc.getRequestdate()%></td>
    <td><%=cc.getDesignation()%></td>
    <td><%=cc.getStatus()%></td>
    
    </tr>
    <%
}
    %>

</body>
</table>
</html>