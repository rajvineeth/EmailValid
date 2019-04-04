package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.Profile;
import com.example.demo.repository.EmailRepository;

@Component
@Service
public class UpdateEmail {
	
	
	@Autowired
	EmailRepository emailRepository;
	

	

//	public String updateEmail(int user_account, String uname){
////		System.out.println(user_account);
//		
//		
//		Profile result = emailRepository.findById().get();
//		Profile profile = new Profile();
//		profile.setEmail_id(result.getEmail_id());
//		emailRepository.save(profile);
//		return "email saved";
//		
//	}
	public void updateEmail(int user_account,String uname) {
		try {
		Profile result = emailRepository.findById(user_account).get();
		
		
		result.setEmail(uname);
		
		emailRepository.save(result);
		}
		catch(Exception e) {
			
		}
		
	}
	
}
