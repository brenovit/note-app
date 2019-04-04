package br.com.friends.noteapp.service;

import javax.mail.MessagingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.mashape.unirest.http.exceptions.UnirestException;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RunWith(SpringRunner.class)
public class NotificationSenderServiceTest {
	
	private NotificationSenderService service = new NotificationSenderService();
	
	@Test
	public void testSendMail() {
		try {
			service.sendNotification("Teste", "Mensagem", "breno.arantes97@gmail.com", "+557199999999");
		} catch (MessagingException | UnirestException e) {
			log.error(e.getMessage(), e);
		}
	}

}
