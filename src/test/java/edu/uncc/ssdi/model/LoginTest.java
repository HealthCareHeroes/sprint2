package edu.uncc.ssdi.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import mockit.Verifications;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
@SpringBootTest
public class LoginTest {

	private Login testLogin;


	
	@Test
	 public void testGetUserName() { 
		
		testLogin = new Login();
		testLogin.setUserName("User1");
		  
			new Verifications() {
				{

					assertEquals("User1", testLogin.getUserName());
				}
			};
		
	}
	 

	@Test
	public void testSetUserName() {
		testLogin = new Login();

		new Verifications() {
			{

				assertEquals(null, testLogin.getUserName());
			}
		};

		this.testLogin.setUserName("Test");

		new Verifications() {
			{

				assertEquals("Test", testLogin.getUserName());
			}
		};
	}

	
	@Test
	  public void testGetPassword() { 
		 
		 Login getlogin = new Login();
		 getlogin.setPassword("pwd123");
		  
			new Verifications() {
				{

					assertEquals("pwd123", getlogin.getPassword());
				}
			};
		  
		  
		 
		  
	  }
	 
	public void testSetPassword() {
		
		testLogin = new Login();

		new Verifications() {
			{

				assertEquals(null, testLogin.getPassword());
			}
		};

		this.testLogin.setPassword("password123");

		new Verifications() {
			{

				assertEquals("password123", testLogin.getPassword());
			}
		};
		
	
		
	}
	
	 public void testGetRole() {
		 
		 Login getlogin = new Login();
		 getlogin.setRole(1);
		  
			new Verifications() {
				{

					assertEquals(1, getlogin.getRole());
				}
			};
		 
	 
	 
	 }
	 
	 public void testSetRole() { 
		 
			testLogin = new Login();

			new Verifications() {
				{

					assertEquals(null, testLogin.getRole());
				}
			};

			this.testLogin.setRole(1);;

			new Verifications() {
				{

					assertEquals(1, testLogin.getRole());
				}
			};
			
	 
	 }
	 
	
}
