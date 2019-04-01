package br.com.friends.noteapp.service;

import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import br.com.friends.noteapp.bean.user.UserRequest;
import br.com.friends.noteapp.bean.user.UserResponse;
import br.com.friends.noteapp.parser.UserParser;
import br.com.friends.noteapp.persistence.user.User;
import br.com.friends.noteapp.persistence.user.UserRepository;
import br.com.friends.noteapp.validator.AbstractFactoryValidator;
import br.com.friends.noteapp.validator.FactoryValidatorProducer;
import br.com.friends.noteapp.validator.user.factory.UserValidator;

@Service
public class UserService extends FacadeService {
	
	@Autowired
	private UserRepository userRepository;
	
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
	public UserResponse getById(Long id) {
		Optional<User> optional = userRepository.findById(id);
		User entity = optional.get();
		entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
		return UserParser.parse(entity);
	}
	
	public UserResponse save(UserRequest request) {
		User user = save(UserParser.parse(request));
		return UserParser.parse(user);
	}
	
	public User save(User entity) {
		if(entity.getId() == null || entity.getId() == 0) {
			entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
			entity.setRoles(new HashSet<>(getRole().findAll()));			
		}
		entity = userRepository.save(entity);
		return entity;	
	}

	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	public UserResponse update(UserRequest request) {
		User entity = userRepository.save(UserParser.parse(request));
		return UserParser.parse(entity);
	}
		
	public UserResponse getByUsername(String username) {
		return UserParser.parse(findByUsername(username));
    }
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
    }
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
    }
	
	public String validate(User user, BindingResult bindingResult) {
		AbstractFactoryValidator abstractValidator = 
				FactoryValidatorProducer.getFactory("USER");
		
		UserValidator validator = abstractValidator.getUserValidator(user.getType());
		String message = null;
		if(validator != null) {
			message = validator.validate(user, bindingResult);
		}
		
		return message;
	}
}
