package com.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import beans.AdminLogin;
import beans.Asset;
import beans.Employee;
import dao.EmpDao;
import dao.LoginDao;
import dao.RequestDao;

@Controller
@SessionAttributes({"user","mid"})
public class AssetController
{

	public org.hibernate.Session session()
	{
	SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();//Class.forName
	org.hibernate.Session ss=sf.openSession(); //Connection
	
	return ss;
	}

//	@Override
//	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
	@RequestMapping("/")
  	public ModelAndView home()
  {
          ModelAndView mv=new ModelAndView("Home");//view name
          mv.addObject("msg","Welcome");
          
  		return mv;
  	}
	
	
	@RequestMapping("/adminlogin")
  	public ModelAndView Adminlogin()
  {
		
		ModelAndView mv=new ModelAndView("Hello");//view name
          mv.addObject("msg","Admin");
          
  		return mv;
  	}
	   @ModelAttribute
	   public void addCommonObject(Model m)
	   {
		   m.addAttribute("head","Systango Technologies");
	   }
	   
		@RequestMapping("/check")
		public ModelAndView welcome(@RequestParam String uid,@RequestParam String pwd)
	{      ModelAndView mv=null;
	      
	int y=0;
	        LoginDao ld=new LoginDao();
	         y=ld.check(uid,pwd);
	        if(y!=0)
	        { 
	          String user=uid;
	         if(user!=null)
	         {
	        mv=new ModelAndView("Admin");//view name
	        mv.addObject("user",uid);
	         }
	         }
	        else
	        {
	        mv=new ModelAndView("Hello");	
	        mv.addObject("msg","Login failed, please try again");
	        }
	        return mv;
		}

		@RequestMapping("/changeAdpwd")
		public ModelAndView  changeAdpwd()
		{  ModelAndView mv=null; 
		   mv=new ModelAndView("changeAdminPwd");//view name
	 	     return mv;

		}
			
		@RequestMapping("/AdpwdChange")
		public ModelAndView  AdpwdChange(@RequestParam String userid,@RequestParam String npwd1)
		{  
			System.out.println(userid+" user "+npwd1+" new pass");
			ModelAndView mv=null; 
		 
		   LoginDao l=new LoginDao();
	       int y=l.changeAdPwd(userid,npwd1);
	       if(y!=0)
	       {
	    	   mv=new ModelAndView("Admin");//view name
	 	       mv.addObject("msg","Password Succesfully Changed");
	       }
	       else
	       {
	    	   mv=new ModelAndView("Admin");//view name
	 	       mv.addObject("msg1","Password Not Changed");
	         
	       }
	       
	     return mv;

		}
		

	@RequestMapping("/Emplogin")
  	public ModelAndView Emplogin()
  {
          ModelAndView mv=new ModelAndView("EmpLogin");//view name
          mv.addObject("msg","Employee");
          
  		return mv;
  	}
   
	@RequestMapping("/empcheck")
	public ModelAndView checkemp(@RequestParam String eid,@RequestParam String pwd,@RequestParam String logas)
{      ModelAndView mv=null;
      
      System.out.println(eid+" "+pwd+" "+logas);
      int y=0;
        LoginDao ld=new LoginDao();
         y=ld.checkEmp(eid,pwd,logas);
         
         System.out.println("y in empcheckdao"+y);
        if(y!=0)
        {
        if(logas.equalsIgnoreCase("Support Team"))
         {
        mv=new ModelAndView("Support");//view name
        mv.addObject("user",eid);
        }
         if(logas.equalsIgnoreCase("Employee"))
         {
        	
      //  mv=new ModelAndView("EmployeeHome");//view name
        //String z=ld.checkManager(eid);
	   // mv.addObject("mid",z);
        mv.addObject("user",eid);
        }
         if(logas.equalsIgnoreCase("Manager"))
         {
        mv=new ModelAndView("managerhome");//view name
        mv.addObject("user",eid);
        }
         }
        else
        {
        mv=new ModelAndView("EmpLogin");
        mv.addObject("msg","Login failed, please try again");
        }
        return mv;
	}
	@RequestMapping("/changePwdjs")
	public ModelAndView  changepwdjs()
	{  ModelAndView mv=null; 
	 
	       mv=new ModelAndView("changePwd");//view name
 	     return mv;

	}
		
