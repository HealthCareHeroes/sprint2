package edu.uncc.ssdi.service;

import java.sql.Blob;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.uncc.ssdi.model.BlobFileStorage;
@Service
public interface BlobService {

	List<BlobFileStorage> findByMedId(Long id);
	Blob getContent(Long id);
}
