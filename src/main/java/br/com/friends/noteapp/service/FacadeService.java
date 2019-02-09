package br.com.friends.noteapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Getter;

@Getter
@Service
public class FacadeService {
	
	@Autowired
	private EmailSenderService emailSenderService;
	@Autowired
	private JobService jobService;
	@Autowired
	private NoteService noteService;
	@Autowired	
	private UserService userService;
	@Autowired
	private SendNotificationService notificationService;
	
}
