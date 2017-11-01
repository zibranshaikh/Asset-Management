<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<center>
<p1 align="right">
 <form action="./empop" method="post">
<input type="hidden" value="${user}" name="userid" />
<input type="submit" value="Logout" name="op" />
</form>
</p1>
<h1>Welcome Employee ${user}</h1>
<body>
<a href="AssetRequest">Create Asset Request</a></br></br>
<a href="ViewAsset">My Assets</a></br></br>
<a href="ViewRequest">View My Request</a></br></br>
<a href="AssetTransfer">Transfer Asset</a></br></br>
<a href="ViewProfile">Profile</a></br></br>
<a href="changeEPass">Change Password</a></br></br>

</body>
</center>
</html>