package edu.uncc.ssdi.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.uncc.ssdi.dao.PermDao;
import edu.uncc.ssdi.model.Permission;
import edu.uncc.ssdi.model.User;

@Service("permService")
public class PermServiceImpl implements PermService {

	@Autowired
	private PermDao permDao;
	
	@Autowired
	private UserServiceImpl userService;
	
	
	
	@Override
	public int grantPermission(Permission permObject) {
	
		System.out.println("grant" + permObject.getId());
		Double d = Double.parseDouble(permObject.getId());
		Long access_id = d.longValue();
	//	Long access_id = Long.parseLong(permObject.getId());
		
		User userObject = userService.findById(access_id);
		permObject.setId( userObject.getDigitalId() );
		return permDao.givePermission(permObject);
	}



	@Override
	public List<Permission> getAllRequests(Long id) {

		User userObject = userService.findById(id);
		String digitalId =  userObject.getDigitalId() ;
		
		return  permDao.getAllRequests(digitalId);
	}

} // end of class