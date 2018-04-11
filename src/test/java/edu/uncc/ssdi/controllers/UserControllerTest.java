package edu.uncc.ssdi.controllers;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@WebMvcTest(value = UserController.class, secure = false)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;
	
 @Before
 public void setup() {
	 this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
 }
 
 
 @Test
 public void verifyGetAllUsers() throws Exception{
	 mockMvc.perform(MockMvcRequestBuilders.get("/getUsers").accept(MediaType.APPLICATION_JSON))
	 		.andExpect(jsonPath("$", hasSize(15))).andDo(print());
 }
 
	@Test
	public void addNewUserTest() throws Exception{
	
		mockMvc.perform(MockMvcRequestBuilders.post("/addNewUser/").contentType(MediaType.APPLICATION_JSON)
				.content("{\"email\" : \"sample@uncc.edu\", \"password\" : \"sample123\" }")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.email").exists())
				.andExpect(jsonPath("$.password").exists())
				.andDo(print());
				
	}


	 @Test
	public void verifyGetUser() throws Exception{
		 mockMvc.perform(MockMvcRequestBuilders.get("/getUser/3").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.id").exists())
			.andExpect(jsonPath("$.email").exists())
			.andExpect(jsonPath("$.password").exists())
			.andExpect(jsonPath("$.id").value(3))
			.andDo(print());
	}


	@Test
	public void verifyUpdateUser() throws Exception{

		mockMvc.perform(MockMvcRequestBuilders.patch("/updateUser/3")
		        .contentType(MediaType.APPLICATION_JSON)
		        .content("{ \"id\": \"3\", \"email\" : \"sample@uncc.edu\", \"password\" : \"check123\" }")
		        .accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.email").exists())
				.andExpect(jsonPath("$.password").exists())
				.andExpect(jsonPath("$.id").value(3))
				.andExpect(jsonPath("$.text").value("sample@uncc.edu"))
				.andExpect(jsonPath("$.completed").value("check123"))
				.andDo(print());
	}

}
