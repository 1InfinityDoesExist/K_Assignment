package com.example.demo.respository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.beans.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	@Query("Select User from #{#entityName} User where id=?1")
	User getById(Long id);

	@Query("Select User from #{#entityName} User where username=?1")
	public User findByUsername(String username);

	
}
