package edu.uncc.ssdi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.uncc.ssdi.model.Login;
import edu.uncc.ssdi.model.User;

@Service
public interface UserService {
	
	User findById(Long id);

	List<User> findByEmail(String email);
	
	List<User> findByDigitalId(String name);
	
	List<User> findByRole(String role);

	User saveUser(User user);

	void updateUser(User user);

	void deleteUserById(Long id);

	void deleteAllUsers();

	List<User> findAllUsers();

	boolean isUserExist(User user);

	User validateUser(Login login);

	User validateEmail(String email);
}