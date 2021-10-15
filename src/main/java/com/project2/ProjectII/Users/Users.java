package com.project2.ProjectII.Users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table
public class Users {

	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@SequenceGenerator( name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
	 private Long id;
	
	
	private String username, password, email, firstname, lastname, phone_num;
	
	
	
	public Users(Long id, String firstname, String lastname, String username, String password, String email, String phone_num) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone_num = phone_num;
	}
	
	
	
	public Users(String firstname, String lastname, String username, String password, String email, String phone_num) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone_num = phone_num;
	}
	

	
	
	public Users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}



	public Users() {
		
	}
	
	
	
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	
	public String getPhoneNum() {
		return phone_num;
	}
	
	public void setPhoneNum(String phone_num) {
		this.phone_num = phone_num;
	}
	
	

}
