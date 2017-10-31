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
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.controllers.AssetController;

import beans.AdminLogin;
import beans.Asset;
import beans.Employee;

public class EmpDao {

	
	public int insertEmp(Employee e)
	{
		int x=0;
		//Connection con=new LoginDao().start();
		AssetController ac=new AssetController();
		Session ss= ac.session();
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
		Transaction tt=ss.beginTransaction();
		
		tt.commit();
		ss.close();
		
		
		return x;
		}
		
	public List<Employee>viewEmp()
	{
	
		AssetController ac=new AssetController();
		Session ss= ac.session();
		Criteria crit = ss.createCriteria(Employee.class);
		List<Employee> list = crit.list();
		Transaction tt=ss.beginTransaction();
		
		tt.commit();
		ss.close();
		

		return list;
		
	}
	public int activateEmp(String eid) {
		int x=0;
		int status=1;
		AssetController ac=new AssetController();
		Session ss= ac.session();
	    String hql="update Employee set status=:a where eid=:b";
	    Query q=ss.createQuery(hql);
	    q.setInteger("a",status);
	    q.setString("b",eid);
	     x=q.executeUpdate();

	     Transaction tt=ss.beginTransaction();
			
			tt.commit();
			ss.close();
			
	    
		return x;

	}
	public int deactivateEmp(String eid) {
		int x=0;
		int status=0;
		AssetController ac=new AssetController();
		Session ss= ac.session();
	    String hql="update Employee set status=:a where eid=:b";
	    Query q=ss.createQuery(hql);
	    q.setInteger("a",status);
	    q.setString("b",eid);
	     x=q.executeUpdate();

	     Transaction tt=ss.beginTransaction();
			
			tt.commit();
			ss.close();
			

		return x;

	}

	public int updateEmp(Employee e,String eid1) {
		int x=0;
	
			AssetController ac=new AssetController();
			Session ss= ac.session();
		    String hql="update Employee set eid=a:,name=:b,address=:c,mobile=:d,email=:e,password=:f,designation=:g where eid=:h";
		    Query q=ss.createQuery(hql);
		    q.setString("a",e.getEid());
		    q.setString("b",e.getName());
		    q.setString("c",e.getAddress());
		    q.setLong("d",e.getMobile());
		    q.setString("e",e.getEmail());
		    q.setString("f",e.getPassword());
		    q.setString("g",e.getDesignation());
		    q.setString("h",eid1);
		     x=q.executeUpdate();

		     
		     Transaction tt=ss.beginTransaction();
				
				tt.commit();
				ss.close();
				

		return x;
	}

	public Employee viewEmpUpdate(String eid) {
		    
		  Employee e=new Employee();
	
			AssetController ac=new AssetController();
			Session ss= ac.session();
			String hql="from Employee where eid=:a";
			Query q=ss.createQuery(hql);
			q.setString("a", eid);
			Iterator it=q.iterate();
			while(it.hasNext())
			{
				 e=(Employee) it.next();
			}
			ss.close();
			
		    
		    return e;
	}

	public ArrayList<Employee> viewRequest() {
		int status=2;
		AssetController ac=new AssetController();
		Session ss= ac.session();
		Criteria crit = ss.createCriteria(Employee.class);
		crit.add(Restrictions.eq("status",status));
	    ArrayList<Employee> list = (ArrayList<Employee>) crit.list();
		Transaction tt=ss.beginTransaction();
		
		tt.commit();
		ss.close();
		
		return list;
	}

	public int approveReq(String eid) {
		

		int x=0;
		int status=4;
		AssetController ac=new AssetController();
		Session ss= ac.session();
	    String hql="update request set status=:a where eid=:b";
	    Query q=ss.createQuery(hql);
	    q.setInteger("a",status);
	    q.setString("b",eid);
	     x=q.executeUpdate();

	     
	     Transaction tt=ss.beginTransaction();
			
			tt.commit();
			ss.close();
	    	

		return x;
	}
	
