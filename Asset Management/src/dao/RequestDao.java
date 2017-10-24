package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Asset;

public class RequestDao {
	
	
	public int insertReq(String eid,String asset,String date,String aid,String desig,int status,String mid) 
	{
		int x=0;
		try
		{
			Connection con=new LoginDao().start();
			PreparedStatement ps=con.prepareStatement("insert into requestasset(eid,assetname,requestdate,assetid,designation,status,mid) values(?,?,?,?,?,?,?)");
			ps.setString(1, eid);
			ps.setString(2,asset);
			ps.setString(3, date);
			ps.setString(4, aid);
			ps.setString(5, desig);
			ps.setInt(6, status);
			ps.setString(7,mid);
			x=ps.executeUpdate();	
		}catch(SQLException e)
		{
			System.out.println(e);
		}
		return x;
	}
	
	
	public ArrayList<Asset> viewReq(String y)
	{   // int x=0;
		System.out.println("Request"+y);
	ArrayList<Asset> list=new ArrayList<>();
		
		try {
		Connection con=new LoginDao().start();
		PreparedStatement ps=con.prepareStatement("select * from requestasset where eid=? and status=1");
		ps.setString(1, y);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
		
			Asset a=new Asset();
			a.setAssetid(rs.getString("assetid"));
			a.setAssetname(rs.getString("assetname"));
			a.setRequestdate(rs.getString("requestdate"));
			a.setDesignation(rs.getString("designation"));
			a.setStatus(rs.getInt("status"));
			
			list.add(a);
		}
		
	}catch(SQLException e)
		{
		System.out.println(e);
		}
		return list;
	
	}
	
	
	
	
	
	
	
	

}
