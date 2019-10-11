package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.User;
import com.example.demo.payload.JWTLoginSucessReponse;
import com.example.demo.payload.LoginRequest;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.security.SecurityConstant;
import com.example.demo.service.MapErrorToFields;
import com.example.demo.service.UserService;
import com.example.demo.validator.UserValidator;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private MapErrorToFields mapErrorToField;

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping(path = "/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest,
			BindingResult bindingResult) {
		ResponseEntity<?> errorMap = mapErrorToField.mapErrorToFields(bindingResult);

		if (errorMap != null) {
			return errorMap;
		}
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = SecurityConstant.TOKEN_PREFIX + jwtTokenProvider.generateToken(authentication);
		return ResponseEntity.ok(new JWTLoginSucessReponse(true, jwt));
		
	}

	@PostMapping(path = "/register")
	public ResponseEntity<?> createUser(@Valid @RequestBody User user, BindingResult bindingResult) {
		userValidator.validate(user, bindingResult);

		ResponseEntity<?> errorMap = mapErrorToField.mapErrorToFields(bindingResult);
		if (errorMap != null) {
			return errorMap;
		}

		User newUser = userService.saveUser(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
}
