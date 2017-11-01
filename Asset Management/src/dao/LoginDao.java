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

	
//	public Connection start()
//	{
//		Connection con=null;
//		try {	
//			 Class.forName("com.mysql.jdbc.Driver");
//		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/asset?user=root&password=");
//		}catch(ClassNotFoundException | SQLException e)
//		{
//			System.out.println(e);
//		}
//		return con;
//	}
	
	
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


	public int checkEmp(String eid, String pwd, String logas) {
		int x=0;
		if(logas.equalsIgnoreCase("Employee"))
		{
			AssetController ac=new AssetController();
			Session ss= ac.session();
			Criteria crit = ss.createCriteria(Employee.class);
		    crit.add(Restrictions.eq("eid",eid));
		    crit.add(Restrictions.eq("password",pwd));
		    crit.add(Restrictions.eq("designation",logas));
			
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
		if(logas.equalsIgnoreCase("Support Team"))
		{
			AssetController ac=new AssetController();
			Session ss= ac.session();
			Criteria crit = ss.createCriteria(Employee.class);
		    crit.add(Restrictions.eq("eid",eid));
		    crit.add(Restrictions.eq("password",pwd));
		    crit.add(Restrictions.eq("designation",logas));
			
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
		if(logas.equalsIgnoreCase("Manager"))
		{
			AssetController ac=new AssetController();
			Session ss= ac.session();
			Criteria crit = ss.createCriteria(Employee.class);
		    crit.add(Restrictions.eq("mid",eid));
		    crit.add(Restrictions.eq("password",pwd));
		    crit.add(Restrictions.eq("designation",logas));
			
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

		return x;
	}


	public int changeSPwd(String eid, String npass2,String cpass) {
	int x=0;
	String a=null;
	AssetController ac=new AssetController();
	Session ss= ac.session();
	String hql1="select password from Employee where eid=:a";
    Query q1=ss.createQuery(hql1);
    q1.setString("a",eid);
	Iterator it=q1.iterate();
	while(it.hasNext())
	{
		 a=(String) it.next();
	}
   
	if(a.equals(cpass))
	{
		
    String hql="update Employee set password=:b where eid=:a";
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
		 String hql="select managerid from employee where eid=:a";
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
