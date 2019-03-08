package br.com.friends.noteapp.service;

import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.friends.noteapp.bean.user.UserRequest;
import br.com.friends.noteapp.bean.user.UserResponse;
import br.com.friends.noteapp.parser.UserParser;
import br.com.friends.noteapp.persistence.user.User;
import br.com.friends.noteapp.persistence.user.UserRepository;

@Service
public class UserService extends FacadeService {
	
	@Autowired
	private UserRepository userRepository;
	
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
	public UserResponse findById(Long id) {
		Optional<User> optional = userRepository.findById(id);
		User entity = optional.get();
		entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
		return UserParser.parse(entity);	
	}
	
	public UserResponse save(UserRequest request) {		
		return save(UserParser.parse(request));	
	}
	
	public UserResponse save(User entity) {
		entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
		entity.setRoles(new HashSet<>(getRole().findAll()));
		entity = userRepository.save(entity);
		return UserParser.parse(entity);	
	}

	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	public UserResponse update(UserRequest request) {
		User entity = UserParser.parse(request);
		entity = userRepository.save(entity);
		return UserParser.parse(entity);
	}
	
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }
}
