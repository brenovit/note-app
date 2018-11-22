package br.com.friends.noteapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/note")
public class NoteController {

	@RequestMapping(method = RequestMethod.POST, path = "/create" )
	public ResponseEntity<?> buscaVogal(){
		return null;
		
	}
}
