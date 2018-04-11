package edu.uncc.ssdi.service;


import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository
public class SystemImpl implements Systems{

	

	
	@Override
	public String generateDigitalProfileKey(long id) {
		// TODO Auto-generated method stub
	
			return  UUID.randomUUID().toString();
		
		
	
	}
	
	

}
