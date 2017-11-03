package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

import com.controllers.AssetController;

import beans.AdminLogin;
import beans.Asset;
import beans.Employee;
import beans.Request;

public class EmpDao {

	
	public int insertEmp(Employee e)
	{
		int x=0;
		//Connection con=new LoginDao().start();
		AssetController ac=new AssetController();
		Session ss= ac.session();
		Transaction tt=ss.beginTransaction();
		
		System.out.println(e);
		if(e.getDesignation().equalsIgnoreCase("Manager"))
		{	
		
			if(ss.save(e)!=null)
			{
		      x=1;	
			}	
		}
		else if(e.getDesignation().equalsIgnoreCase("Employee"))
			
		{
			
			if(ss.save(e)!=null)
			{
			x=1;
				}
					
		}
			 
		else if(e.getDesignation().equalsIgnoreCase("Support Team"))
			
		{
			
			if(ss.save(e)!=null)
			{
			x=1;
				}
		}
		
		tt.commit();
		ss.close();
		
		
		return x;
		}
		
	public ArrayList<Employee>viewEmp()
	{
	
		AssetController ac=new AssetController();
		Session ss= ac.session();
		Criteria crit = ss.createCriteria(Employee.class);
		ArrayList<Employee> list = (ArrayList<Employee>) crit.list();
		
		ss.close();
		

		return list;
		
	}
	public int activateEmp(String eid) {
		int x=0;
		int status=1;
		AssetController ac=new AssetController();
		Session ss= ac.session();
		if(eid.contains("E"))
		{
	    String hql="update Employee set status=:a where eid1=:b";
	    Query q=ss.createQuery(hql);
	    q.setInteger("a",status);
	    q.setString("b",eid);
	    Transaction tt=ss.beginTransaction();
	     x=q.executeUpdate();
		    
	 	tt.commit();
		}
		if(eid.contains("S"))
		{
		    String hql="update Employee set status=:a where eid2=:b";
		    Query q=ss.createQuery(hql);
		    q.setInteger("a",status);
		    q.setString("b",eid);
		    Transaction tt=ss.beginTransaction();
		     x=q.executeUpdate();
			    
		 	tt.commit();
			}
		if(eid.contains("M"))
			{
			    String hql="update Employee set status=:a where mid2=:b";
			    Query q=ss.createQuery(hql);
			    q.setInteger("a",status);
			    q.setString("b",eid);
			    Transaction tt=ss.beginTransaction();
			     x=q.executeUpdate();
				    
			 	tt.commit();
				}
	 	ss.close();
			
	    
		return x;

	}
	public int deactivateEmp(String eid) {
		int x=0;
		int status=0;
		AssetController ac=new AssetController();
		Session ss= ac.session();
		if(eid.contains("E"))
		{
	    String hql="update Employee set status=:a where eid1=:b";
	    Query q=ss.createQuery(hql);
	    q.setInteger("a",status);
	    q.setString("b",eid);
	    Transaction tt=ss.beginTransaction();
	     x=q.executeUpdate();
		    
	 	tt.commit();
		}
		if(eid.contains("S"))
		{
		    String hql="update Employee set status=:a where eid2=:b";
		    Query q=ss.createQuery(hql);
		    q.setInteger("a",status);
		    q.setString("b",eid);
		    Transaction tt=ss.beginTransaction();
		     x=q.executeUpdate();
			    
		 	tt.commit();
			}
		if(eid.contains("M"))
			{
			    String hql="update Employee set status=:a where mid2=:b";
			    Query q=ss.createQuery(hql);
			    q.setInteger("a",status);
			    q.setString("b",eid);
			    Transaction tt=ss.beginTransaction();
			     x=q.executeUpdate();
				    
			 	tt.commit();
				}
	 		ss.close();
			

		return x;

	}

