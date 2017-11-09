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
<body>
<p1 align="right">
 <form action="./empop" method="post">
<input type="hidden" value="${user}" name="userid" /> 
<input type="submit" value="Home" name="op" />
<input type="submit" value="Logout" name="op" />
</form>
</p1>
<h1>My Assets</h1>
<h1>${msg}</h1>
<table border="3">
<tr>
  <th>AssetID</th>
  <th>AssetName</th>
  <th>EmployeeId</th>
  <th>ManagerId</th>
  <th>Status</th>
  <th>To</th>
  <th>Transfer Asset</th>
  </tr>
<%@page import="java.util.ArrayList,beans.Asset" %>
<%
ArrayList<Asset> ar=(ArrayList<Asset>)request.getAttribute("LIST");
for(Asset cc:ar)
{
%>
<tr>
<form action="TransferEasset" method="post">
    <input type="hidden" value="<%=cc.getAssetid()%>" name="assetid" /> 
    <input type="hidden" value="<%=cc.getEid1()%>" name="eid1" /> 
    <td><%=cc.getAssetid()%></td>
    <td><%=cc.getAssetname()%></td>
    <td><%=cc.getEid1()%></td>
    <td><%=cc.getMid1()%></td>
    <%  int st=0;
      String status="";
      st=cc.getStatus(); 
      if(st==1)
      {
    	  status="Allocated";
      }
       %>
    <td><%=status%></td>  
    <%@page import="dao.EmpDao,beans.Employee"%>
    <% EmpDao ed=new EmpDao();
       ArrayList<Employee> list=(ArrayList<Employee>)ed.getEmpDetail();
        
         for(Object o:list)
       {
    		  if(o instanceof Employee)
    		  {
    			  Employee e=(Employee)o;
    		
     %>
   <td><select name="eid"/>
                     <option><%=e.getEid1()%></option>
                     <option><%=e.getMid2()%></option>
                     </select></td>
                  <%  }  
       	   } %>
    <td><input type="submit" value="Tranfser" onclick="confirm('are you sure')" />
    </td>
    </form>
    </tr>
    <%
}
    %>

</body>
</table>
</html>