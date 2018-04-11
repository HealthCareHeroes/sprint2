package edu.uncc.ssdi.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.uncc.ssdi.model.Login;
import edu.uncc.ssdi.model.Permission;
import edu.uncc.ssdi.service.PermService;
import mockit.Expectations;

public class PermissionControllerTest {

	private MockMvc mockMvc;

    @InjectMocks
    private PermissionController perm_Controller = new PermissionController();
    

    @Mock
    private PermService permService;
    
    private ObjectMapper obj_mapper;
    
	@Before
	public void setup() {
		
		
		obj_mapper = new ObjectMapper();
		
		MockitoAnnotations.initMocks(this);
		//  this.mock_mvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
		
		 this.mockMvc = MockMvcBuilders.standaloneSetup(perm_Controller).build();
	}
	

	@Test
	public void givePermission() throws Exception{
		
		Permission permObject = new Permission();
		permObject.setId("08d556ea1-1df5-4f2e-919c-1348135f1419");
		permObject.setAccessByUserId((long)10002);
		permObject.setStatus(4);
		
		new Expectations() {{
			permService.grantPermission(permObject);
		}};

	mockMvc.perform(MockMvcRequestBuilders.post("/givePermission/").contentType(MediaType.APPLICATION_JSON)
					.param(obj_mapper.writeValueAsString(permObject))
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());
		

		
	
	}
	
	
	
	@Test
	public void  getAllRequestTest() throws Exception{
		
		
		
		Permission permObject = new Permission();
		permObject.setId("08d556ea1-1df5-4f2e-919c-1348135f1419");
		permObject.setAccessByUserId((long)10002);
		permObject.setStatus(4);
		
		new Expectations() {{
			permService.getAllRequests((long)10011);
		}};
		//return (List<Permission>) permService.getAllRequests(id);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/permissionRequests/{id}").contentType(MediaType.APPLICATION_JSON)
				.param("id", "10002")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		
	}
	
	
	

	
}
