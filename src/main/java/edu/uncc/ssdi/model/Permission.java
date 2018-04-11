package edu.uncc.ssdi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Permission {

	@Id
	private String accessId;
	
	private long accessByUserId;
	
	private int status;

	public String getAccessId() {
		return accessId;
	}

	public void setAccessId(String accessUserId) {
		this.accessId = accessUserId;
	}

	public long getAccessByUserId() {
		return accessByUserId;
	}

	public void setAccessByUserId(long accessByUserId) {
		this.accessByUserId = accessByUserId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


	
	
	
	
}
