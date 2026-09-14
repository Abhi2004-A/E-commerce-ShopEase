package com.product.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender mail;
	
	public void SendMailtoUser(String to, String productName) {
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setTo(to);
		msg.setSubject("New Product Added");
		msg.setText("A new product has been added to our product Table.\n\n" + "Product Name: " + productName + "\n\n");
		mail.send(msg);
		
	}

}
