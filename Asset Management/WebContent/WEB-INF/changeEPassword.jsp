<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
  function validate()
  {
	  var npass1=document.getElementById("npass1").value;
	  var npass2=document.getElementById("npass2").value;
	  if(npass1!=npass2)
		  {
		  alert("New Password and Confirm Password not match ");
		  return false;
		  }
  return true;
  }
</script>

</head>
<center>
<p1 align="right">
 <form action="./empop" method="post">
<input type="hidden" value="${user}" name="userid" /> 
<input type="submit" value="Home" name="op" />
<input type="submit" value="Logout" name="op" />
</form>
</p1>
<h3>${change}</h3>
<h3>${chng}</h3>
<h1>Change Password</h1>
<body>
<form action="changeEPassword" method="post">
<table>
<input type="hidden" value="${user}" name="eid" />
Current Password  <input type="password" name="cpass" required="required" placeholder="123@zibran" onblur="pwdCheck()"/>
New Password      <input type="password" name="npass1" id="npass1" required="required"  placeholder="123@zibran" />
Confirm Password  <input type="password" name="npass2" id="npass2" required="required" placeholder="123@zibran" onblur="return validate()"/>
                          
             <input type="submit" value="ChangePassword" /><!-- button to submit the field and go to adeditcontroller -->
</table>

</form>
</center>

</body>
</html>