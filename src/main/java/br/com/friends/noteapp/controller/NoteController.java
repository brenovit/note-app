package br.com.friends.noteapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.friends.noteapp.entity.Note;
import br.com.friends.noteapp.service.NoteService;

@RestController
@RequestMapping(value="/note")
public class NoteController {
	
	@Autowired
	private NoteService noteService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Note note){
		Note noteNew = noteService.create(note);
		return new ResponseEntity<Note>(noteNew, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}" )
	public ResponseEntity<?> read(@PathVariable long id){
		Note note = noteService.get(id).get();
		return new ResponseEntity<Note>(note, HttpStatus.OK);
	}
}
