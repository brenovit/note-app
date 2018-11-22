package br.com.friends.noteapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.friends.noteapp.entity.Note;
import br.com.friends.noteapp.repository.NoteRepository;

@Service
public class NoteService {

	@Autowired
	private NoteRepository noteRepository;
	
	public Optional<Note> get(Long id) {
		return noteRepository.findById(id);	
	}
	
	public Note create(Note note) {
		return noteRepository.save(note);
	}
	
}
