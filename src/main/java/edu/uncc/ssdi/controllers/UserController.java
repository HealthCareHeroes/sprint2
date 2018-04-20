package edu.uncc.ssdi.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import edu.uncc.ssdi.model.User;
import edu.uncc.ssdi.repositories.UserRepository;
import edu.uncc.ssdi.service.UserService;
import edu.uncc.ssdi.util.CustomErrorType;
import java.util.List;
@RestController
@RequestMapping("/")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userService; // Service which will do all data retrieval/manipulation work
	@RequestMapping(value = "/adduser/", method = RequestMethod.POST) // Map ONLY GET Requests
	public @ResponseBody User addNewUser(@RequestParam String email, @RequestParam String password,
			@RequestParam String firstName, @RequestParam String lastName) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		// Add the user to the database
		User u = new User();
		u.setEmail(email);
		u.setPassword(password);
		u.setFirstName(firstName); 
		u.setLastName(lastName);
		User retUser = userService.saveUser(u);
		return retUser;
	}
	
	// not used in Sprint 1 or 2
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET) // Map ONLY GET Requests
	public @ResponseBody List<User> getAllUsers() {
		
		return (List<User>) userService.findAllUsers();
	}
	
	@RequestMapping(value = "/getUsers/{role}", method = RequestMethod.GET) // Map ONLY GET Requests
	public @ResponseBody List<User> getAllDoctors(@PathVariable("role") String role) {
		
		return (List<User>) userService.findByRole(role);
	}
	
	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
		User user = userService.findById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/checkEmail/{email:.+}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("email") String email) {
		User user = null;
		try {
			// user = userService.validateEmail(email);
			user = userService.findByEmail(email).get(0);
		} catch (Exception ex) {
			// return "User not found";
			System.out.println("Error: User NOT found.");
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	// @Transactional
	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		System.out.println("Reached from UI");
		User currentUser = userService.findById(id);
		if (currentUser == null) {
			return new ResponseEntity<Object>(
					new CustomErrorType("Unable to update. User with id " + id + " not found."), HttpStatus.NOT_FOUND);
		}
		currentUser.setFirstName(user.getFirstName());
		currentUser.setLastName(user.getLastName());
		currentUser.setPassword(user.getPassword());
		currentUser.setAddressLine1(user.getAddressLine1());
		currentUser.setAddressLine2(user.getAddressLine2());
		currentUser.setGender(user.getGender());
		currentUser.setAge(user.getAge());
		currentUser.setCity(user.getCity());
		currentUser.setState(user.getState());
		currentUser.setPhone(user.getPhone());
		currentUser.setZip(user.getZip());
		userService.updateUser(currentUser);
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}
} // end of class