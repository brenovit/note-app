package br.com.friends.noteapp.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.mail.MessagingException;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.friends.noteapp.domain.note.Note;
import br.com.friends.noteapp.domain.user.User;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class SendNotificationService {
	
	@Autowired
	private FacadeService service;
	
	public void execute() {
		List<Note> notes = service.getNote().getAll().stream().filter(n -> !n.isSended()).collect(Collectors.toList());
		for (Note note : notes) {
			String alertDt = new DateTime(note.getAlertTime()).toString("dd/MM/yyyy HH:mm");
			String actualDt = new DateTime(new Date()).toString("dd/MM/yyyy HH:mm");
			log.info("Alert: "+alertDt + " Actual: "+actualDt);
			
			if(alertDt.equals(actualDt)) {
				User user = note.getUser();
				try {
					service.getEmailSender().sendMail("NotaAqui Alert",note.getBody(), user.getEmail());
					note.setSended(true);
					service.getNote().update(note);
				} catch (MessagingException | ParseException e) {
					log.error(e.getMessage(), e);
				} 
			}			
		}
	}
}
