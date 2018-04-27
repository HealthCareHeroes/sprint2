package edu.uncc.ssdi.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import edu.uncc.ssdi.model.MedicalHistory;
import edu.uncc.ssdi.model.User;
import edu.uncc.ssdi.repositories.MedicalRepository;
import edu.uncc.ssdi.repositories.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MedicalServiceImplTest {

	private MedicalServiceImpl mService;
	
	@Mock
	List<MedicalHistory> listRecords;
	
	@Mock
	public MedicalRepository medRepository;
	
	@Mock
	public UserServiceImpl userServiceImpl;
	
	@Mock
	User sampleUser;
	@Before
		public void setup() {
		
		MockitoAnnotations.initMocks(this);
		mService = new MedicalServiceImpl();
		mService.setMedicalRepository(medRepository);
		mService.setMedicalServiceImpl(userServiceImpl);
		
			
	   
	   }
	    
	
	
	@Test
	public void test() {
		
		Long id = (long) 10011;
		
		Date dt =new Date(0);
		
		String digitalId = "sampleId";
		//Long id =  (long)10011;
		User userTest = new User();
		userTest.setDigitalId(digitalId);
		
		
		Mockito.when(sampleUser.getDigitalId()).thenReturn(digitalId);
		Mockito.when(userServiceImpl.findById(id)).thenReturn(sampleUser);
		Mockito.when(medRepository.findByDigitalId(sampleUser.getDigitalId() )).thenReturn(listRecords);
		
		List<MedicalHistory> mHistory = mService.getHistory(id);
		assertEquals(listRecords,mHistory);
	
		
	
	}
	
}
