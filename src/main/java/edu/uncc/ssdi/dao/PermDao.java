package edu.uncc.ssdi.dao;

import java.util.List;

import edu.uncc.ssdi.model.Permission;

public interface PermDao {

	int givePermission(Permission permObject) ;

	List<Permission> getAllRequests(String digitalId);
	
	
}
