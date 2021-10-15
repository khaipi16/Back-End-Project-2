package com.project2.ProjectII.Users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository <Users, Long>{

	
	/*The following Optional is the same as writing a query such as:
	 * SELECT * FROM student WHERE email = ?
	 * 
	 * can also write it using annotations
	 * @Query("SELECT s FROM Student s WHERE s.email = ?1)
	 * where Student refers to the Student class
	 */
	
//	@Query("SELECT u FROM USERS u WHERE u.email = ?1")
	Optional<Users> findUsersByEmail(String email);
//
//	
//	@Query("SELECT u FROM USERS u WHERE u.username = ?1")
	Optional<Users> findByUsername(String username);

}
