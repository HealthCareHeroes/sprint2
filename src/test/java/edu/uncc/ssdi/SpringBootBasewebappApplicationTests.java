package edu.uncc.ssdi;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

public class SpringBootBasewebappApplicationTests {
	
	@Test
	public void contextLoads() {
		//Collection collection = new ArrayList();
		//assertTrue(collection.isEmpty());
		ArrayList arrayList = mock(ArrayList.class);
        // program the mock object to return "hello world" when get(0) is called
        given(arrayList.get(0)).willReturn("Mock- Health Care Heroes");
 
        // this will output "hello world", since that was what the mock object was told to return
        System.out.println(arrayList.get(0));
		
	}

	@Test
	public void testEmptyCollection() {
		//System.out.println("Test Case 1");

		Collection collection = new ArrayList();
		assertTrue(collection.isEmpty());
	}
	
	@Test
	public void createUser() throws Exception {
		/*User mockUser = new User("1", "Smallest Number", "1",
				Arrays.asList("1", "2", "3", "4"));

		// studentService.addCourse to respond back with mockCourse
		Mockito.when(
				studentService.addCourse(Mockito.anyString(),
						Mockito.any(Course.class))).thenReturn(mockCourse);

		// Send course as body to /students/Student1/courses
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/students/Student1/courses")
				.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

		assertEquals("http://localhost/students/Student1/courses/1",
				response.getHeader(HttpHeaders.LOCATION));
*/
	}
	
	
	
	  public static junit.framework.Test suite() {
	        return new junit.framework.JUnit4TestAdapter(SpringBootBasewebappApplicationTests.class);
	    }
	  
	  public static void main(String args[]) {
	      org.junit.runner.JUnitCore.main("hello.SpringBootBasewebappApplicationTests");
	    }
}