package br.com.friends.noteapp.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.friends.noteapp.bean.note.NoteRequest;
import br.com.friends.noteapp.bean.note.NoteResponse;
import br.com.friends.noteapp.service.NoteService;

@RestController
@RequestMapping(value="/api/notes")
public class NoteController {
	
	@Autowired
	private NoteService noteService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody NoteRequest request) throws ParseException{
		NoteResponse response = noteService.create(request);
		return new ResponseEntity<NoteResponse>(response, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}" )
	public ResponseEntity<?> read(@PathVariable long id){
		NoteResponse response = noteService.get(id);
		return new ResponseEntity<NoteResponse>(response, HttpStatus.OK);
	}
	
	@GetMapping(path = "/user/{id}" )
	public ResponseEntity<?> listFromUser(@PathVariable String id){
		NoteResponse response = noteService.getFromUserId(id);
		return new ResponseEntity<NoteResponse>(response, HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{id}")
	public void delete(@PathVariable long id){
		noteService.delete(id);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody NoteRequest request) throws ParseException{
		NoteResponse response = noteService.update(request);
		return new ResponseEntity<NoteResponse>(response, HttpStatus.OK);
	}
	
}
