package edu.uncc.ssdi.controllers;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@WebMvcTest(value = LoginController.class, secure = false)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginControllerTest {
	// Anurag - TO DO
	
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext wac;
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	@Test
	public void loginProcessTest() throws Exception {
		
	}
	
	
} // end of class