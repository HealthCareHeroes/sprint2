package edu.uncc.ssdi.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import edu.uncc.ssdi.model.MedicalHistory;
import edu.uncc.ssdi.repositories.MedicalRepository;
import edu.uncc.ssdi.service.MedicalService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MedicalRecordsControllerTest {

	private MockMvc mockMvc;
	
	@Mock
	private MedicalService medService;

	@Mock
	List<MedicalHistory> listRecords;
	
	@InjectMocks
	MedicalRecordController medController;
	
    @Before
	public void setup() {
	
		
		MockitoAnnotations.initMocks(this);
	
		this.mockMvc = MockMvcBuilders.standaloneSetup(medController).build();
	}
    
	@Test
	public void getAllRecordsTest() throws Exception {
	
		Long id = (long) 10011;
		
		Date dt =new Date(0);
		
		MedicalHistory hist1 = new MedicalHistory(id,"0",dt,dt,"11","21","31","41","52");
		MedicalHistory hist2 = new MedicalHistory(id,"1",dt,dt,"12","22","32","42","52");
		
		listRecords = new ArrayList<MedicalHistory>();
		listRecords.add(hist1);
		listRecords.add(hist2);
		
		 Mockito.when(medService.getHistory(id)).thenReturn(listRecords);
		 
		 mockMvc.perform(get("/history/{id}",id)).andExpect(status().isOk())
		 .andExpect(jsonPath("$[0].hospitalName", is(hist1.getHospitalName()))).andExpect(jsonPath("$[0].doctorName", is(hist1.getDoctorName())))
		 .andExpect(jsonPath("$[0].purposeOfVisit", is(hist1.getPurposeOfVisit()))).andExpect(jsonPath("$[0].releaseStatus", is(hist1.getReleaseStatus())))
		 .andExpect(jsonPath("$[1].hospitalName", is(hist2.getHospitalName()))).andExpect(jsonPath("$[1].doctorName", is(hist2.getDoctorName())))
		 .andExpect(jsonPath("$[1].purposeOfVisit", is(hist2.getPurposeOfVisit()))).andExpect(jsonPath("$[1].releaseStatus", is(hist2.getReleaseStatus())));		
		 Mockito.verify(medService, times(1)).getHistory(id);
		 verifyNoMoreInteractions(medService);
	}
}