	public int rejectReq(String eid) {
		int x=0;
		int status=5;
		AssetController ac=new AssetController();
		Session ss= ac.session();
	    String hql="update request set status=:a where eid=:b";
	    Query q=ss.createQuery(hql);
	    q.setInteger("a",status);
	    q.setString("b",eid);
	     x=q.executeUpdate();
		    		

		return x;

	}

	public ArrayList<Employee> viewReports() {
		

		int status=4;
		AssetController ac=new AssetController();
		Session ss= ac.session();
		Criteria crit = ss.createCriteria(Employee.class);
		crit.add(Restrictions.eq("status",status));
	    ArrayList<Employee> list = (ArrayList<Employee>) crit.list();
		Transaction tt=ss.beginTransaction();
		
		tt.commit();
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
		Transaction tt=ss.beginTransaction();
		
		tt.commit();
		ss.close();

	  return list;		
	}

	
	public ArrayList<Employee> viewEmUpdate(String eid) {
		AssetController ac=new AssetController();
		Session ss= ac.session();
		Criteria crit = ss.createCriteria(Employee.class);
		crit.add(Restrictions.eq("eid",eid));
	    ArrayList<Employee> list = (ArrayList<Employee>) crit.list();
		Transaction tt=ss.beginTransaction();
		
		tt.commit();
		ss.close();


		return list;
	}

	
	
	
	
