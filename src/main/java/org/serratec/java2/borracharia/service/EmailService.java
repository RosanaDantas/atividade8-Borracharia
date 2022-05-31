package org.serratec.java2.borracharia.service;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.serratec.java2.borracharia.entity.Servico;
import org.serratec.java2.borracharia.exception.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

	@Autowired
	private JavaMailSender emailSender;
	
	@Value("${spring.mail.username}")
	private String username;
	
	@Value("${spring.mail.password}")
	private String senha;
	
	
	private final String emailRemetente = "renan.ribeiro15@hotmail.com";
	
	public JavaMailSender javaMailSender() {
		
		JavaMailSenderImpl enviarEmail = new JavaMailSenderImpl();
		Properties prop = new Properties();
		
		enviarEmail.setHost("smtp.gmail.com");
		enviarEmail.setPort(465);
		enviarEmail.setUsername(username);
		enviarEmail.setPassword(senha);
		enviarEmail.setDefaultEncoding("UTF-8");
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.ssl.enable", true);
		enviarEmail.setJavaMailProperties(prop);
		
		return enviarEmail;
	}
	
	public void sendMessage(String to, String subject, String text) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(emailRemetente);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}
	
	public void emailTeste(Servico servico) throws MessagingException, EmailException {
		
		this.emailSender = javaMailSender();
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		try {
			helper.setFrom("serratecRenan@gmail.com");
			helper.setTo("rfdrosana@gmail.com");
			
			helper.setSubject("Informações de serviços prestados");
			
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("<html> <p1>Olá " );
			sBuilder.append(servico.getCarro().getCliente().getNome());
			sBuilder.append(", segue os dados do serviço realizado. <p1><br><br>");
			sBuilder.append("<p1> Descrição: " + servico.getDescricaoServico() + "<p1><br>");
			sBuilder.append("<p1> Modelo: " + servico.getCarro().getModelo() + "<p1><br>");
			sBuilder.append("<p1> Valor do serviço: R$ " + servico.getValorServico() + "<p1><br>");
			sBuilder.append("<p1> Data do serviço: " + servico.getDataServico() + "<p1><br><br>");
			sBuilder.append("<p1>Volte sempre! <p1></html><br>");
			
			helper.setText(sBuilder.toString(), true);
			
			emailSender.send(message);
			
		} catch (Exception e) {
			throw new EmailException("Houve um erro ao enviar esse email" + e.getMessage());
			
			}
		}
	}
