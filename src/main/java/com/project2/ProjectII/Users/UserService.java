package com.project2.ProjectII.Users;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	private final UserRepository userRepository;
	
	
	/*@Autowired 
	 * Tells the application context to inject instance of StudentService here
	 * this allows us to perform the action inside of our getStudents method without 
	 * instantiating a new object of StudentRepository
	 */
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
		
	}
	
	public List<Users> getUsers(){
		return userRepository.findAll();
		
	}
	
	public void validateLogin(String user, String pass) {
		
		try {
			if(userRepository.findByUsername(user).get().getPassword().equals(pass)) {
				System.out.println("Login successful");
//				return true;
			}
			else {
				System.out.println("Wrong username/password!");
//				return false;
			}
			
		}catch(NoSuchElementException e) {
			System.out.println("No user with " + user + " found");
		}

	}
	
	
	public void deleteUser(Long id) {
		boolean exists = userRepository.existsById(id);
		
		if(!exists) {
			throw new IllegalStateException("User with ID: " + id + "does not exists");
			
		}
		userRepository.deleteById(id);
	}
	
	
/*	You really only need transactions when you are combining multiple changes
 *  and want them all to take effect "at the same time" or "not at all".
 *  
 *  @Transactional essentially allows us to negate 
 *  writing the queries necessarily for updating email
 *  this is because it calls the Student entity which then somehow does its magic
 */
	
	public void updateUser(Long id, String firstName, String lastName, String email, String username, int phone) {
		/*
		 * if the student with the id exists, then follow the code down, but if not then throw exception
		 */
		Users user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("User with " + id + " does not exist!"));
		
		/*checking if the user input is null or blank for first name and last name
		 * and check if first and last name exists (the entered name is not the same as the current name)

		 */
		if(firstName != null && firstName.length() > 0 && !Objects.equals(user.getFirstname(), firstName)) {
			user.setFirstname(firstName);
		}
		
		if( lastName != null && lastName.length() > 0  && !Objects.equals(user.getLastname(), lastName)) {
			user.setLastname(lastName);

		}
			
		if(username != null && username.length() > 0 && !Objects.equals(user.getUsername(), username)) {
			Optional<Users> checkUsername = userRepository.findByUsername(username);
			
			/*
			 * Before the new username can be set, checks if the newly entered username is already in the system...
			 * So if the search for username matches the entered email
			 * and if match is found, throw email is taken exception
			 * if newly entered username is not taken, then set the entered username as the new username
			 */
			
			if(checkUsername.isPresent()) {
				throw new IllegalStateException("That username name is taken");
					
			}
			else {
				user.setUsername(username);
			}
	
		}
		
		if(email != null && email.length() > 0 && Objects.equals(user.getEmail(), email) ) {
			Optional<Users> checkEmail = userRepository.findUsersByEmail(email);
			
			/*
			 * Before the new email can be set, checks if the newly entered email is already in the system...
			 * So if the search for emails that matches the entered email
			 * and if match is found, throw email is taken exception
			 * if newly entered email is not taken, then set the entered email as the new email
			 */
			
			if(checkEmail.isPresent()) {
				throw new IllegalStateException("That email is already registered");
			}
			else {
				user.setEmail(email);
			}
			
		}
	}

	public void addNewUser(Users user) {
		Optional<Users> userByEmail = userRepository.findUsersByEmail(user.getEmail());
		Optional<Users> userByUsername = userRepository.findByUsername(user.getUsername());
		
		System.out.println("USER PHONE NUMBER IS BEFORE: " + user.getPhoneNum());

		

		if(userByEmail.isPresent()) {
			throw new IllegalStateException("That email is taken");
		}
		else if(userByUsername.isPresent()) {
			throw new IllegalStateException("That username is taken");
		}
		else {
			userRepository.save(user);
			System.out.println("USER PHONE NUMBER IS: " + user.getPhoneNum());
			System.out.println("New user is " + user);
		}
	}
	
	
	
	
	
	

}