	public int updateEmp(Employee e) {
		int x=0;
	
			AssetController ac=new AssetController();
			Session ss= ac.session();
		   if(e.getMid2()!=null)
			{
			   if(e.getMid2().contains("M"))
		   {
			String hql="update Employee set sid=:a,designation=:b where mid2=:c";
		    Query q=ss.createQuery(hql);
		    q.setString("a",e.getSid());
		    q.setString("b",e.getDesignation());
		    q.setString("c",e.getMid2());
		    Transaction tt=ss.beginTransaction();
		     x=q.executeUpdate();
			    tt.commit();
		   }
			}
		   if(e.getEid2()!=null)
		{   
		   if(e.getEid2().contains("S"))
		   {
			String hql="update Employee set designation=:a where eid2=:b";
		    Query q=ss.createQuery(hql);
		    q.setString("a",e.getDesignation());
		    q.setString("b",e.getEid2());
		    Transaction tt=ss.beginTransaction();
		     x=q.executeUpdate();
			    tt.commit();
		   }
		}
		   if(e.getEid1()!=null)
		{
		   if(e.getEid1().contains("E"))
		   {
			String hql="update Employee set mid1=:a,designation=:b where eid1=:c";
		    Query q=ss.createQuery(hql);
		    q.setString("a",e.getMid1());
		    q.setString("b",e.getDesignation());
		    q.setString("c",e.getEid1());
		    Transaction tt=ss.beginTransaction();
		     x=q.executeUpdate();
			    tt.commit();
		   }
		}
		 	ss.close();
				

		return x;
	}

	public Employee viewEmpUpdate(String eid) {
		    
		  Employee e=null;
	
//			AssetController ac=new AssetController();
//			Session ss= ac.session();
		 SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();//Class.forName
			org.hibernate.Session ss=sf.openSession(); //Connection
			System.out.println(eid);
			if(eid.contains("E"))
		    {
		    String hql="from Employee where eid1=:a";
			Query q=ss.createQuery(hql);
			q.setString("a", eid);
			List<Employee> list=(List<Employee>)q.list();
			  e=list.get(0);
		    }
			
			if(eid.contains("S"))
		    {
		    String hql="from Employee where eid2=:a";
			Query q=ss.createQuery(hql);
			q.setString("a", eid);
			List<Employee> list=(List<Employee>)q.list();
			  e=list.get(0);
		    }
			
			if(eid.contains("M"))
		    {
		    String hql="from Employee where mid2=:a";
			Query q=ss.createQuery(hql);
			q.setString("a", eid);
			 List<Employee> list=(List<Employee>)q.list();
			  e=list.get(0);
			
			/*Iterator it=q.iterate();
			while(it.hasNext())
			{
				 e=(Employee) it.next();
			}*/
			/*Criteria ct=ss.createCriteria(Employee.class);
			ct.add(Restrictions.eq("mid2",eid));
			  List<Employee> list=(List<Employee>)ct.list();
			  e=list.get(0);*/
				
		    }
			ss.close();
			
		    
		    return e;
	}

	public ArrayList<Request> viewRequest() {
		int status=1;
		AssetController ac=new AssetController();
		Session ss= ac.session();
		Criteria crit = ss.createCriteria(Request.class);
		crit.add(Restrictions.eq("status",status));
	    ArrayList<Request> list = (ArrayList<Request>) crit.list();
		ss.close();
		
		return list;
	}

	public int approveReq(String eid) {
		

		int x=0;
		int status=3;
		AssetController ac=new AssetController();
		Session ss= ac.session();
	    String hql="update request set status=:a where eid=:b";
	    Query q=ss.createQuery(hql);
	    q.setInteger("a",status);
	    q.setString("b",eid);
	    Transaction tt=ss.beginTransaction();
	     x=q.executeUpdate();
		     	tt.commit();
		ss.close();
	    	

		return x;
	}
	
	public int rejectReq(String eid) {
		int x=0;
		int status=4;
		AssetController ac=new AssetController();
		Session ss= ac.session();
	    String hql="update request set status=:a where eid=:b";
	    Query q=ss.createQuery(hql);
	    q.setInteger("a",status);
	    q.setString("b",eid);
	    Transaction tt=ss.beginTransaction();
	     x=q.executeUpdate();
		    
	 	tt.commit();
	 	    		

		return x;

	}

