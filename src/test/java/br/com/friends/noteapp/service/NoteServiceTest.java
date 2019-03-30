package br.com.friends.noteapp.service;

import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.friends.noteapp.bean.dto.NoteType;
import br.com.friends.noteapp.bean.note.NoteRequest;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
public class NoteServiceTest {
	
	@Autowired
	private NoteService service;

	@Test
	public void testValidateBirthday() {
		NoteRequest note = new NoteRequest();
		note.setType(NoteType.BIRTHDAY);
		
		String message = service.validate(note);
		log.info(message);
		
		assertNull(message);
	}
	
	@Test
	public void testValidateRecipe() {
		NoteRequest note = new NoteRequest();
		note.setType(NoteType.RECIPE);
		
		String message = service.validate(note);
		log.info(message);
		
		assertNull(message);
	}
	
	@Test
	public void testValidateReminder() {
		NoteRequest note = new NoteRequest();
		note.setType(NoteType.REMINDER);
		
		String message = service.validate(note);
		log.info(message);
		
		assertNull(message);
	}
	
	@Test
	public void testValidateTask() {
		NoteRequest note = new NoteRequest();
		note.setType(NoteType.TASK);
		
		String message = service.validate(note);
		log.info(message);
		
		assertNull(message);
	}
}
