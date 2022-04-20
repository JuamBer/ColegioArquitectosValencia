package com.juamber.arquitectos.services;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.juamber.arquitectos.dto.EmailChangePasswordDTO;


@Service
public class EmailService {
	
	@Autowired
	JavaMailSender javaMailSender;
	
	@Autowired
	TemplateEngine templateEngine;
	
	@Value("${mail.urlFronted}")
	private String urlFronted;
	
	public void sendEmail(EmailChangePasswordDTO dto) {
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			Context context = new Context();
			Map<String, Object> model = new HashMap<>();
			model.put("userName", dto.getUserName());
			model.put("url", urlFronted + dto.getToken());
			model.put("token", dto.getToken());
			context.setVariables(model);
			String htmlText = templateEngine.process("email-template", context);
			
			helper.setFrom(dto.getMailFrom());
			helper.setTo(dto.getMailTo());
			helper.setSubject(dto.getSubject());
			helper.setText(htmlText, true);
			
			javaMailSender.send(message);
		}catch(MessagingException e) {
			System.out.println(e.getMessage());
		}
	}
}
