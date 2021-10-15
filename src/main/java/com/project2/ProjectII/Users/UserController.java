package com.project2.ProjectII.Users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "api/sugma/users")

public class UserController {
	private final UserService userService;
	
	
	@Autowired
	public UserController(UserService userService) {
		System.out.println("User service constructor");
		this.userService = userService;
	}
	
	
	/*
	 * For FETCH
	 * METHOD: GET
	 * the get method to retrieve data from the database and display/check it 
	 * with front end
	 */
	@GetMapping
	public List<Users> getUsers(){
		
		return userService.getUsers();
		
	}
	
	
	
	@PostMapping(path = "/login" )
	public void validateLogin(@RequestBody Users userLogin){
		
		System.out.println("TESTING THE LOGIN IN CONTROLLER");
	
		System.out.println("USER: " + userLogin.getUsername());
		System.out.println("PASS: " + userLogin.getPassword());

		
		userService.validateLogin(userLogin.getUsername(), userLogin.getPassword());
		
	}
	
	
	
	/*
	 * @RequestBody takes the requested body and map it into the student object
	 */
	@PostMapping
	public void registerNewUser(@RequestBody Users user) {
		System.out.println("USER INFO BELOW");
		System.out.println(user.getPhoneNum());
		userService.addNewUser(user);
	
	}
	
	
	
	
	@DeleteMapping(path = "{userID}")
	public void deleteUser(@PathVariable("userID") Long id) {
		userService.deleteUser(id);
	}
	
	
	@PutMapping(path = "{userID}")
	public void updateUsers(@PathVariable("userID") Long id, @RequestParam(required = false) String firstName,
			@RequestParam(required = false) String lastName, @RequestParam(required = false) String email )  	{
		
	}
	
	
	
	
	
	
	
	
	
	

}
