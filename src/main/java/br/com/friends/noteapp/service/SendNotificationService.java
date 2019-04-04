package br.com.friends.noteapp.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import com.mashape.unirest.http.exceptions.UnirestException;

import br.com.friends.noteapp.persistence.note.Note;
import br.com.friends.noteapp.persistence.user.User;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class SendNotificationService extends FacadeService{
		
	public void execute() {
		List<Note> notes = getNote().findBySended(false);
		for (Note note : notes) {
			String alertDt = new DateTime(note.getAlertTime()).toString("dd/MM/yyyy HH:mm");
			String actualDt = new DateTime(new Date()).toString("dd/MM/yyyy HH:mm");
			
			if(alertDt.equals(actualDt)) {				
				User user = note.getUser();
				try {
					getNotificationSender().sendNotification(note.getTitle(),note.getBody(), user.getEmail(), user.getPhoneNumber());
					note.setSended(true);
					getNote().save(note);					
				} catch (ParseException | MessagingException | UnirestException e) {
					log.error(e.getMessage(), e);
				} 
			}			
		}
	}
}
