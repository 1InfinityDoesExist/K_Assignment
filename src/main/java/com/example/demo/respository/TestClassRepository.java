package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.beans.TestClass;

@Repository
public interface TestClassRepository extends CrudRepository<TestClass, Long> {

	@Query("Select TestClass from #{#entityName} TestClass where id=?1")
	public TestClass getTestClassById(Long id);

	@Query("Select TestClass from #{#entityName} TestClass ")
	public List<TestClass> getAllTestClass();

	
}
