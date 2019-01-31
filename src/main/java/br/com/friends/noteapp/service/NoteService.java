package br.com.friends.noteapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.friends.noteapp.bean.request.NoteRequest;
import br.com.friends.noteapp.bean.response.NoteResponse;
import br.com.friends.noteapp.entity.Note;
import br.com.friends.noteapp.parser.NoteParser;
import br.com.friends.noteapp.repository.NoteRepository;

@Service
public class NoteService {

	@Autowired
	private NoteRepository noteRepository;
	
	public NoteResponse get(Long id) {
		Optional<Note> optional = noteRepository.findById(id);
		Note entity = optional.get();
		return NoteParser.parse(entity);

	}
	
	public NoteResponse create(NoteRequest request) {
		Note entity = NoteParser.parser(request);
		entity = noteRepository.save(entity);
		return NoteParser.parse(entity);
	}

	public void delete(long id) {
		noteRepository.deleteById(id);
	}

	public NoteResponse update(NoteRequest request) {
		Note entity = NoteParser.parser(request);
		entity = noteRepository.save(entity);
		return NoteParser.parse(entity);
	}
	
}
