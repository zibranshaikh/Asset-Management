<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@page import="java.sql.Connection" %>
    <%@page import="java.sql.DriverManager" %>
      <%@page import="java.sql.PreparedStatement" %>
        <%@page import="java.sql.ResultSet" %>
    
<%

try
{	
	//loading the class		
	Class.forName("com.mysql.jdbc.Driver");
	
	//establishing connection  
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/asset","root","");

	String sql = "select managerid from employee where managerid like 'M%'";
	
	PreparedStatement ps = con.prepareStatement(sql);
	
	System.out.println(ps);
	ResultSet rs = ps.executeQuery();
	
	while(rs.next())
	{
       %>	
    	<option><%=rs.getString("managerid")%></option>
	  <%
	}
   }
catch(Exception e)
{
	System.out.println("class Connect.start() exception"+e);
}
%>
