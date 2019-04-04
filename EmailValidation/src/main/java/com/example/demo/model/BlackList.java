package com.example.demo.model;




import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "blacklist")
public class BlackList {

	@Id
	private String id;
	private String emailid;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	@Override
	public String toString() {
		return "BlackList [emailid=" + emailid + "]";
	}

	public BlackList(String email_id) {
		super();
		this.emailid = email_id;
	}

	public BlackList() {
		super();
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
}
