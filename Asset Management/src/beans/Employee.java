package beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {
@Id
@GeneratedValue
int eid;
String eid1;
String eid2;
String name;
String address;
String email;
long mobile;
String password;
String designation;
String mid1;
String mid2;
String sid;
String dateofjoin;
int status;


@Override
public String toString() {
	return "Employee [eid1=" + eid1 + ",eid2=" + eid2 + ", name=" + name + ", address=" + address + ", email=" + email + ", mobile="
			+ mobile + ", password=" + password + ", designation=" + designation + ", mid1=" + mid1 + ", mid2=" + mid2 + ", sid=" + sid
			+ ", dateofjoin=" + dateofjoin + ", status=" + status + "]";
}


public String getEid1() {
	return eid1;
}


public void setEid1(String eid1) {
	this.eid1 = eid1;
}


public String getEid2() {
	return eid2;
}


public void setEid2(String eid2) {
	this.eid2 = eid2;
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


public String getMid1() {
	return mid1;
}


public void setMid1(String mid1) {
	this.mid1 = mid1;
}


public String getMid2() {
	return mid2;
}


public void setMid2(String mid2) {
	this.mid2 = mid2;
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


public int getStatus() {
	return status;
}


public void setStatus(int status) {
	this.status = status;
}


}