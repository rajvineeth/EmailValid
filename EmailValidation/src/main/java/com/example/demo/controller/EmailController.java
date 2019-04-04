package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BlackList;
import com.example.demo.model.ErrorMessage1;
import com.example.demo.model.Profile2;
import com.example.demo.repository.EmailRepository;
import com.example.demo.service.EmailService;


@RestController
@RequestMapping(value="mongo")
@CrossOrigin("*")
public class EmailController {
	@Autowired
	EmailRepository emprep;
	
	@Autowired
	EmailService emailService;
	
	@RequestMapping(value="/save",method= {RequestMethod.GET})
	public BlackList save(@RequestBody String black) {
		
		BlackList news= new BlackList(black);
		BlackList c = emprep.insert(news);
		return c;		
	}
	
	
	@RequestMapping(value="/saveAll",method= {RequestMethod.GET,RequestMethod.POST},consumes = {"text/plain","application/json", "application/xml","application/text"})
	public List<BlackList> saveAll(@RequestBody String black) {
		String[] arr= black.split(",");
		
		List<BlackList> list = new ArrayList<BlackList>();
		for(String email:arr) {
			BlackList news= new BlackList(email.trim());
			BlackList c = emprep.insert(news);
			list.add(c);
			
		}
		return list;		
	}
	
	
	
	@RequestMapping(value="/getStatus",method= {RequestMethod.GET,RequestMethod.POST},
			consumes = {"text/plain","application/json", "application/xml","application/text"},
			produces = {"text/plain", "application/json", "application/xml",
					"application/text"})
	public ResponseEntity<?> get(@RequestBody Profile2 profile) {
		
		String result = emailService.isValid(profile);
		ErrorMessage1 er = new ErrorMessage1();
		er.setErrorMessage(result);
		String val = er.getErrorMessage();
		System.out.println(val);
		return new ResponseEntity<ErrorMessage1>(er, HttpStatus.OK);
	}
	
	
	

}
