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

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

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
</head>
</html>
<center>
<font color="green">
<%
String m=(String)request.getAttribute("msg");
if(m!=null)
	out.println(m);
%>
</font>
</center>		
<p1 align="right">
 <form action="./adminop" method="post">
<input type="hidden" value="${user}" name="userid" /> 
<input type="submit" value="Home" name="op" />
<input type="submit" value="Logout" name="op" />
</form>
</p1>
<center>
<pre>
<h1>${head}</h1>
<h1>Create Employee</h1>
<table>
 <form action="./insertEmp" method="post">
 <tr><td>Name        <input type="text" name="name" required="required" /></td></tr>
 <tr><td>Address     <input type="text" name="address" required="required" /></td></tr>
 <tr><td>Email       <input type="email" name="email" required="required" /></td></tr>
 <tr><td>Mobile      <input type="text" name="mobile" required="required" /></td></tr>
 <tr><td>Password    <input type="password" name="password" required="required" /></td></tr>
 <tr><td>Designation    <select  id="empDes" name="designation"  required="required" >
                    <option>Select</option>
                    <option value="Manager">Manager</option>
                    <option value="Employee">Employee</option>
                    <option value="Support Team">Support Team</option>
                    </select></td></tr>
                    
<tr id="Employee"><td>
EMPLOYEE ID  <input type="text" name="eid1" id="eid" placeholder="E101" value="0" maxlength="15" required="required" />
</td></tr>
<tr id="Manager"><td>
Manager ID   <select name="mid1" id="mid" />
                  </select>
</td></tr> 
<tr id="ManagerId"><td>
Manager ID  <input type="text" name="mid2" id="mid" value="0" placeholder="M101" maxlength="15" required="required" />
</td></tr>
<tr id="Support"><td>
EMPLOYEE ID   <input type="text" name="eid2" id="eid" value="0" placeholder="S101" maxlength="15" required="required" />
</td></tr>
<tr id="SupportId"><td>
Support ID <select name="sid" id="sid" />
                  </select>
</td></tr>

<tr><td>Date Of Joining<input type="date" name="dateofjoin" required="required" /></td></tr>

<tr><td><input type="submit" value="create" /></td></tr>
</form>
</table>
 </pre>
 </center>
  
  