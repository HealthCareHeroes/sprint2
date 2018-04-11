package edu.uncc.ssdi.dao;
import edu.uncc.ssdi.model.Login;
import edu.uncc.ssdi.model.User;

public interface UserDao {
	User validateUser(Login User);
	User validateEmail(String email);
} // end of class