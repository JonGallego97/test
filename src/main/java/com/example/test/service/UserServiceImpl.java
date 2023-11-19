package com.example.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.exceptions.UserNotFoundException;
import com.example.test.models.repository.UserDAO;
import com.example.test.models.service.UserDTO;
import com.example.test.repository.UserRepositoryInterface;

@Service
public class UserServiceImpl implements UserServiceInterface {
	
	@Autowired
	UserRepositoryInterface userRepositoryInterface;

	@Override
	public UserDTO getUserByid(int id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		UserDAO userDAO = userRepositoryInterface.getUserByid(id);
		
		return convertFromDAOToDTO(userDAO);
	}

	@Override
	public int createUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		UserDAO userDAO = convertFromDTOToDAO(userDTO);
		return userRepositoryInterface.createUser(userDAO);
		
	}

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private UserDAO convertFromDTOToDAO(UserDTO userDTO) {
		UserDAO response = new UserDAO(userDTO.getId(), userDTO.getEmail(), userDTO.getPassword());
		return response;
	}
	
	private UserDTO convertFromDAOToDTO(UserDAO userDAO) {
		UserDTO response = new UserDTO(userDAO.getId(), userDAO.getEmail(), userDAO.getPassword());
		return response;
	}
	
	

}
