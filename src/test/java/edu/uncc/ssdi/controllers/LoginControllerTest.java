package edu.uncc.ssdi.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.memorynotfound.config.WebConfig;

import edu.uncc.ssdi.model.Login;
import edu.uncc.ssdi.service.UserService;
import mockit.Expectations;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class})
public class LoginControllerTest {


	private MockMvc mockMvc;

    @InjectMocks
    private LoginController login_Controller = new LoginController();
    

    @Mock
    private UserService userService;
    

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		//  this.mock_mvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
		
		 this.mockMvc = MockMvcBuilders.standaloneSetup(login_Controller).build();
	}
	

	
	@Test
	public void  testLoginProcess() throws Exception{
		
		Login login = new Login();
		login.setUserName("sample@uncc.edu");
		login.setPassword("sample123");
		login.setRole(1);
		
		new Expectations() {{
			 userService.validateUser(login);
		}};

	mockMvc.perform(MockMvcRequestBuilders.post("/validateLogin/").contentType(MediaType.APPLICATION_JSON)
					.param("email", "sample@uncc.edu")
					.param("password", "sample123")
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());
			

			
	}
	
	
	
}
