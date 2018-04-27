package edu.uncc.ssdi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import edu.uncc.ssdi.model.BlobFileStorage;
import edu.uncc.ssdi.model.User;



@Transactional
public interface BlobRepository extends CrudRepository<BlobFileStorage, Long> {
		
	List<BlobFileStorage> findByMedId(long id);
}
