package br.com.friends.noteapp.controller;

import java.util.UUID;

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

import br.com.friends.noteapp.entity.User;
import br.com.friends.noteapp.service.UserService;

@RestController
@RequestMapping(value="/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody User user){
		User userNew = userService.create(user);
		return new ResponseEntity<User>(userNew, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}" )
	public ResponseEntity<?> read(@PathVariable UUID id){
		User user = userService.get(id).get();
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{id}")
	public void delete(@PathVariable UUID id){
		userService.delete(id);
	}
	
	@PutMapping(path="/")
	public ResponseEntity<?> update(@RequestBody User user){
		User userNew = userService.update(user);
		return new ResponseEntity<User>(userNew, HttpStatus.OK);
	}
}
