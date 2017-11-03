package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.controllers.AssetController;

import beans.AdminLogin;
import beans.Employee;

public class LoginDao {
	
	public int check(String uid,String pwd)
	{    
			
	int x=0;
	AssetController ac=new AssetController();
	Session ss= ac.session();
	Criteria crit = ss.createCriteria(AdminLogin.class);
    crit.add(Restrictions.eq("userid",uid));
    crit.add(Restrictions.eq("password",pwd));
	List<AdminLogin> results = crit.list();
    if(results.isEmpty())
    {
    	x=0;
    }
    else
    {
    	x=1;
    }
    
    
    return x;
	}


	public int checkEmp(String eid, String pwd) {
		int x=0;
		
		int a=0;
		if(eid.contains("E"))
		{  
			AssetController ac=new AssetController();
			Session ss= ac.session();
			String hql="select status from Employee where eid1=:a";
				Query q=ss.createQuery(hql);
				q.setString("a",eid);
				Iterator it=q.iterate();
				while(it.hasNext())
				{
					 a=(Integer) it.next();
				}
			if(a==1)
			{
			Criteria crit = ss.createCriteria(Employee.class);
		    crit.add(Restrictions.eq("eid1",eid));
		    crit.add(Restrictions.eq("password",pwd));
		    crit.add(Restrictions.eq("designation","Employee"));
			
		    List<AdminLogin> results = crit.list();
		    if(results.isEmpty())
		    {
		    	x=0;
		    }
		    else
		    {
		    	x=1;
		    }
			}
		    
		}
		if(eid.contains("S"))
		{
			AssetController ac=new AssetController();
			Session ss= ac.session();
			String hql="select status from Employee where eid2=:a";
				Query q=ss.createQuery(hql);
				q.setString("a",eid);
				Iterator it=q.iterate();
				while(it.hasNext())
				{
					 a=(Integer) it.next();
				}
			if(a==1)
			{
		
			Criteria crit = ss.createCriteria(Employee.class);
		    crit.add(Restrictions.eq("eid2",eid));
		    crit.add(Restrictions.eq("password",pwd));
		    crit.add(Restrictions.eq("designation","Support Team"));
			
		    List<AdminLogin> results = crit.list();
		    if(results.isEmpty())
		    {
		    	x=0;
		    }
		    else
		    {
		    	x=1;
		    }
			}    
		    
		}
		if(eid.contains("M"))
		{
			AssetController ac=new AssetController();
			Session ss= ac.session();
			String hql="select status from Employee where mid2=:a";
				Query q=ss.createQuery(hql);
				q.setString("a",eid);
				Iterator it=q.iterate();
				while(it.hasNext())
				{
					 a=(Integer) it.next();
				}
			if(a==1)
			{
			Criteria crit = ss.createCriteria(Employee.class);
		    crit.add(Restrictions.eq("mid2",eid));
		    crit.add(Restrictions.eq("password",pwd));
		    crit.add(Restrictions.eq("designation","Manager"));
			
		    List<AdminLogin> results = crit.list();
		    if(results.isEmpty())
		    {
		    	x=0;
		    }
		    else
		    {
		    	x=1;
		    }
			}    
		    
		}

		return x;
	}


	public int changeSPwd(String eid, String npass2,String cpass) {
	int x=0;
	String a=null;
	AssetController ac=new AssetController();
	Session ss= ac.session();
	String hql1="select password from Employee where eid2=:a";
    Query q1=ss.createQuery(hql1);
    q1.setString("a",eid);
	Iterator it=q1.iterate();
	while(it.hasNext())
	{
		 a=(String) it.next();
	}
   
	if(a.equals(cpass))
	{
		
    String hql="update Employee set password=:b where eid2=:a";
    Query q=ss.createQuery(hql);
    q.setString("b",npass2);
    q.setString("a",eid);
     x=q.executeUpdate();

	}
		
		ss.close();
	
		return x;
	}
	
	public int changeAdPwd(String npass2, String cpass,String user) {
		
		int x=0;
		String a=null;
		AssetController ac=new AssetController();
		Session ss= ac.session();
		String hql1="select password from AdminLogin where userid=:a";
	    Query q1=ss.createQuery(hql1);
	    q1.setString("a",user);
		Iterator it=q1.iterate();
		while(it.hasNext())
		{
			 a=(String) it.next();
		}
	   
		if(a.equals(cpass))
		{
		String hql="update AdminLogin set password=:b where userid=:a";
	    Query q=ss.createQuery(hql);
	    q.setString("b",npass2);
	    q.setString("a",user);
	    Transaction tt=ss.beginTransaction();
		x=q.executeUpdate();
		tt.commit();
		
		}
	     
			ss.close();
	
			return x;
		}
	
	
	
	public String checkManager(String eid)
	{
		String a="";
		AssetController ac=new AssetController();
		Session ss= ac.session();
		 String hql="select mid1 from employee where eid1=:a";
		Query q=ss.createQuery(hql);
		q.setString("a",eid);
		Iterator it=q.iterate();
		while(it.hasNext())
		{
			 a=(String) it.next();
		}
		ss.close();
	return a;
		}

	
	
	
	
	
	
	
	
	
	
}
