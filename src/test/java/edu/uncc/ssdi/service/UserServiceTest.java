package edu.uncc.ssdi.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import edu.uncc.ssdi.model.User;
import edu.uncc.ssdi.repositories.*;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	private UserServiceImpl userServiceImpl;
	
/*	@Bean
	public UserRepository todoService() {
	        return Mockito.mock(UserRepository.class);}
	
	@Bean
	private Systems todoService1() {
        return Mockito.mock(Systems.class);}
	*/
	
	@Mock
	private Systems sysObject;
	
	@Mock
	public UserRepository userRepository;
	
	
	@Mock
	private User testUser;
	
	//@InjectMocks
	
	@Before
	public void setUp()
	{
	    MockitoAnnotations.initMocks(this);
	    userServiceImpl = new UserServiceImpl();
	    userServiceImpl.setUserRepository(userRepository);	    
	}
	
	// Testing Data Field
	long id = 10000;

	
	@Test
	public void testSaveUser() {
		
        // Arrange       
        when(userRepository.save(testUser)).thenReturn(testUser);
        // Act         
        User savedUser = userServiceImpl.saveUser(testUser);
        //// Assert
        
        
        assertEquals(savedUser, testUser);
       
    }
	
	
	@Test
	public void testUserfindById() {
		// Arrange     
        when(userRepository.findOne(id)).thenReturn(testUser);
        // Act    
        User user = userServiceImpl.findById(id);
        // Assert    
        assertEquals(user, testUser);
		
	}
	
	
	
	
	
}
