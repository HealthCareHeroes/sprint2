package edu.uncc.ssdi.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uncc.ssdi.model.MedicalHistory;
import edu.uncc.ssdi.service.MedicalService;

@RestController
@RequestMapping("/")
public class MedicalRecordController {
	@Autowired
	private MedicalService medService;
	
	@RequestMapping(value="/history/{id}", method = RequestMethod.GET) // Map ONLY GET Requests
	public @ResponseBody List<MedicalHistory>  getAllRecords (@PathVariable Long id) {
	
		return  medService.getHistory(id);
	}
	
} // end of class