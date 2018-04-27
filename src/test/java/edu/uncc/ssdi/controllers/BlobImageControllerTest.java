package edu.uncc.ssdi.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import edu.uncc.ssdi.model.BlobFileStorage;
import edu.uncc.ssdi.service.BlobService;



public class BlobImageControllerTest {


	private MockMvc mockMvc;
	
	@Mock
	private BlobService blobService;

	private List<BlobFileStorage> listFile;
	
	@InjectMocks
	BlobImageController blobController;
	
	private long id = 10011;
	
	@Mock
	Blob tempImage;
	
	@Mock
	HttpServletResponse response;
	
    @Before
	public void setup() {
	
		
		MockitoAnnotations.initMocks(this);
	
		this.mockMvc = MockMvcBuilders.standaloneSetup(blobController).build();
		
		listFile = new ArrayList<BlobFileStorage>();
		BlobFileStorage b1 = new BlobFileStorage(900, "des1", "filename1", null, "contentType1", null);
		BlobFileStorage b2 = new BlobFileStorage(901, "des2", "filename2", null, "contentType2", null);
				
		listFile.add(b1);
		listFile.add(b2);
		
	}
    
    
	
	@Test
	public void showFilesTest() throws Exception {
	     Mockito.when(blobService.findByMedId(id)).thenReturn(listFile);
		 mockMvc.perform(get("/getStorageFile/{id}",id)).andExpect(status().isOk())
		.andExpect(jsonPath("$[0].filename", is(listFile.get(0).getFilename() )))
		 .andExpect(jsonPath("$[0].description", is( listFile.get(0).getDescription() ))).andExpect(jsonPath("$[0].contentType", is( listFile.get(0).getContentType() )))
		 .andExpect(jsonPath("$[1].filename", is(listFile.get(1).getFilename() )))
		 .andExpect(jsonPath("$[1].description", is( listFile.get(1).getDescription() ))).andExpect(jsonPath("$[1].contentType", is( listFile.get(1).getContentType() )));
		 
		 Mockito.verify(blobService, times(1)).findByMedId(id);
		 verifyNoMoreInteractions(blobService);
		 
	}
	
	
	@Test
	public void getImageTest() throws Exception {
		
		String example = "This is an example";
	    byte[] bytes = example.getBytes();
	    int len = (int) tempImage.length();
		
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(output));

		
		when(response.getWriter()).thenReturn(printWriter);
		when(blobService.getContent(id)).thenReturn(tempImage);
		when(tempImage.getBytes(1,len)).thenReturn(bytes);
		

		 mockMvc.perform(get("/getImage/{id}",id, response))
		 .andExpect(status().isOk());
		 
		 Mockito.verify(blobService, times(1)).getContent(id);
	//	 Mockito.verify(response).getWriter();
		//assertEquals("result", new String(output.toByteArray(), "UTF-8"));
		
	}
}
