package com.Velox.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.Velox.Exception.IdNotFoundException;
import com.Velox.UserDao.UserDao;
import com.Velox.Userclass.User;
import com.Velox.Util.ResponseStructure;
@Service
public class UserService {
	
	@Autowired
    private UserDao userdao;
	
	public ResponseEntity<ResponseStructure<User>> saveUsers(User user) {
		
		User userdb=userdao.saveUsers(user);
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setMessage("Data Saved Successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setObject(userdb);
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userdao.getAllUsers();
	}

	public ResponseStructure<User> getUserById(int userId) {
		// TODO Auto-generated method stub
		User userdb=userdao.getUserById(userId);
		if(userdb!=null)
		{
			ResponseStructure<User> structure = new ResponseStructure<>();
			structure.setMessage("Data Saved Successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setObject(userdb);
			return structure;
		} 
		else
		{
			//ResponseStructure<User> structure = new ResponseStructure<>();
			//structure.setMessage("Data Not Saved");
			//structure.setStatus(HttpStatus.NOT_FOUND.value());
			//structure.setObject(userdb);
			//return structure;
			
			throw new IdNotFoundException("No User is present");
		}
	}

	public ResponseStructure<User> UpdateById(User user, int userId) {
		// TODO Auto-generated method stub
		User userdb=userdao.UpdateById(user,userId);
		if(userdb!=null)
		{
			ResponseStructure<User> structure = new ResponseStructure<>();
			structure.setMessage("Data Updated Successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setObject(userdb);
			return structure;
		}
		else
		{
			ResponseStructure<User> structure = new ResponseStructure<>();
			structure.setMessage("Data Not Updated");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setObject(userdb);
			return structure;
		}
	}

	public User DeleteUserById(int userId) {
		// TODO Auto-generated method stub
		return userdao.DeleteUserById(userId);
	}

	public User findByname(String name,int id) {
		// TODO Auto-generated method stub
		return userdao.findByname(name,id);
	}
	
	

}
