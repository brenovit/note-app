package br.com.friends.noteapp.service;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class SendNotificationService {

	public void execute() {
		log.info("Ola mundo");
	}
}
