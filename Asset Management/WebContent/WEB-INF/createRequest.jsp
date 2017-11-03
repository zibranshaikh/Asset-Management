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
<%@page import="beans.Employee" %>
<form action="./insertRequest" method="post">
 <%
Employee cc=(Employee)request.getAttribute("E");

 if(cc.getDesignation().equalsIgnoreCase("Manager"))
     {
  %>
Employee ID        <input type="text" value="<%=(cc.getMid2())%>" name="mid2" readonly />
Support ID         <input type="text" value="<%=(cc.getSid())%>" name="sid" readonly />
<%
}
%>
     <% if(cc.getDesignation().equalsIgnoreCase("Employee"))
     {
  %>
Employee ID    <input type="text" value="<%=(cc.getEid1())%>" name="eid1" readonly />
Manager ID     <input type="text" value="<%=(cc.getMid1())%>" name="mid1" readonly />
              <input type="hidden" value="<%=(cc.getSid())%>" name="sid" readonly />
<%
}
%>
Asset Name     <select name="assetname" id="assets">
               <option>select</option>
               <option value="laptop">Laptop</option>
               <option value="mouse">Mouse</option>
               <option value="datacard">Data Card</option>
               <option value="headphone">Headphones</option>
               <option value="pendrive">Pen drive</option>
               </select>
Asset Id       <input type="text" id="assetid" name="assetid"/>
Designation    <input type="text" name="designation" value="<%=cc.getDesignation()%>" readonly>
               
               <input type="submit" value="Request">
</body>
</form>
</pre>
</html>