	public int chngPass(String current,String New,String confirm)
	{
		int x=0;
		String id=null;
		String pass="";
		try {
			
			Connection con=new LoginDao().start();
			PreparedStatement ps=con.prepareStatement("select * from employee where password='"+current+"'");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				id=rs.getString(1);
				pass=rs.getString(6);
				
				System.out.println(id+""+pass);
				
				
			}
			if(pass.equals(current))
			{			
				PreparedStatement ps1=con.prepareStatement("update employee set password='"+New+"'  where eid='"+id+"'");
				 x=ps1.executeUpdate();
				
			}
			
			
		}catch(SQLException e)
		{
			
			System.out.println(e);
		}
		return x;
	}

	public ArrayList<Employee> viewmanagerprofile(String user1) {

		AssetController ac=new AssetController();
		Session ss= ac.session();
		Criteria crit = ss.createCriteria(Employee.class);
		crit.add(Restrictions.eq("managerid",user1));
		crit.add(Restrictions.eq("designation","Manager"));
	    ArrayList<Employee> list = (ArrayList<Employee>) crit.list();
		Transaction tt=ss.beginTransaction();
		
		tt.commit();
		ss.close();

		return list;
		}

	public int MinsertRequest(Employee e1) 
	{
int x=0;
       AssetController ac=new AssetController();
       Session ss= ac.session();
       System.out.println(e1);

	if(ss.save(e1)!=null)
	{
      x=1;	
	}	
	Transaction tt=ss.beginTransaction();
	
	tt.commit();
	ss.close();
	
	
	return x;


		int status=2;
		try {	
			Connection con=new LoginDao().start();
		    PreparedStatement ps=con.prepareStatement("insert into managercreaterequest values(?,?,?,?,?,?)");
			ps.setString(1,e1.getMid());
			ps.setInt(2,e1.getAssetid());
			ps.setString(3,e1.getAssetname());
			ps.setInt(4,e1.getrequestid());
			ps.setString(5,e1.getdate());
			ps.setInt(6, status);
			x= ps.executeUpdate();
	}

	public ArrayList<Employee> MviewRequest() 
	{
		ArrayList list=new ArrayList();
		try {	
			Connection con=new LoginDao().start();
		    PreparedStatement ps=con.prepareStatement("select * from managercreaterequest where status='4'");
			ResultSet rs= ps.executeQuery();
		while(rs.next())
		{
			 Employee a1=new Employee();
			a1.setMid(rs.getString("mid"));
			a1.setAssetid(rs.getInt("assetid"));
			a1.setAssetname(rs.getString("assetname"));
			a1.setrequestid(rs.getInt("requestid"));
			a1.setdate(rs.getString("date"));
			a1.setStatus(rs.getInt("status"));
			
			list.add(a1);
		}
			con.close();
			  }catch(SQLException  ex)
			{
				System.err.println(ex);
				ex.printStackTrace();
			}
		return list;
	}

	public ArrayList<Employee> viewmanagerasset() 
	{
		ArrayList list=new ArrayList();
	try {	
		Connection con=new LoginDao().start();
	    PreparedStatement ps=con.prepareStatement("select * from managercreaterequest where status='5'");
		ResultSet rs= ps.executeQuery();
	while(rs.next())
	{
		 Employee a1=new Employee();
		a1.setMid(rs.getString("mid"));
		a1.setAssetid(rs.getInt("assetid"));
		a1.setAssetname(rs.getString("assetname"));
		a1.setrequestid(rs.getInt("requestid"));
		a1.setdate(rs.getString("date"));
		a1.setStatus(rs.getInt("status"));
		list.add(a1);
	}
		con.close();
		  }catch(SQLException  ex)
		{
			System.err.println(ex);
			ex.printStackTrace();
		}
	return list;

	}

	public ArrayList<Employee> viewMallemployee(String user1) 
	{
		ArrayList<Employee> list=new ArrayList<>();
		try {	
			Connection con=new LoginDao().start();
		    PreparedStatement ps=con.prepareStatement("select * from Employee where managerid=? and designation='Employee'");
		    System.out.println("hii0");
		    ps.setString(1, user1);
			ResultSet rs= ps.executeQuery();
			//if("Employee".equals(designation)) {
		while(rs.next())
		{
			System.out.println("hii");
			Employee a1=new Employee();
			a1.setEid(rs.getString("eid"));
			a1.setName(rs.getString("name"));
			a1.setAddress(rs.getString("address"));
			a1.setMobile(rs.getLong("mobile"));
			a1.setEmail(rs.getString("email"));
			a1.setPassword(rs.getString("password"));
			a1.setDesignation(rs.getString("designation"));
			a1.setMid(rs.getString("managerid"));
			a1.setSid(rs.getString("supportid"));
			a1.setDateofjoin(rs.getString("dateofjoin"));
			a1.setStatus(rs.getInt("status"));
			
			list.add(a1);
		}
			con.close();
			  }catch(SQLException  ex)
			{
				System.err.println(ex);
				ex.printStackTrace();
			}
		return list;
	}

	public Employee Mupdatepassword(String user1) 
	{
		Employee a1=new  Employee();
		try {	
			Connection con=new LoginDao().start();
		    PreparedStatement ps=con.prepareStatement("select password from employee where managerid=? designation='Employee' ");
		    ps.setString(1,user1);
		    ResultSet rs=ps.executeQuery();
		    while(rs.next())
		    { 
			a1.setPassword(rs.getString("password"));
		    }
			con.close();
			  }catch(SQLException  ex)
			{
				System.out.println(ex);
			}
		
		return a1;
			
	}

	public int Managerupdateinsert(Employee a1) 
	{
		int x=0;
		try 
		{
			Connection con=new LoginDao().start();
		PreparedStatement ps=con.prepareStatement("update employee set password=? where managerid=?");
		
		ps.setString(1,a1.getPassword());
		ps.setString(2,a1.getMid());
		System.out.println(a1.getPassword());
		System.out.println(a1.getMid());
		x=ps.executeUpdate();
		
		if(x!=0)
		{
			 System.out.println("update");
		}
		 con.close();
		}catch(SQLException  ex)
		{
			System.err.println(ex);
			ex.printStackTrace();
		}
	return x;
	}

	
	}
	
	

