package com.example.test.repository;

import com.example.test.exceptions.UserNotFoundException;
import com.example.test.models.repository.UserDAO;

public interface UserRepositoryInterface {
	UserDAO getUserByid(int id) throws UserNotFoundException;
	int createUser(UserDAO userDAO);
	int deleteUser(int id);

}
