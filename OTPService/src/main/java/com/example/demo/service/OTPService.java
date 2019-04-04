package com.example.demo.service;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.Profile2;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;


@Service
@Component
public class OTPService {
	
	private static final Integer EXPIRE_MINS = 5;
	private LoadingCache<String, Integer> otpCache;


	public OTPService(){
		 super();
		 otpCache = CacheBuilder.newBuilder().
			      expireAfterWrite(EXPIRE_MINS, TimeUnit.MINUTES).build(new CacheLoader<String, Integer>() {
			      public Integer load(String key) {
			    	  
			             return 0;
			       }
			   });
		 
		 }

	@Autowired
	EmailService emailService;
	
	

	 public String generateOTP(Profile2 email,String key) {
		 Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
		otpCache.put(key, otp );
		Integer val = otpCache.getIfPresent(key);
		emailService.sendMail(otp,email);
		System.out.println(val);
		
		return "otp sent to mail, "+val;
	 }
	 
	 public Integer getOTP(String key) {
		 
		 try {
			System.out.println(key); 
		    Integer ints = otpCache.get(key);
		    System.out.println("----"+ints);
			return ints;
		} catch (ExecutionException e) {
			
			e.printStackTrace();
		}
		return 0;
		
		
	 }
}
