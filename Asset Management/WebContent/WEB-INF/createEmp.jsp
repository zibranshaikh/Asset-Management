<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">
body{
    
    background-image:url('https://imgur.com/gRp0RGm.jpg');
    background-size:cover;
    height 30%;
}
.navbar, .dropdown-menu{
background:#09ba32;
border: none;

}

.nav>li>a, .dropdown-menu>li>a:focus, .dropdown-menu>li>a:hover, .dropdown-menu>li>a, .dropdown-menu>li{
  border-bottom: 3px solid transparent;
}
.nav>li>a:focus, .nav>li>a:hover,.nav .open>a, .nav .open>a:focus, .nav .open>a:hover, .dropdown-menu>li>a:focus, .dropdown-menu>li>a:hover{
  border-bottom: 3px solid transparent;
  background: rgba(154, 154, 154, 0.27);
}
.navbar a, .dropdown-menu>li>a, .dropdown-menu>li>a:focus, .dropdown-menu>li>a:hover, .navbar-toggle{
 color: #fff;
}
.dropdown-menu{
      -webkit-box-shadow: none;
    box-shadow:none;
}

.nav li:hover:nth-child(8n+1), .nav li.active:nth-child(8n+1){
  border-bottom: #b6f423 4px solid;
}
.nav li:hover:nth-child(8n+2), .nav li.active:nth-child(8n+2){
  border-bottom: #82e2ea 4px solid;
}
.nav li:hover:nth-child(8n+3), .nav li.active:nth-child(8n+3){
  border-bottom: #f8b42c 4px solid;
}
.nav li:hover:nth-child(8n+4), .nav li.active:nth-child(8n+4){
  border-bottom: #fd594a 4px solid;
}
.nav li:hover:nth-child(8n+5), .nav li.active:nth-child(8n+5){
  border-bottom: #e8479d 4px solid;
}
.nav li:hover:nth-child(8n+6), .nav li.active:nth-child(8n+6){
  border-bottom: #a12eeb 4px solid;
}
.nav li:hover:nth-child(8n+7), .nav li.active:nth-child(8n+7){
  border-bottom: #4785d9 4px solid;
}
.nav li:hover:nth-child(8n+8), .nav li.active:nth-child(8n+8){
  border-bottom: #2aed9a 4px solid;
}

.navbar-toggle .icon-bar{
    color: #fff;
    background: #000000;
}
.box{
     width: 100%;
     margin: auto;
     padding :10px;
     max-width:400px;
     border-radius:2px;
     box-shadow: $shadow2;
     background-color: rgba(0,0,0,0.2);

}

/* Credit to bootsnipp.com for the css for the color graph 
 ESTO SOLO ES PARA EL FORMULARIO DE LOGIN
*/
.colorgraph {
  height: 5px;
  border-top: 0;
  background: #c4e17f;
  border-radius: 5px;
  background-image: -webkit-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: -moz-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: -o-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: linear-gradient(to right, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script>
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
     
     	$("#eid111").change(function(){
     		alert("hello");
     		var data="eid="+$("#eid111").val();
     		alert(data);
     		$.ajax({
     			url:'./CheckData',
     			data:data,
     			type:'post',
     			success:function(result){
     				if(result.match("1"))
     					{
     					alert("Data already exist");
     					}
     			}
     		});
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
<script type="text/javascript">
  function validate()
  {
	  var empDes=document.getElementById("empDes").value;
	  if(empDes.match("Select"))
		  {
		  alert("Please Select Employee Designation");
		  return false;
		  }
  return true;
  }

</script>

</head>
<body>
<div class="navbar-wrapper">
    <div class="container-fluid">
        <nav class="navbar navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Asset Management System</a>
                </div>
                
            </div>
        </nav>
    </div>
</div>
</br>
</br>
</br>

<p1 align="right">
 <form action="./adminop" method="post">
<input type="hidden" value="${user}" name="userid" /> 
<input type="submit" value="Home" name="op" />
<input type="submit" value="Logout" name="op" />
</form>
</p1>
<center>
<font color="green" size="10">
<%
String m=(String)request.getAttribute("msg");
if(m!=null)
	out.println(m);
%>
</font>
</center>		
<center>
<div class="box">
<font color="red"><h1>Create Employee</h1></font>
<table cellpadding="10" cellspacing="10" height="50%" width="30%">
 <form action="./insertEmp" method="post">
 <tr><td><b>Name</b></td><td><input type="text" name="name" required="required" /></td></tr>
 <tr><td><b>Address</b></td><td><input type="text" name="address" required="required" /></td></tr>
 <tr><td><b>Email</b></td><td><input type="email" name="email" required="required" /></td></tr>
 <tr><td><b>Mobile</b></td><td><input type="text" name="mobile" required="required" /></td></tr>
 <tr><td><b>Password</b></td><td><input type="password" name="password" required="required" /></td></tr>
 <tr><td><b>Designation</b></td><td><select  id="empDes" name="designation"  required="required" onblur="return validate()">
                     <option>Select</option>
                     <option value="Manager">Manager</option>
                     <option value="Employee">Employee</option>
                     <option value="Support Team">Support Team</option>
                     </select></td></tr>
                    
                     <tr id="Employee"><td>
<b>EMPLOYEE ID</b>          </td><td><input type="text" name="eid1" id="eid111" placeholder="E101" value="E101" maxlength="15" required="required" />
                     </td></tr>
                     <tr id="Manager"><td>
<b>Manager ID</b>           </td><td><select name="mid1" id="mid" />
                     </select>
                     </td></tr> 
                     <tr id="ManagerId"><td>
<b>Manager ID</b>    </td><td><input type="text" name="mid2" id="mid" value="M101" placeholder="M101" maxlength="15" required="required" />
                     </td></tr>
                     <tr id="Support"><td>
<b>EMPLOYEE ID</b> </td><td><input type="text" name="eid2" id="eid" value="S101" placeholder="S101" maxlength="15" required="required" />
                     </td></tr>
                     <tr id="SupportId"><td>
<b>Support ID</b>          </td><td><select name="sid" id="sid" />
                     </select>
                     </td></tr>

<tr><td><b>Date Of Joining</b></td><td><input type="date" name="dateofjoin" required="required" /></td></tr>

<tr><td></td><td><input type="submit" value="create" onclick="return confirm('Are you Sure')" /></td></tr>
</form>
</table>
</div>
 </center>
  </body>
  </html>