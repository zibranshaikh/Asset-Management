<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Asset Request</title>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$("#assetid").hide();
		$("#assets").change(function(){
			$("#assetid").show();
			var data ="assetname="+$("#assets").val();
			
			$.ajax({
				//FetchData.jsp?ename=amit
				url:'FetchData',
				data:data,
				type:'get',
				success:function(result){
					alert(result);
					$("#assetid").val(result);
				}
				
			});
			
		});
		
	});

</script>
<p1 align="right">
 <form action="./empop" method="post">
<input type="hidden" value="${user}" name="userid" /> 
<input type="submit" value="Home" name="op" />
<input type="submit" value="Logout" name="op" />
</form>
</p1>
<h3>${msg}</h3>
<h1>Asset Request</h1>
<body>
<pre>
<form action="./insertRequest" method="post">
EId        <input type="text" value="<%=session.getAttribute("user")%>" name="eid">
MID        <input type="text" value="<%=session.getAttribute("mid")%>" name="mid">
Asset Name<select name="assetname" id="assets">
          <option value="laptop">Laptop</option>
          <option value="mouse">Mouse</option>
          <option value="datacard">Data Card</option>
          <option value="headphone">Headphones</option>
          <option value="pendrive">Pen drive</option>
          </select>
Date      <input type="date" name="requestdate"/>
Asset Id   <input type="text" id="assetid" name="assetid"/>
Designation<select name="designation">
           <option>Manager</option>
           <option>Developer</option>
           <option>SupportTeam</option>
           </select>
          <input type="submit" value="Request">
</body>
</form>
</pre>
</html>