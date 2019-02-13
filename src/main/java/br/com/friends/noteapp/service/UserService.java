package br.com.friends.noteapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.friends.noteapp.bean.user.UserRequest;
import br.com.friends.noteapp.bean.user.UserResponse;
import br.com.friends.noteapp.domain.user.User;
import br.com.friends.noteapp.domain.user.UserRepository;
import br.com.friends.noteapp.parser.UserParser;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public UserResponse get(Long id) {
		Optional<User> optional = userRepository.findById(id);
		User entity = optional.get();
		return UserParser.parse(entity);	
	}
	
	public UserResponse create(UserRequest request) {
		User entity = UserParser.parser(request);
		entity = userRepository.save(entity);
		return UserParser.parse(entity);	
	}

	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	public UserResponse update(UserRequest request) {
		User entity = UserParser.parser(request);
		entity = userRepository.save(entity);
		return UserParser.parse(entity);
	}
}