	@RequestMapping("/pwdChange")
	public ModelAndView  pwdChange(@RequestParam String eid,@RequestParam String npwd1)
	{  ModelAndView mv=null; 
	 
	   LoginDao l=new LoginDao();
       int y=l.changePwd(eid,npwd1);
       if(y!=0)
       {
    	   mv=new ModelAndView("Support");//view name
 	       mv.addObject("msg","Password Succesfully Changed");
       }
       
     return mv;

	}
	
	@RequestMapping("/createEmp")
	public ModelAndView  createEmp()
	{  ModelAndView mv=null; 
	 
	       mv=new ModelAndView("createEmp");//view name
 	     return mv;

	}

   @RequestMapping("/insertEmp")
    //public(@RequestParam int id,@RequestParam String name,@RequestParam String address,@RequestParam String mobile)
  	public ModelAndView insertEmp(@ModelAttribute("Employee") Employee c)
  	{
        ModelAndView mv=null;
        //Customer c=new Customer();
        //c.setEid(id);
        //c.setName(name);
        //c.setAddress(salary);
        //c.setMobile(mobile);
        //c.setEmail(email);
        
        EmpDao l=new EmpDao();
        int y=l.insertEmp(c);
        if(y==1)
        { 
         if(c.getDesignation().equalsIgnoreCase("Employee"))
         {
         sendMail(c.getEid(),c.getEmail(),c.getPassword(),c.getMid());
         }
         else if(c.getDesignation().equalsIgnoreCase("Manager"))
         {
         sendMail(c.getMid(),c.getEmail(),c.getPassword());
         }
         else if(c.getDesignation().equalsIgnoreCase("Support Team"))
         {
         sendMail1(c.getEid(),c.getEmail(),c.getPassword());
         }
         mv=new ModelAndView("createEmp");//view name
       mv.addObject("msg","Employee Succesfully created");
        }
		return mv;

  	}
   
