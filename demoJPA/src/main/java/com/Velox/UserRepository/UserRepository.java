package com.Velox.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Velox.Userclass.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	
    @Query("SELECT a FROM User a WHERE a.name=?1 and a.id=?2")
	public User findByNameAndId(String name, int id);

	
	//@Query("Select u from User u Where u.name=?1and u.id=?2")
	//public User findByname(String name,int id);
	
	

}
