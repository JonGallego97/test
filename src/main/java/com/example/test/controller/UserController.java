package com.example.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.exceptions.UserNotFoundException;
import com.example.test.models.controller.UserResponse;
import com.example.test.models.service.UserDTO;
import com.example.test.service.UserServiceInterface;

@RestController
@RequestMapping("api/users")
public class UserController {
	@Autowired 
	
	UserServiceInterface userServiceInterface;
	
	@GetMapping("/{id}")
	public ResponseEntity<UserResponse> getUserById(@PathVariable("id")int id) throws UserNotFoundException{
		
		UserDTO userDTO= userServiceInterface.getUserByid(id);
		UserResponse userResponse = convertUserDTOtoResponse(userDTO);
		return new ResponseEntity<>(userResponse, HttpStatus.ACCEPTED);
		
	}
	
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody UserResponse userResponse){
		UserDTO userDTO = convertUserResponseToDTO(userResponse);
		return new ResponseEntity<>(userDTO, HttpStatus.CREATED);

		
	}
	
	private UserResponse convertUserDTOtoResponse(UserDTO userDTO) {

		UserResponse response = new UserResponse(userDTO.getId(), userDTO.getEmail(), userDTO.getPassword());

		return response;
	}
	
	private UserDTO convertUserResponseToDTO(UserResponse userResponse) {
		UserDTO response = new UserDTO(userResponse.getId(), userResponse.getEmail(), userResponse.getPassword());
		return response;
	}

}
