package edu.uncc.ssdi.repositories;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import edu.uncc.ssdi.model.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
	
	//	@Query("SELECT a FROM user a WHERE a.email=:email")
//	   List<User> fetchArticles(@Param("email") String email, @Param("category") String category);
	List<User> findByEmail(String email);
	List<User> findByDigitalId(String name);
	List<User> findByRole(String role);
}

