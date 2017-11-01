<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
<p1 align="right">
 <form action="./supop" method="post">
<input type="hidden" value="${user}" name="eid" /> 
<input type="submit" value="Home" name="op" />
<input type="submit" value="Logout" name="op" />
</form>
</p1>
<center>
<pre>
<h1>${msg}</h1>
<h2>Change Password</h2>
<form action="./spwdChange" method="post">
<input type="hidden" value="${user}" name="eid" />
Current Password  <input type="password" name="cpass" required="required" placeholder="123@zibran" onblur="pwdCheck()"/>
New Password      <input type="password" name="npass1" id="npass1" required="required"  placeholder="123@zibran" />
Confirm Password  <input type="password" name="npass2" id="npass2" required="required" placeholder="123@zibran" onblur="return validate()"/>
                          
             <input type="submit" value="Change Password" /><!-- button to submit the field and go to adeditcontroller -->
</form>
</pre>
</center>
</body>
</html>