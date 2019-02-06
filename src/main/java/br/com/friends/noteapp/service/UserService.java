package br.com.friends.noteapp.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.friends.noteapp.bean.request.UserRequest;
import br.com.friends.noteapp.bean.response.UserResponse;
import br.com.friends.noteapp.domain.user.User;
import br.com.friends.noteapp.domain.user.UserRepository;
import br.com.friends.noteapp.parser.UserParser;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public UserResponse get(UUID id) {
		Optional<User> optional = userRepository.findById(id);
		User entity = optional.get();
		return UserParser.parse(entity);	
	}
	
	public UserResponse create(UserRequest request) {
		User entity = UserParser.parser(request);
		entity = userRepository.save(entity);
		return UserParser.parse(entity);	
	}

	public void delete(UUID id) {
		userRepository.deleteById(id);
	}

	public UserResponse update(UserRequest request) {
		User entity = UserParser.parser(request);
		entity = userRepository.save(entity);
		return UserParser.parse(entity);
	}
}
