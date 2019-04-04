package com.example.demo.controller;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Profile2;
import com.example.demo.model.Uname;
import com.example.demo.service.OTPService;
import com.example.demo.service.UpdateEmail;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@CrossOrigin("*")
public class OTPController{
	
	@Autowired
	OTPService otpService;
	@Autowired
	UpdateEmail updateEmail;
	
	String uname;
	
	
	
	
	
	int user_account;
	@RequestMapping(value="/generateOTPP/{id}/{id1}", method= {RequestMethod.GET})
	 public ResponseEntity<?> getOtp(@PathVariable String id,@PathVariable Integer id1) throws ExecutionException{
		
		String emailid=id;
		Integer accountNum=id1;
		this.uname = emailid;
		System.out.println("hey chal ------- ja" + this.uname);
		this.user_account = accountNum;
		Profile2 user = new Profile2();
		user.setEmail_id(uname);
		user.setUser_account(accountNum);
		String result = otpService.generateOTP(user,user.getEmail_id());
		//Uname name = new Uname( result,this.uname );
		System.out.println("-------------------------------------------------");
		System.out.println(result);
		return new ResponseEntity<>(user.getEmail_id() , HttpStatus.OK);
	}
	
	@PostMapping("/generateOTP")
    public ResponseEntity<?> getOTP(@RequestBody Profile2 user) throws ExecutionException{
		this.uname = user.getEmail_id();
		System.out.println("hey chal ja" + uname);
		
		String result = otpService.generateOTP(user,user.getEmail_id());
		//Uname name = new Uname( result,this.uname );
		System.out.println(result);
		return new ResponseEntity<>(user.getEmail_id() , HttpStatus.OK);
	}

	@PostMapping("/checkOTP")
    public ResponseEntity<Integer> getOTP(@RequestBody Uname otp) throws ExecutionException, JsonParseException, JsonMappingException, IOException{
       /*     System.out.println("Line Number 1:   "+req);
              ObjectMapper mapper = new ObjectMapper();
                Uname otp = mapper.readValue(req, Uname.class);*/
              System.out.println("oyeeeeeeeeeeeeeeeeeeeeeeee" + otp.getEmailId());
              Integer result = otpService.getOTP(otp.getEmailId());
              int account_number = otp.getAccount();
              System.out.println("backend value of account number"+account_number);
              System.out.println("backend value"+result);
              System.out.println("UI value"+otp.getResult());
              if(result.compareTo(otp.getResult()) == 0) {
                     System.out.println("successfully matched");
                     
                  updateEmail.updateEmail(otp.getAccount(),otp.getEmailId());
                     System.out.println("successfully updated");
                     
                     
                     return new ResponseEntity<Integer>(result , HttpStatus.OK);
              }
              System.out.println("otp failed to match");
              return new ResponseEntity<Integer>(result , HttpStatus.OK);
       }

	

}
