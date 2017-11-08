package beans;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Request {

	   @Id
	   @GeneratedValue
	    String requestid;
  		String assetid;
		String assetname;
	   // @Transient
		String requestdate;
		String designation;
		String eid1;
		String eid2;
		String mid1;
		String mid2;
		String sid;
		   int status;
		   
		   
		@Override
		public String toString() {
			return "Request [requestid=" + requestid + ", assetid=" + assetid + ", assetname=" + assetname
					+ ", requestdate=" + requestdate + ", designation=" + designation + ", eid1=" + eid1 + ", eid2="
					+ eid2 + ", mid1=" + mid1 + ", mid2=" + mid2 + ", sid=" + sid + ", status=" + status + "]";
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



