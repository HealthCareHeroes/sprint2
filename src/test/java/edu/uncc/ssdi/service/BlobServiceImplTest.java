package edu.uncc.ssdi.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import edu.uncc.ssdi.model.BlobFileStorage;
import edu.uncc.ssdi.repositories.BlobRepository;

public class BlobServiceImplTest {

	@Mock
	private UserServiceImpl userService;
	
	@Mock
	private BlobRepository blobRepository;
	
	private BlobServiceImpl blobServiceImpl;
	
	private List<BlobFileStorage> sList;
	
	@Before
	public void setup() {
		sList = new ArrayList<BlobFileStorage>();

		blobServiceImpl = new BlobServiceImpl();

		blobServiceImpl.setBlobRepo(blobRepository);
	}
	
	@Test
	public void findByMedIdTest(){
		
		long id = 1011;
		
		Mockito.when(blobRepository.findByMedId(id)).thenReturn(sList);
		List<BlobFileStorage> list = blobServiceImpl.findByMedId(id);
		
		assertEquals(true, true);
	}


	@Test
	public void getContent() {

		
	}

	
	
}
