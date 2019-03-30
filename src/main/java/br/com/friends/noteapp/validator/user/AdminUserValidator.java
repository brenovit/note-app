package br.com.friends.noteapp.validator.user;

import org.springframework.validation.Errors;

import br.com.friends.noteapp.persistence.user.User;
import br.com.friends.noteapp.validator.user.factory.UserValidator;

public class AdminUserValidator implements UserValidator{

	@Override
	public String validate(User user, Errors errors) {
		if(!user.getName().equals("admin")) {
			return "User admin need be admin";
		}
		return null;
	}

}
