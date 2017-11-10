package beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AllotedAsset {
	
	@Id
	@GeneratedValue
    int allotid;
	String assetid;
	String assetname;
	String eid1;
	String mid1;
	String mid2;
	int status;
	
	
	@Override
	public String toString() {
		return "AllotedAsset [allotid=" + allotid + ", assetid=" + assetid + ", assetname=" + assetname + ", eid1="
				+ eid1 + ", mid1=" + mid1 + ", mid2=" + mid2 + ", status=" + status + "]";
	}
	
	public int getAllotid() {
		return allotid;
	}

	public void setAllotid(int allotid) {
		this.allotid = allotid;
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
	public String getEid1() {
		return eid1;
	}
	public void setEid1(String eid1) {
		this.eid1 = eid1;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	
	
}
