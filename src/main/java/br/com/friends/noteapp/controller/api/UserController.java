package br.com.friends.noteapp.controller.api;

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

import br.com.friends.noteapp.bean.user.UserRequest;
import br.com.friends.noteapp.bean.user.UserResponse;
import br.com.friends.noteapp.service.UserService;

@RestController
@RequestMapping(value="/api/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody UserRequest request){
		UserResponse response = userService.save(request);
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}" )
	public ResponseEntity<?> read(@PathVariable Long id){
		UserResponse response = userService.getById(id);
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{username}/username" )
	public ResponseEntity<?> read(@PathVariable String username) {
		UserResponse response = userService.getByUsername(username);
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{id}")
	public void delete(@PathVariable Long id){
		userService.delete(id);
	}
	
	@PutMapping(path="/")
	public ResponseEntity<?> update(@RequestBody UserRequest user){
		UserResponse response = userService.update(user);
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}
}
