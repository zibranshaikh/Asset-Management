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
 <form action="./managerop" method="post">
<input type="hidden" value="${user}" name="userid" /> 
<input type="submit" value="Home" name="op" />
<input type="submit" value="Logout" name="op" />
</form>
</p1>
<pre>
${msg}
<form action="InsertManager" method="post">
Managerid     <input type="text" name="mid" />
AssetID       <input type="text" name="assetid" />
Assetname     <select name="assetname">
<option>laptop</option>
<option>Mobile</option>
<option>tablet</option>
<option>charger</option>
<option>tv</option>
<option>AC</option>
</select>
RequestID     <input type="text" name="requestid" />
Date          <input type="date" name="date" /> 
<input type="submit" value="save" /> <br/><br/>
<input type="reset"/></form></pre>
</body>

</html>