package edu.uncc.ssdi.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uncc.ssdi.model.MedicalHistory;
import edu.uncc.ssdi.repositories.MedicalRepository;

@RestController
@RequestMapping("/")
public class MedicalRecordController {
	@Autowired
	private MedicalRepository medRepository;
	
	@RequestMapping(value="/history", method = RequestMethod.GET) // Map ONLY GET Requests
	public @ResponseBody List<MedicalHistory>  getAllRecords () {
	System.out.println("test history");
		return (List<MedicalHistory>) medRepository.findAll();
	}
	
} // end of class