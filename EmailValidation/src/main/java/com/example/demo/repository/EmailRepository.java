package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.BlackList;

public interface EmailRepository extends MongoRepository<BlackList , String>{
	
	//public String findByBemailId(String email);
	public List<BlackList> findByEmailid(String emailid);
}
