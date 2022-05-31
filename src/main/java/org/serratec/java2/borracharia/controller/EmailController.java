package org.serratec.java2.borracharia.controller;

import javax.mail.MessagingException;

import org.serratec.java2.borracharia.exception.EmailException;
import org.serratec.java2.borracharia.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	EmailService emailService;

	@GetMapping("/message")
	public void enviarEmail() throws MessagingException, EmailException {
//		emailService.emailTeste();
	}

}