   public void sendMail(String eid,String email,String pwd1,String managerid)
   {
		  // Recipient's email ID needs to be mentioned.
	      String to =email;//request.getParameter("id");//change accordingly
	      String sub="Systango Account Creation & Password";
//	      long p=System.currentTimeMillis();//439807598430759083
//	      String pwd=(p+"").substring(7);
	      String pwd=pwd1;
	      String msg="Welcome at Systango your login id is "+eid+" and your password "+pwd+" your manager id is "+managerid;
	      // Sender's email ID needs to be mentioned
	      String from = "zshaikh1990s@gmail.com";
	      final String username = "zshaikh1990s@gmail.com";//change accordingly
	      final String password = "93009300";//change accordingly

	      // Assuming you are sending email through relay.jangosmtp.net
	      String host = "smtp.gmail.com";

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "587");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	         }
	      });

	      try {
	         // Create a default MimeMessage object.
	         Message message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.setRecipients(Message.RecipientType.TO,
	         InternetAddress.parse(to));

	         // Set Subject: header field
	         message.setSubject(sub);

	         // Now set the actual message
	         message.setText(msg);

	         // Send message
	         
	         Transport.send(message);
//	         PrintWriter out=response.getWriter();
//	        out.println("Sent message successfully....");
	         } catch (MessagingException e) {
	    	  e.printStackTrace();
	    	     }	
	      }
   
   public void sendMail(String managerid,String email,String pwd1)
   {
	      String to = email;//request.getParameter("id");//change accordingly
	      String sub="Systango Employee Account Creation & Password";
//	      long p=System.currentTimeMillis();//439807598430759083
//	      String pwd=(p+"").substring(7);
          String pwd=pwd1;
	      String msg="Welcome at Systango your Login Id is "+managerid+" and your password is "+pwd;
	      // Sender's email ID needs to be mentioned
	      String from = "zshaikh1990s@gmail.com";
	      final String username = "zshaikh1990s@gmail.com";//change accordingly
	      final String password = "93009300";//change accordingly

	      // Assuming you are sending email through relay.jangosmtp.net
	      String host = "smtp.gmail.com";

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "587");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	         }
	      });

	      try {
	         // Create a default MimeMessage object.
	         Message message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.setRecipients(Message.RecipientType.TO,
	         InternetAddress.parse(to));

	         // Set Subject: header field
	         message.setSubject(sub);

	         // Now set the actual message
	         message.setText(msg);

	         // Send message
	         
            Transport.send(message);
//	         PrintWriter out=response.getWriter();
//	        out.println("Sent message successfully....");

	         System.out.println("Mail sent Successfully");
	         } catch (MessagingException e) {
	    	  e.printStackTrace();
	    	     }	
	      }
 
   public void sendMail1(String eid,String email,String pwd1)
   {
	   String to = email;//request.getParameter("id");//change accordingly
	      String sub="Systango Employee Account Creation & Password";
//	      long p=System.currentTimeMillis();//439807598430759083
//	      String pwd=(p+"").substring(7);
          String pwd=pwd1;
	      String msg="Welcome at Systango your Login Id is "+eid+" and your password is "+pwd;
	      // Sender's email ID needs to be mentioned
	      String from = "zshaikh1990s@gmail.com";
	      final String username = "zshaikh1990s@gmail.com";//change accordingly
	      final String password = "93009300";//change accordingly

	      // Assuming you are sending email through relay.jangosmtp.net
	      String host = "smtp.gmail.com";

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "587");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	         }
	      });

	      try {
	         // Create a default MimeMessage object.
	         Message message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.setRecipients(Message.RecipientType.TO,
	         InternetAddress.parse(to));

	         // Set Subject: header field
	         message.setSubject(sub);

	         // Now set the actual message
	         message.setText(msg);

	         // Send message
	         
	         Transport.send(message);
//	         PrintWriter out=response.getWriter();
//	        out.println("Sent message successfully....");
	         System.out.println("Mail sent Successfully");
	         } catch (MessagingException e) {
	    	  e.printStackTrace();
	    	     }	
	      }
     
   @RequestMapping("/UpdateEmp")
   //public(@RequestParam int id,@RequestParam String name,@RequestParam String address,@RequestParam String mobile)
 	public ModelAndView updateEmp(@ModelAttribute("Employee") Employee c,@RequestParam String eid1)
 	{
       ModelAndView mv=null;
       //Customer c=new Customer();
       //c.setEid(id);
       //c.setName(name);
       //c.setAddress(salary);
       //c.setMobile(mobile);
       //c.setEmail(email);
       
       EmpDao l=new EmpDao();
       int y=l.updateEmp(c,eid1);
       if(y==1)
       {
    	   EmpDao ed=new EmpDao();
  	      List<Employee>list=ed.viewEmp();
  	       mv=new ModelAndView("viewEmp");//view name
  	      mv.addObject("LIST",list);
  	    mv.addObject("msg","Employee Succesfully updated");
       }
		return mv;

 	}

   @RequestMapping("/viewEmp")
 	public ModelAndView  viewEmp()
 	{
	   EmpDao ed=new EmpDao();
	      List<Employee>list=ed.viewEmp();
	      ModelAndView mv=new ModelAndView("viewEmp");//view name
	       mv.addObject("LIST",list);
	       
      return mv;

 	}

   @RequestMapping("/empAD")
	public ModelAndView  empAD(@RequestParam String eid,@RequestParam String op)
	{  ModelAndView mv=null; 
	   if(op.equals("Activate"))
    {
	   
	   EmpDao l=new EmpDao();
       int y=l.activateEmp(eid);
       if(y!=0)
       {
    	   EmpDao ed=new EmpDao();
 	      List<Employee>list=ed.viewEmp();
 	       mv=new ModelAndView("viewEmp");//view name
 	       mv.addObject("LIST",list);
 	       mv.addObject("msg","Employee Succesfully Activated");
       }
    }  else if(op.equals("Deactivate"))
          {
	   
	   EmpDao l=new EmpDao();
       int y=l.deactivateEmp(eid);
       if(y!=0)
       {
    	   EmpDao ed=new EmpDao();
 	      List<Employee>list=ed.viewEmp();
 	       mv=new ModelAndView("viewEmp");//view name
 	       mv.addObject("LIST",list);
 	       mv.addObject("msg1","Employee Succesfully Deactivated");
       
       }
       }
	   if(op.equalsIgnoreCase("Update"))
	   {     
		   EmpDao ed=new EmpDao();
		      Employee e=new Employee();
		      e=ed.viewEmpUpdate(eid);
		      mv=new ModelAndView("updateEmp");//view name
		       mv.addObject("E",e);
	   }
     return mv;

	}
   @RequestMapping("/viewRequest")
 	public ModelAndView  viewRequest()
 	{
	   EmpDao rd=new EmpDao();
	      ArrayList<Employee>list=rd.viewRequest();
	      ModelAndView mv=new ModelAndView("viewReq");//view name
	       mv.addObject("LIST",list);
      
      return mv;

 	}
	
   
   @RequestMapping("/approveReq")
	public ModelAndView  approveReq(@RequestParam String eid,@RequestParam String op)
	{  ModelAndView mv=null; 
	   if(op.equalsIgnoreCase("Approve"))
   {
	   
	   EmpDao l=new EmpDao();
      int y=l.approveReq(eid);
      if(y==1)
      {
   	   EmpDao rd=new EmpDao();
	      ArrayList<Employee>list=rd.viewRequest();
	       mv=new ModelAndView("viewReq");//view name
	       mv.addObject("LIST",list);
	       mv.addObject("msg2","Request Approved ");
      }
   }  else if(op.equalsIgnoreCase("Reject"))
         {
	   
	   EmpDao l=new EmpDao();
    //  int y=l.rejectReq(eid);
     // if(y==1)
      {
    	  EmpDao rd=new EmpDao();
	      ArrayList<Employee>list=rd.viewRequest();
	       mv=new ModelAndView("viewReq");//view name
	       mv.addObject("LIST",list);
	       mv.addObject("msg1","Request Reject for Employee");
      
      }
      }
	   
    return mv;

	}

   @RequestMapping("/reports")
	public ModelAndView  viewReports()
	{
	   EmpDao rd=new EmpDao();
	      ArrayList<Employee>list=rd.viewReports();
	      ModelAndView mv=new ModelAndView("viewReport");//view name
	       mv.addObject("LIST",list);
     
     return mv;

	}

   @RequestMapping("/supop")
	public ModelAndView  supop(@RequestParam String eid,@RequestParam String op)
	{  ModelAndView mv=null; 
	   if(op.equalsIgnoreCase("Home"))
   {
	        mv=new ModelAndView("Support");//view name
	        mv.addObject("user",eid);
	            
	  }
    else if(op.equalsIgnoreCase("Logout"))
         {
        mv=new ModelAndView("logout");//view name
      }
    return mv;

	}
   @RequestMapping("/adminop")
	public ModelAndView  adop(@RequestParam String userid,@RequestParam String op)
	{  ModelAndView mv=null; 
	   if(op.equalsIgnoreCase("Home"))
   {
	        mv=new ModelAndView("Admin");//view name
	        mv.addObject("user",userid);
	            
	  }
    else if(op.equalsIgnoreCase("Logout"))
        {
        mv=new ModelAndView("Adlogout");//view name
      }
    return mv;

	}

   @RequestMapping("/managerop")
  	public ModelAndView  managerop(@RequestParam String op)
  	{  ModelAndView mv=null; 
  	   if(op.equalsIgnoreCase("Home"))
     {
  	        mv=new ModelAndView("managerhome");//view name
  	       
  	  }
      else if(op.equalsIgnoreCase("Logout"))
           {
          mv=new ModelAndView("Mlogout");//view name
        }
      return mv;

  	}
   @RequestMapping("/empop")
  	public ModelAndView  empop(@RequestParam String op)
  	{  ModelAndView mv=null; 
  	   if(op.equalsIgnoreCase("Home"))
     {
  	        mv=new ModelAndView("EmployeeHome");//view name
  	           
  	  }
      else if(op.equalsIgnoreCase("Logout"))
           {
          mv=new ModelAndView("logout");//view name
        }
      return mv;

  	}

  @RequestMapping("/fetchMid")
  public ModelAndView  fetchMid()
     { 
	  ModelAndView mv=null; 
      mv=new ModelAndView("/FetchMid");//view name
	     return mv;
    }
  @RequestMapping("/fetchSid")
  public ModelAndView  fetchSid()
     { 
	  ModelAndView mv=null; 
      mv=new ModelAndView("/FetchSid");//view name
	     return mv;
    }
  @RequestMapping("/AssetRequest")
	protected ModelAndView assetReq() {
	  ModelAndView mv=new ModelAndView("createRequest");
	 mv.addObject("msg", "Created Succesfully");
	  return mv;
}
  @RequestMapping("/insertRequest")
