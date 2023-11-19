package com.example.test.service;

import com.example.test.exceptions.UserNotFoundException;
import com.example.test.models.service.UserDTO;

public interface UserServiceInterface {
	UserDTO getUserByid(int id) throws UserNotFoundException;
	int createUser(UserDTO userDTO);
	int deleteUser(int id);
	
	

}
