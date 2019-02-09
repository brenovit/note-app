package br.com.friends.noteapp.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.friends.noteapp.bean.email.EmailRequest;
import br.com.friends.noteapp.service.EmailSenderService;

@RestController
@RequestMapping("/api/email")
public class EmailController {
	
	@Autowired
	private EmailSenderService emailSenderService;
		
	@PostMapping(path="/send")
	public ResponseEntity<?> send(@RequestBody EmailRequest request) throws MessagingException{
		emailSenderService.sendMail(request);
		String response = "Email enviado com sucesso";
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
}
