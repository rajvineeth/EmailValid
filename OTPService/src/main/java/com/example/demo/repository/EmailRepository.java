package com.example.demo.repository;




import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Profile;


public interface EmailRepository extends CrudRepository<Profile , Integer>{
	
}
