package br.com.friends.noteapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Getter;

@Getter(AccessLevel.PROTECTED)
@Primary
@Component
public class FacadeService {
	
	@Autowired
	private EmailSenderService emailSender;
	@Autowired
	private JobService job;
	@Autowired
	private NoteService note;
	@Autowired	
	private UserService user;
	@Autowired
	private SendNotificationService notification;	
	@Autowired
	private RoleService role;
}
