package br.com.friends.noteapp.validator.user.factory;

import org.springframework.validation.Errors;

import br.com.friends.noteapp.persistence.user.User;

public interface UserValidator {
	
	public String validate(User user, Errors errors);
}
