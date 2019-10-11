package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.TestClass;
import com.example.demo.service.MapErrorToFields;
import com.example.demo.service.TestClassService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/object/testClass")
public class TestClassRestController {

	@Autowired
	private TestClassService testClassService;

	@Autowired
	private MapErrorToFields mapErrorToFields;

	@PostMapping(path = "/create")
	public ResponseEntity<?> createNewTestClass(@Valid @RequestBody TestClass testClass, BindingResult bindingResult) {
		ResponseEntity resonseEntity = mapErrorToFields.mapErrorToFields(bindingResult);
		if (resonseEntity != null) {
			return resonseEntity;
		}
		TestClass testClassToDB = testClassService.createTestClass(testClass);
		return new ResponseEntity<TestClass>(testClassToDB, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/get/{id}")
	public ResponseEntity<?> getTestClassById(@PathVariable(value = "id") Long id) {
		TestClass testClassFromDB = testClassService.getTestClassById(id);
		return new ResponseEntity<TestClass>(testClassFromDB, HttpStatus.OK);
	}

	@GetMapping(path = "/get")
	public ResponseEntity<?> getAllTestClass() {
		List<TestClass> testClassFromDb = testClassService.getAllTestClass();
		return new ResponseEntity<List<TestClass>>(testClassFromDb, HttpStatus.OK);
	}

	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<?> deleteTestClassById(@PathVariable(value = "id") Long id) {
		String response = testClassService.deleteTestClassByID(id);
		return new ResponseEntity<String>(response, HttpStatus.OK);

	}
	
	@PatchMapping(path = "update/{id}")
	public ResponseEntity<?> updateTestClassByID(@Valid @RequestBody String testClass,
			@PathVariable(value = "id") Long id) throws JsonParseException, JsonMappingException, IOException {
		TestClass testClassFromDB = testClassService.updateTestClassById(id, testClass);
		return new ResponseEntity<TestClass>(testClassFromDB, HttpStatus.OK);
	}

}
