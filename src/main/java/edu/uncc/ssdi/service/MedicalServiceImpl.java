package edu.uncc.ssdi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uncc.ssdi.model.MedicalHistory;
import edu.uncc.ssdi.model.User;
import edu.uncc.ssdi.repositories.MedicalRepository;
import edu.uncc.ssdi.repositories.UserRepository;

@Service("medService")
public class MedicalServiceImpl implements MedicalService{
	@Autowired
	private MedicalRepository medRepository;
	@Autowired
	private UserServiceImpl userService;
	@Override
	public List<MedicalHistory> getHistory(Long id) {
		

		User userObject = userService.findById(id);
		List<MedicalHistory> temp =  medRepository.findByDigitalId(userObject.getDigitalId());
		 
		 return temp;
	}

	

    @Autowired
    public void setMedicalRepository(MedicalRepository medRepository) {
        this.medRepository = medRepository;
        
    }
    
    @Autowired
    public void setMedicalServiceImpl(UserServiceImpl userService) {
        this.userService = userService;
        
    }
}
