package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.beans.User;
import com.example.demo.respository.UserRepository;

@Component
public class CustomerDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username);
		if (user == null) {
			new UsernameNotFoundException("User Not Found");
		}
		return user;
	}

	@Transactional
	public User loadUserById(Long id) {
		User user = userRepository.getById(id);
		if (user == null) {
			new UsernameNotFoundException("User Not Found");
		}
		return user;
	}

}

