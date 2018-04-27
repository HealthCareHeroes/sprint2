package edu.uncc.ssdi.service;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uncc.ssdi.model.BlobFileStorage;
import edu.uncc.ssdi.model.User;
import edu.uncc.ssdi.repositories.BlobRepository;
@Service("blobService")
public class BlobServiceImpl implements BlobService{

	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private BlobRepository blobRepository;
	
	
	
	public List<BlobFileStorage> findByMedId(Long id){
		
		 List<BlobFileStorage> bList = new ArrayList<BlobFileStorage>();

	//	 bList = new ArrayList<BlobFileStorage>();
	//	User userObject = userService.findById(id);
	//	 userObject.getDigitalId();
		 List<BlobFileStorage> list=  blobRepository.findByMedId(id);
		 
		 
		 for(BlobFileStorage b :list ) {
			 
			 b.setContent(null);
			 bList.add(b);
			
		 }
		 return bList;
	}


	@Override
	public Blob getContent(Long id) {

		BlobFileStorage obj  = blobRepository.findOne(id);
		return obj.getContent();
	}


	public void setBlobRepo(BlobRepository blobRepository) {

		this.blobRepository = blobRepository;
	}


}
