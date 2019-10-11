package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.beans.User;
import com.example.demo.exception.UserNameAlreadyExistException;
import com.example.demo.respository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public User saveUser(User newUser) {

		try {
			newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
			newUser.setUsername(newUser.getUsername());
			User userToDB = userRepository.save(newUser);
			return userToDB;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new UserNameAlreadyExistException(
					"Sorry The UserName Already Exist Please Use Some Different User Name");
		}
	}

}
