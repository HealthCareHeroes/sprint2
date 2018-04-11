package edu.uncc.ssdi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.uncc.ssdi.model.Permission;

@Service
public interface PermService {

	int grantPermission( Permission permObject);

	List<Permission> getAllRequests(Long id);
	
	
}
