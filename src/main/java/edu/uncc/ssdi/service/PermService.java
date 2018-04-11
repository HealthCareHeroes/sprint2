package edu.uncc.ssdi.service;

import org.springframework.stereotype.Service;

import edu.uncc.ssdi.model.Permission;

@Service
public interface PermService {

	int grantPermission( Permission permObject);
	
	
}
