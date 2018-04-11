package edu.uncc.ssdi.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.uncc.ssdi.dao.PermDao;
import edu.uncc.ssdi.model.Permission;

@Service("permService")
public class PermServiceImpl implements PermService {

	@Autowired
	private PermDao permDao;
	
	@Override
	public int grantPermission(Permission permObject) {
		
		return permDao.givePermission(permObject);
	}

} // end of class