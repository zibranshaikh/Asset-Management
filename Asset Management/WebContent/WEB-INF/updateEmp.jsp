<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Product</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
			
			
			$.ajax({
				
				url:'./fetchMid',
				type:'post',
				success:function(result){
				//	alert(eid);
					$("#mid").append(result);
				}
				
			});
			$.ajax({
				
				url:'./fetchSid',
				type:'post',
				success:function(result){
				//	alert(eid);
					$("#sid").append(result);
				}
				
			});
			
			
		
	});

</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	  $("#Manager").hide();
	  $("#Support").hide();
	  $("#Employee").hide();
	  $("#SupportId").hide();
	  $("#ManagerId").hide();

	  
	  $("#empDes").change(function () {
         var data=$("#empDes").val();
    	 if(data.match('Employee'))   
    	 {
    		 $("#Employee").show();
	     	 $("#Manager").show();
	     	 $("#Support").hide();
	     	$("#SupportId").hide();
  		  $("#ManagerId").hide();
  		  	
    	 }
	     	 else
    	 {
    		 $("#Support").hide();
    	  	 $("#SupportId").hide();
    		  $("#ManagerId").hide();
    	 }
	  });
    
  	 
      $("#empDes").change(function () {
           var data=$("#empDes").val();
      	 if(data.match('Support Team'))   
      	 { $("#Support").show();
      	   $("#Employee").hide();
      	   $("#Manager").hide();
           $("#SupportId").hide();
     	  $("#ManagerId").hide();

      	 }
      	 else
      		 $("Support").hide();
           	 });
    
    	    $("#empDes").change(function () {
    	         var data=$("#empDes").val();
    	    	 if(data.match('Manager'))   
    	    	 {      
    	           	  $("#ManagerId").show()
    	           	  $("#Employee").hide();
    	            	 $("Support").hide();
    	            	 $("#SupportId").show();
         	           	  $("#Manager").hide();

	    	 }
    	    	 else
    	    	 {
    	    		 $("#ManagerId").hide();
    	    	 	 $("#SupportId").hide();
    	    	 }
    	    });
     });
</script>
</head>
<body> 
<p1 align="right">
 <form action="./adminop" method="post">
<input type="hidden" value="${user}" name="userid" /> 
<input type="submit" value="Home" name="op" />
<input type="submit" value="Logout" name="op" />
</form>
</p1>
<h1>${head}</h1>
<h1>Welcome ${user}</h1>

 <table border="3">
 
<%@page import="beans.Employee" %>
 <form action="./UpdateAEmp" method="post">
 <%
Employee cc=(Employee)request.getAttribute("E");
 
   if(cc.getDesignation().equalsIgnoreCase("Manager"))
     {
  %>
 <tr><td>Employee ID</td><td><%=(cc.getMid2())%></td></tr>
<tr><td>Support ID</td><td><select name="sid" id="sid" />
                     <option><%=(cc.getSid())%></option>
                     </select>
                     </td></tr>
 <%
}
%>
     <% if(cc.getDesignation().equalsIgnoreCase("Employee"))
     {
  %>
 <tr><td>Employee ID</td><td><%=(cc.getEid1())%></td></tr>
 <tr><td>Manager ID</td><td><select name="mid1" id="mid" />
                     <option><%=(cc.getMid1())%></option>
                     </select></td></tr> 
<%
}
%>
     <% if(cc.getDesignation().equalsIgnoreCase("Support Team"))
     {
  %>
 <tr><td> Employee ID</td><td><%=(cc.getEid2())%></td></tr>
<%
}
%>

<tr><td>Name</td><td><%=(cc.getName())%></td></tr>
<tr><td>Address</td><td><%=(cc.getAddress())%></td></tr>
<tr><td>Email</td><td><%=(cc.getEmail())%></td></tr>
<tr><td>Mobile</td><td><%=(cc.getMobile())%></td></tr>
<tr><td>Designation</td><td> <select  id="empDes" name="designation"  required="required">
                       <option><%=(cc.getDesignation())%></option>
                       <option>Manager</option>
                       <option>Employee</option>
                       <option>Support Team</option>       
                     </select></td></tr>

                      <tr id="Employee"><td>
<b>EMPLOYEE ID</b>          </td><td><input type="text" name="eid1" id="eid" placeholder="E101" value="E101" maxlength="15" required="required" />
                     </td></tr>
                     <tr id="Manager"><td>
<b>Manager ID</b>           </td><td><select name="mid1" id="mid" />
                     </select>
                     </td></tr> 
 
                     <tr id="ManagerId"><td>
<b>Manager ID</b>           </td><td><input type="text" name="mid2" id="mid" value="<%=(cc.getMid2())%>" placeholder="M101" maxlength="15" required="required" />
                     </td></tr>
 <%if(!cc.getDesignation().equals("Support Team"))
 {%>                     
                     <tr id="Support"><td>
<b>EMPLOYEE ID</b>          </td><td><input type="text" name="eid2" id="eid" value="S101" placeholder="S101" maxlength="15" required="required" />
  <%
  }
  %>                   </td></tr>
                     <tr id="SupportId"><td>
<b>Support ID</b>          </td><td><select name="sid" id="sid" />
                     </select>
                     </td></tr>
 
<tr><td><input type="submit" value="Update" onclick="return confirm('Are you sure')"/></td></tr>
</form>
</body>
</html>