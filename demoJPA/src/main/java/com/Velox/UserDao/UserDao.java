package com.Velox.UserDao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Velox.UserRepository.UserRepository;
import com.Velox.Userclass.User;
@Repository
public class UserDao {
	
	@Autowired
	private UserRepository userrepository;

	public User saveUsers(User user) {
		return userrepository.save(user);
		
		
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userrepository.findAll();
	}

	public User getUserById(int userId) {
		// TODO Auto-generated method stub
	  Optional<User> optional = userrepository.findById(userId);
	  if(optional.isPresent()) {
		  return optional.get();
	  }
	  return null;
	  
	}

	
	public User UpdateById(User user, int userId) {
		// TODO Auto-generated method stub
		Optional<User> optional=userrepository.findById(userId);
		 if(optional.isPresent()) {
			user.setId(userId);
			 return userrepository.save(user);
		  }
		 else
		 {
			 return null;
		 }
		
	}

	public User DeleteUserById(int userId) {
		// TODO Auto-generated method stub
		Optional<User> optional=userrepository.findById(userId);
		 if(optional.isPresent()) {
			 User DeletedUser=optional.get();
			 userrepository.deleteById(userId);
			 return DeletedUser;
		 }
		 return null;
	}

	public User findByname(String name,int id) {
		// TODO Auto-generated method stub
		return userrepository.findByNameAndId(name,id);
	}

}
