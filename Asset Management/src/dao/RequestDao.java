package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.controllers.AssetController;

import beans.Asset;
import beans.Employee;
import beans.Request;

public class RequestDao {
	
	
	public int insertReq(Request r) 
	{
		int x=0;
		//Connection con=new LoginDao().start();
		AssetController ac=new AssetController();
		Session ss= ac.session();
		System.out.println(r);
		Transaction tt=ss.beginTransaction();
		
			if(ss.save(r)!=null)
			{
		      x=1;	
			}	
			
			tt.commit();
			ss.close();
			
			return x;
	}
	
	
	public ArrayList<Request> viewReq(String y)
	{   
	
		int status=1;
		AssetController ac=new AssetController();
		Session ss= ac.session();
		Criteria crit = ss.createCriteria(Employee.class);
		crit.add(Restrictions.eq("status",status));
		crit.add(Restrictions.eq("eid",y));
	    ArrayList<Request> list = (ArrayList<Request>) crit.list();
		ss.close();
		
		return list;
	
	}
	
}
