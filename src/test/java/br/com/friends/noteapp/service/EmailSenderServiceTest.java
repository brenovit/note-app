package br.com.friends.noteapp.service;

import javax.mail.MessagingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.mashape.unirest.http.exceptions.UnirestException;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RunWith(SpringRunner.class)
public class EmailSenderServiceTest {
	
	private EmailSenderService service = new EmailSenderService();
	
	@Test
	public void testSendMail() {
		try {
			service.sendMail("Teste", "Mensagem", "breno.arantes97@gmail.com");
		} catch (MessagingException | UnirestException e) {
			log.error(e.getMessage(), e);
		}
	}

}