	public ArrayList<Employee> viewReports() {
		

		int status=4;
		AssetController ac=new AssetController();
		Session ss= ac.session();
		Criteria crit = ss.createCriteria(Employee.class);
		crit.add(Restrictions.eq("status",status));
	    ArrayList<Employee> list = (ArrayList<Employee>) crit.list();
		ss.close();
		
		return list;
	
	}
	

	
	public String getAssetid(String assetname)
	{
		String a="";
		AssetController ac=new AssetController();
		Session ss= ac.session();
		 String hql="select assetid from Asset where assetname=:a";
		Query q=ss.createQuery(hql);
		q.setString("a",assetname);
		Iterator it=q.iterate();
		while(it.hasNext())
		{
			 a=(String) it.next();
		}
		ss.close();
	return a;
	}
	

	public ArrayList<Employee> viewProfile(String y)
	{
		AssetController ac=new AssetController();
		Session ss= ac.session();
		Criteria crit = ss.createCriteria(Employee.class);
		crit.add(Restrictions.eq("eid",y));
	    ArrayList<Employee> list = (ArrayList<Employee>) crit.list();
		ss.close();

	  return list;		
	}

	
	public ArrayList<Employee> viewEmUpdate(String eid) {
		AssetController ac=new AssetController();
		Session ss= ac.session();
		Criteria crit = ss.createCriteria(Employee.class);
		crit.add(Restrictions.eq("eid",eid));
	    ArrayList<Employee> list = (ArrayList<Employee>) crit.list();
		ss.close();


		return list;
	}

	
	
	
	
	public int chngEPass(String cpass,String npass2,String eid)
	{
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
	     Transaction tt=ss.beginTransaction();
	     x=q.executeUpdate();
		    
	 	tt.commit();
	 	
		}
			
			ss.close();
		
			return x;
}

	public ArrayList<Employee> viewmanagerprofile(String user1) {

		AssetController ac=new AssetController();
		Session ss= ac.session();
		Criteria crit = ss.createCriteria(Employee.class);
		crit.add(Restrictions.eq("mid",user1));
		crit.add(Restrictions.eq("designation","Manager"));
	    ArrayList<Employee> list = (ArrayList<Employee>) crit.list();
		Transaction tt=ss.beginTransaction();
		
		tt.commit();
		ss.close();

		return list;
		}

	public int MinsertRequest(Request r) 
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
	public ArrayList<Request> MviewRequest() 
	{
		int status=4;
		AssetController ac=new AssetController();
		Session ss= ac.session();
		Criteria crit = ss.createCriteria(Employee.class);
		crit.add(Restrictions.eq("status",status));
		ArrayList<Request> list = (ArrayList<Request>) crit.list();
		ss.close();
		
		return list;
	
			}

	public ArrayList<Request> viewmanagerasset() 
	{
		int status=5;
		AssetController ac=new AssetController();
		Session ss= ac.session();
		Criteria crit = ss.createCriteria(Employee.class);
		crit.add(Restrictions.eq("status",status));
		ArrayList<Request> list = (ArrayList<Request>) crit.list();
		ss.close();
		
		return list;
	}

	public ArrayList<Employee> viewMallemployee(String user1) 
	{
		AssetController ac=new AssetController();
		Session ss= ac.session();
		Criteria crit = ss.createCriteria(Employee.class);
		crit.add(Restrictions.eq("mid",user1));
		crit.add(Restrictions.eq("designation","Employee"));
		ArrayList<Employee> list = (ArrayList<Employee>) crit.list();
		ss.close();
		
		return list;
	}

	public int Managerupdateinsert(String mid,String npass2, String cpass) 
	{
		int x=0;
		String a=null;
		AssetController ac=new AssetController();
		Session ss= ac.session();
		String hql1="select password from Employee where mid=:a";
	    Query q1=ss.createQuery(hql1);
	    q1.setString("a",mid);
		Iterator it=q1.iterate();
		while(it.hasNext())
		{
			 a=(String) it.next();
		}
	   
		if(a.equals(cpass))
		{
			
	    String hql="update Employee set password=:b where mid=:a";
	    Query q=ss.createQuery(hql);
		Transaction tt=ss.beginTransaction();
		q.setString("b",npass2);
	    q.setString("a",mid);
	     x=q.executeUpdate();
	     tt.commit();
			
		}
			
			ss.close();
		
			return x;
	}

	
	}
	
	

