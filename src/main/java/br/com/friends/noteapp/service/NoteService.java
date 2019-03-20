package br.com.friends.noteapp.service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.friends.noteapp.bean.note.NoteRequest;
import br.com.friends.noteapp.bean.note.NoteResponse;
import br.com.friends.noteapp.parser.NoteParser;
import br.com.friends.noteapp.persistence.note.Note;
import br.com.friends.noteapp.persistence.note.NoteRepository;
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
	
	@SneakyThrows
	public NoteResponse create(NoteRequest request) {
		Note entity = NoteParser.parser(request);
		entity = noteRepository.save(entity);
		return NoteParser.parse(entity);
	}

	public void delete(long id) {
		noteRepository.deleteById(id);
	}
	
	@SneakyThrows
	public NoteResponse update(NoteRequest request) {
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
}
