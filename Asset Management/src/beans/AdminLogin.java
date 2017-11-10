package beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdminLogin {
	@Id
	String userid;
	String password;
	String email;
	
	public String getUserid() {
		return userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
