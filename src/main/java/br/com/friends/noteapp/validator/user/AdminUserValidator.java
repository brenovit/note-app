package br.com.friends.noteapp.validator.user;

import org.springframework.validation.Errors;

import br.com.friends.noteapp.persistence.user.User;
import br.com.friends.noteapp.validator.user.factory.UserValidator;

public class AdminUserValidator implements UserValidator{

	@Override
	public void validate(User user, Errors errors) {
		// TODO Auto-generated method stub
		
	}

}
