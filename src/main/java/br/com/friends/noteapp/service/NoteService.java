package br.com.friends.noteapp.service;

import static br.com.friends.noteapp.bean.dto.NoteType.BASIC;
import static br.com.friends.noteapp.bean.dto.NoteType.BIRTHDAY;
import static br.com.friends.noteapp.bean.dto.NoteType.RECIPE;
import static br.com.friends.noteapp.bean.dto.NoteType.REMINDER;
import static br.com.friends.noteapp.bean.dto.NoteType.TASK;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaxxer.hikari.util.ClockSource.Factory;

import br.com.friends.noteapp.bean.dto.NoteType;
import br.com.friends.noteapp.bean.note.NoteRequest;
import br.com.friends.noteapp.bean.note.NoteResponse;
import br.com.friends.noteapp.parser.NoteParser;
import br.com.friends.noteapp.persistence.note.Note;
import br.com.friends.noteapp.persistence.note.NoteRepository;
import br.com.friends.noteapp.validator.AbstractFactoryValidator;
import br.com.friends.noteapp.validator.FactoryValidatorProducer;
import br.com.friends.noteapp.validator.note.BasicValidator;
import br.com.friends.noteapp.validator.note.BirthdayValidator;
import br.com.friends.noteapp.validator.note.RecipeValidator;
import br.com.friends.noteapp.validator.note.ReminderValidator;
import br.com.friends.noteapp.validator.note.TaskValidator;
import br.com.friends.noteapp.validator.note.factory.NoteFactoryValidator;
import br.com.friends.noteapp.validator.note.factory.NoteValidator;
import lombok.SneakyThrows;

@Service
public class NoteService extends FacadeService{

	@Autowired
	private NoteRepository noteRepository;
	
	public NoteResponse get(Long id) {
		Optional<Note> optional = noteRepository.findById(id);
		Note entity = optional.get();
		return NoteParser.parse(entity);
	}
	
	public List<NoteResponse> getFromUserId(Long id) {
		List<Note> notes = noteRepository.findByUserId(id);
		return NoteParser.parse(notes);
	}
	
	public void delete(long id) {
		noteRepository.deleteById(id);
	}
	
	@SneakyThrows
	public NoteResponse save(NoteRequest request) {
		Note entity = NoteParser.parser(request);
		entity = update(entity);
		return NoteParser.parse(entity);
	}
	
	public Note update(Note entity) throws ParseException {
		entity = noteRepository.save(entity);
		return entity;
	}

	public List<Note> getAll() {
		return noteRepository.findAll();
	}

	public List<Note> findBySended(boolean sended) {
		return noteRepository.findBySended(sended);
	}

	public List<NoteResponse> getFromUserUsername(String username) {
		List<Note> notes = noteRepository.findByUserUsername(username);
		return NoteParser.parse(notes);
	}

	public String validate(NoteRequest noteForm) {
		String message = null;
		AbstractFactoryValidator abstractValidator = FactoryValidatorProducer.getFactory("NOTE");
		
		NoteValidator validator = abstractValidator.getNoteValidator(noteForm.getType());	
		
		if(validator != null) {
			message = validator.validate(noteForm);
		}		
		return message;
	}	
}
