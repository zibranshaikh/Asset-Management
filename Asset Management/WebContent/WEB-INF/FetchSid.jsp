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
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assetmanagement","root","");

	String sql = "select eid2 from employee where designation='Support Team' and eid2 like 'S%'";
	
	PreparedStatement ps = con.prepareStatement(sql);
	
	System.out.println(ps);
	ResultSet rs = ps.executeQuery();
	
	while(rs.next())
	{
       %>	
    	<option><%=rs.getString("eid2")%></option>
	  <%
	}
   }
catch(Exception e)
{
	System.out.println("class Connect.start() exception"+e);
}
%>
