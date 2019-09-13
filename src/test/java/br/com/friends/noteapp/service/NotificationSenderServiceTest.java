package br.com.friends.noteapp.service;

import java.io.IOException;

import javax.mail.MessagingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mashape.unirest.http.exceptions.UnirestException;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
public class NotificationSenderServiceTest {
	
	@Autowired
	private NotificationSenderService service;
	
	@Test
	public void testSendMailWithUniRest() {
		try {
			service.sendNotificationUnirest("Teste", "Mensagem", "breno.arantes97@gmail.com", "+557199999999");
		} catch (MessagingException | UnirestException | IOException e) {
			log.error(e.getMessage(), e);
		}
	}
	
	@Test
	public void testSendMailWithRetrofit() {
		try {
			service.sendNotificationRetrofit("Teste", "Mensagem", "breno.arantes97@gmail.com", "+557199999999");
		} catch (MessagingException | UnirestException | IOException e) {
			log.error(e.getMessage(), e);
		}
	}

}
