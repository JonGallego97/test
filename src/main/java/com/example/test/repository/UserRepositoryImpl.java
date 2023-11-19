package com.example.test.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.test.exceptions.UserNotFoundException;
import com.example.test.models.repository.UserDAO;

@Repository
public class UserRepositoryImpl implements UserRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public UserDAO getUserByid(int id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		try {
			return jdbcTemplate.queryForObject("SELECT * from users where id = ?", BeanPropertyRowMapper.newInstance(UserDAO.class),id);
		} catch (Exception e) {
			throw new UserNotFoundException("User does not exit");
		}
	}

	@Override
	public int createUser(UserDAO userDAO) {
		// TODO Auto-generated method stub
		try {
			return jdbcTemplate.update("INSERT INTO users (id,email,password) VALUES(?,?,?)", new Object[] {
					userDAO.getId(),userDAO.getEmail(),userDAO.getPassword()
			}
					);
		} catch (DataIntegrityViolationException e) {
			return 0;
		}
	}

	@Override
	public int deleteUser(int id) {
		return jdbcTemplate.update("delete from users where id = ?",id);
	}

}
