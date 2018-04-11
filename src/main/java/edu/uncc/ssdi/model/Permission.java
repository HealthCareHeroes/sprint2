package edu.uncc.ssdi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Permission {

	@Id
	private String id;
	
	private long accessByUserId;
	
	private int status;

	
	public Permission() {
	
	}
	
	
	
	public Permission(String id, long accessByUserId, int status) {
		super();
		this.id = id;
		this.accessByUserId = accessByUserId;
		this.status = status;
	}

	

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
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
