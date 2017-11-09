package beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Asset {
	@Id
	String assetid;
	String assetname;
	String eid1;
	String eid2;
	String mid1;
	String mid2;
	int status;
	
	
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
	public String getAssetid() {
		return assetid;
	}
	public void setAssetid(String assetid) {
		this.assetid = assetid;
	}
	public String getAssetname() {
		return assetname;
	}
	public void setAssetname(String assetname) {
		this.assetname = assetname;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

}
