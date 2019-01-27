package br.com.friends.noteapp.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.friends.noteapp.entity.User;
import br.com.friends.noteapp.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public Optional<User> get(UUID id) {
		return userRepository.findById(id);	
	}
	
	public User create(User note) {
		return userRepository.save(note);
	}

	public void delete(UUID id) {
		userRepository.deleteById(id);
	}

	public User update(User note) {
		return userRepository.save(note);
	}
}
