<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
					$("#assetid").val(result);
				}
				
			});
			
		});
		
	});

</script>
<script type="text/javascript">
  function validate()
  {
	  var empDes=document.getElementById("assets").value;
	  if(empDes.match("select"))
		  {
		  alert("Please Select Asset");
		  return false;
		  }
  return true;
  }
</script>
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
<%String mid=(String)session.getAttribute("user");%>
${msg}
<form action="InsertManager" method="post">
Managerid      <input type="text" value="<%=mid%>"name="mid2" readonly />
Assetname      <select name="assetname" id="assets" onblur="return validate()">
               <option>select</option>
               <option value="laptop">Laptop</option>
               <option value="mouse">Mouse</option>
               <option value="Data card">Data Card</option>
               <option value="Headphones">Headphones</option>
               <option value="Pen Drive">Pen drive</option>
               </select>
Asset Id       <input type="text" id="assetid" name="assetid" readonly/>
<input type="submit" value="save" /> <br/><br/>
<input type="reset"/></form></pre>
</body>

</html>