protected ModelAndView insertReq(@RequestParam("id") String eid,@RequestParam("assets")String asset,@RequestParam("date") String date,@RequestParam("assetid") String aid,@RequestParam("designation") String desig,HttpServletRequest request)
{         int status=1;
  	ModelAndView mv=null;
  	RequestDao ed=new RequestDao();
  	//System.out.println(asset);
  	HttpSession ss=request.getSession();
  	String mid=(String)ss.getAttribute("mid");
  	int y=ed.insertReq(eid,asset,date,aid,desig,status,mid);
  	System.out.println("insert request= "+y);
  	if(y==1)
  	{
  	  mv=new ModelAndView("createRequest");
		  mv.addObject("msg", "Request Sent To Manager");
		 
		  
  	}
  	else {
  		mv=new ModelAndView("createRequest");
  		mv.addObject("msg", "Request not sent ");
  	}
  	return mv;
}
  @RequestMapping("/ViewRequest")
 	protected ModelAndView viewAsset(HttpServletRequest request) {
 	  ModelAndView mv=null;
 	  HttpSession ss=request.getSession();
 	  String y=(String)ss.getAttribute("user");
 	  System.out.println("View request y="+y);
      RequestDao ld=new RequestDao();
	ArrayList<Asset> list=ld.viewReq(y);
 	    mv=new ModelAndView("ViewRequest");
 		 mv.addObject("LIST", list);
 	  
 	  return mv;
   }
	
  @RequestMapping("/ViewProfile")
  protected ModelAndView viewProfile(HttpServletRequest request)
  {
  	ModelAndView mv=null;
  	 HttpSession ss=request.getSession();
    	  String y=(String)ss.getAttribute("user");
    	  //System.out.println(y);
  	EmpDao ed=new EmpDao();
  	ArrayList<Employee>list=ed.viewProfile(y);
  	mv=new ModelAndView("ViewProfile");
  	mv.addObject("LIST", list);
  	
  	
  	return mv;
  }
  
  @RequestMapping("/controller")
  protected ModelAndView result(HttpServletRequest request)
  {System.out.println("helooooooooo");
  	ModelAndView mv=null;
  	HttpSession ss=request.getSession();
  	String eid=(String)ss.getAttribute("user");
  	EmpDao ed=new EmpDao();
       ArrayList<Employee>list=ed.viewEmUpdate(eid);
       mv=new ModelAndView("updEmp");
       mv.addObject("LIST", list);
  	return mv;
  	
  	
  }
  
  @RequestMapping("/changePass")
  protected ModelAndView newpass()
  {
  	
  	ModelAndView mv=new ModelAndView("changePassword");
  	
  	return mv;
  	
  	
  }
  
  
  @RequestMapping("/changePassword")
  protected ModelAndView chndpwd(@RequestParam("current")String current,@RequestParam("new") String New,@RequestParam("confirm")String confirm )
  {
  	ModelAndView mv=null;
  	
  	 EmpDao ed=new EmpDao();
  	 int y=ed.chngPass(current,New,confirm);
  	 if(y==1)
  	 {
  		 mv=new ModelAndView("changePassword");
  		 mv.addObject("change", "Password Change");
  		 
  		 
  	 }
  	 else
  	 {
  		 mv=new ModelAndView("changePassword");
  		 mv.addObject("chng", "Failed,Current Password Doesnt Match");
  	 }
  	return mv;
  }

  @RequestMapping("/FetchData")
  protected ModelAndView data(@RequestParam("assetname") String assetname)
  {
  	String x="";
  	ModelAndView mv=null;
  	EmpDao ed=new EmpDao();
  	String y=ed.getAssetid(assetname);
  	System.out.println(y);
	    	if(y!=null)
	    	{
	    	x=x+y;
	    	//System.out.println("Aaa gyi x mai"+x);
	    	mv=new ModelAndView("getassetid");
	    			mv.addObject("value", x);
	    	}
//	    	else {
//	    		String s="No Content";
//	    		
//	    		return s;
//	    	}
	    	return mv;
  }
  
  @RequestMapping("/viewa")	
 	public ModelAndView viewa(HttpServletRequest request) 
 	{
 		ModelAndView mv=null;
 		EmpDao ed=new EmpDao();
 		HttpSession ss=request.getSession();
 		String user1=(String)ss.getAttribute("user");
 		System.out.println(user1);
 		ArrayList<Employee> list=ed.viewmanagerprofile(user1);
 		mv=new ModelAndView("managerprofile");
 		mv.addObject("LIST", list);
 	return mv;		
 	}
   
   @RequestMapping("/Mupdatepassword")
 	public ModelAndView opreation(HttpServletRequest request)
 	{
 	ModelAndView mv=null;
 	EmpDao ed=new EmpDao();
 	HttpSession ss=request.getSession();
 	String user1=(String)ss.getAttribute("user");
 	Employee a1=new Employee();
 	a1=ed.Mupdatepassword(user1);
 	mv=new ModelAndView("ManagerupdatePassword");
 	mv.addObject("LIST", a1);
 	return mv;
 	}
   
   @RequestMapping("/Manageropreation")
 	public ModelAndView confirmupdate(@ModelAttribute("Employee") Employee a1)
 	{
 		ModelAndView mv=null;
 		
     	EmpDao ed=new EmpDao();
// 		HttpSession ss=request.getSession();
// 		String user1=(String)ss.getAttribute("user");
 		int y=ed.Managerupdateinsert(a1);
 		if(y!=0)
 		{
 			mv=new ModelAndView("ManagerupdatePassword");
 			mv.addObject("msg", "password successfully changed");
 		}
 		else
 		{
 			mv=new ModelAndView("ManagerupdatePassword");	
 		mv.addObject("msg", "try again");
 		}
 		return mv;
 	}
   
   @RequestMapping("/Managercreate")	
   public ModelAndView McreateR() 
   {
      ModelAndView mv=new ModelAndView("ManagerCreateRequest");
 		mv.addObject("msg", "Manager Create Request");
 		return mv;
 	}
 	@RequestMapping("/InsertManager")
 	//public ModelAndView create(@RequestParam String uid, @RequestParam String name,@RequestParam String salary,@RequestParam String mobile,@RequestParam String email) 
 	public ModelAndView McreateR(@ModelAttribute("Employee") Employee e1)
 	{
 	        ModelAndView mv=null;
 	        
 	        EmpDao ed=new EmpDao();
 			//int y=ed.MinsertRequest(e1);
 			if(y!=0)
 			{
 				mv=new ModelAndView("ManagerCreateRequest");
 				mv.addObject("msg", "data inserted");
 			}
 			else
 			{
 				mv=new ModelAndView("ManagerCreateRequest");	
 			    mv.addObject("msg", "try again");
 			}
 			return mv;
 	}
 	@RequestMapping("/Mviewrequest")
 	public ModelAndView MviewR(ModelAndView response) 
 	{
 		ModelAndView mv=null;
 		EmpDao ed=new EmpDao();
 		ArrayList<Employee> list=ed.MviewRequest();
 		mv=new ModelAndView("ManagerViewRequest");
 		mv.addObject("LIST", list);
 	return mv;		
 	}
 	@RequestMapping("/managerasset")	
 	public ModelAndView viewmyasset(ModelAndView response) 
 	{
 		ModelAndView mv=null;
 		EmpDao ed=new EmpDao();
 		ArrayList<Employee> list=ed.viewmanagerasset();
 		mv=new ModelAndView("viewmanagerasset");
 		mv.addObject("LIST", list);
 	return mv;			

 	}
 	@RequestMapping("/viewMallemployee")	
 	public ModelAndView viewallemployee(HttpServletRequest request) 
 	{
 		ModelAndView mv=null;
 		HttpSession ss=request.getSession();
 		String user1=(String)ss.getAttribute("user");
 		System.out.println(user1);
 		EmpDao ed=new EmpDao();
 		ArrayList<Employee> list=ed.viewMallemployee(user1);
 		mv=new ModelAndView("viewManagerEmployee");
 	    mv.addObject("LIST", list);
 		
 		return mv;
 	}
}