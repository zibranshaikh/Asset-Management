package beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
@Id
String eid;
String name;
String address;
String email;
long mobile;
String password;
String designation;
String mid;
String sid;
String dateofjoin;
int status;


@Override
public String toString() {
	return "Employee [eid=" + eid + ", name=" + name + ", address=" + address + ", email=" + email + ", mobile="
			+ mobile + ", password=" + password + ", designation=" + designation + ", mid=" + mid + ", sid=" + sid
			+ ", dateofjoin=" + dateofjoin + ", status=" + status + "]";
}
public String getSid() {
	return sid;
}
public void setSid(String sid) {
	this.sid = sid;
}



public String getDateofjoin() {
	return dateofjoin;
}

public void setDateofjoin(String dateofjoin) {
	this.dateofjoin = dateofjoin;
}


public String getEid() {
	return eid;
}

public void setEid(String eid) {
	this.eid = eid;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public long getMobile() {
	return mobile;
}

public void setMobile(long mobile) {
	this.mobile = mobile;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getDesignation() {
	return designation;
}

public void setDesignation(String designation) {
	this.designation = designation;
}

public String getMid() {
	return mid;
}

public void setMid(String mid) {
	this.mid = mid;
}

public int getStatus() {
	return status;
}

public void setStatus(int status) {
	this.status = status;
}


}