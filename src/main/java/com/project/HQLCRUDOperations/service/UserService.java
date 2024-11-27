package com.project.HQLCRUDOperations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.HQLCRUDOperations.dao.UserRepository;
import com.project.HQLCRUDOperations.entity.User;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public String registerUser(User user) {
		return userRepository.insertData(user);
	}
	
	public List<User> getAllUsers(){
		return userRepository.getAllUsers();
	}
	
	public User getUser(Long id) {
		return userRepository.getUser(id);
	}
	
	public String updateUser(User user, Long id) {
		return userRepository.updateUser(user, id);
	}
	
	public String deleteUser(Long id) {
		return userRepository.deleteUser(id);
	}
}
