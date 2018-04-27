package edu.uncc.ssdi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.uncc.ssdi.model.MedicalHistory;

@Service
public interface MedicalService {

	public List<MedicalHistory> getHistory(Long id);
}
