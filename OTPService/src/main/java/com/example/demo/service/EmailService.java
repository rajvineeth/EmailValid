package com.example.demo.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.Profile2;


@Service
@Component
public class EmailService {

	@Autowired
	public JavaMailSender javaMailSender;

	public void sendMail(int otp,Profile2 email) {

		System.out.println("inside sendmail");
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true);
			helper.setFrom("otpservicemanage@gmail.com");
			helper.setSubject("OTP");
			helper.setText("hey "+ email.getUser_account() +"otp is"+String.valueOf(otp));
	

			helper.setTo(email.getEmail_id());
			System.out.println("ffff");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// helper.addAttachment("attachment-document-name.jpg", new
		// ClassPathResource("memorynotfound-logo.jpg"));
		javaMailSender.send(message);
//		System.out.println(message.toString());
	}

}
