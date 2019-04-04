package com.example.demo.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.kafka.producer.Sender;
import com.example.demo.model.Profile2;
import com.example.demo.repository.EmailRepository;

@Service
@Component
public class EmailServiceImpl implements EmailService {

	@Value("${spring.kafka.topic.userRegistered1}")
    private String OtpGenerate;
	
	@Autowired
	private Sender sender;
	
	@Autowired
	private EmailRepository emailRepository;
	
	@Override
	public String isValid(Profile2 temp) {
		boolean flag = false;
		String email = temp.getEmail_id();
		System.out.println("UI email" + email);
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";
		Pattern pat = Pattern.compile(emailRegex);
		//try {
//			BlackList news= new BlackList(email);
//			BlackList c = emailRepository.insert(news);
//			   System.out.println("Created:- " + c);
			// Optional<BlackList> test =
			// emailRepository.findBlackListByEmailid(temp.getEmail_id());
			// noEmail=test.get().getEmailid();
			// System.out.println("mongo------------------"+test);
//			List<BlackList> list = emailRepository.findAll();
//			for (BlackList item : list) {
//				System.out.println(item.toString());
//			}
//			System.out.println();

	//	} catch (Exception e) {

	//	}
		

		try {
			String abc = emailRepository.findByEmailid(email).get(0).getEmailid();
			System.out.println("from method--------" + abc);
			System.out.println("inside try");
			System.out.println("**********************mongo value" + abc);
			if (pat.matcher(email).matches() == false) {
				// sender.send(OtpGenerate, temp);
//				System.out.println("entered email id is invalid");
				return "Email is Invalid";
			}
			if (null != abc) {
//				System.out.println("Entered email Id is Blacklisted");
				return "email Id is Blacklisted";
			}
		} catch (Exception e) {
			System.out.println("Not Found");
			if (pat.matcher(email).matches() == false) {
				// sender.send(OtpGenerate, temp);
				return "Email is Invalid";
			} 
			
			sender.send(OtpGenerate, temp);

		}
		// else if(emailRepository.equals(email) == true) {
		
		
		return "Email is Valid";

	}

}
