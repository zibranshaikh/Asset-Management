package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
		Date d=new Date();
		d.getTime();
		//Connection con=new LoginDao().start();
		AssetController ac=new AssetController();
		Session ss= ac.session();
		System.out.println(r);
		Transaction tt=ss.beginTransaction();
		SimpleDateFormat s=new SimpleDateFormat("dd/MM/yyyy");
		r.setRequestdate(s.format(new Date()));
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
	
		AssetController ac=new AssetController();
		Session ss= ac.session();
		Criteria crit = ss.createCriteria(Request.class);
		crit.add(Restrictions.eq("eid1",y));
	    ArrayList<Request> list = (ArrayList<Request>) crit.list();
		ss.close();
		
		return list;
	
	}
	
}
