package beans;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Request {

	   @Id
	   @GeneratedValue
	    String requestid;
  		String assetid;
		String assetname;
		String requestdate;
		String designation;
		String eid;
		String mid;
		   int status;
		   
		   
		public String getMid() {
			return mid;
		}
		public void setMid(String mid) {
			this.mid = mid;
		}
		public String getEid() {
			return eid;
		}
		public void setEid(String eid) {
			this.eid = eid;
		}
		public String getRequestid() {
			return requestid;
		}
		public void setRequestid(String requestid) {
			this.requestid = requestid;
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
		public String getRequestdate() {
			return requestdate;
		}
		public void setRequestdate(String requestdate) {
			this.requestdate = requestdate;
		}
		public String getDesignation() {
			return designation;
		}
		public void setDesignation(String designation) {
			this.designation = designation;
		}
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}

	}



