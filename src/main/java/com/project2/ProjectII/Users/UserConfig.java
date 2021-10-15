package com.project2.ProjectII.Users;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(UserRepository repository) {
		return args ->{
			
			
			Users jonah = new Users(
					"Jonah",
					"Bro",
					"jbro",
					"pass",
					"jbro@gmail.com",
					"123");
			repository.saveAll(List.of(jonah));
		};
	}
	
	

}
