package beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Asset {
	@Id
	String assetid;
	String assetname;
	int status;
	
	
	
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
