package br.com.friends.noteapp.validator.user;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import br.com.friends.noteapp.persistence.user.User;
import br.com.friends.noteapp.validator.user.factory.UserValidator;

public class NormalUserValidator implements UserValidator {
		
	@Override
	public String validate(User user, Errors errors) {
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 5 || user.getUsername().length() > 32) {
            //errors.rejectValue("username", "Size.userForm.username");
        }
        /*if (service.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }*/

        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 2 || user.getPassword().length() > 32) {
            //errors.rejectValue("password", "Size.userForm.password");
        	return "Try one with at least 8 characters.";
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            //errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        	return "These passwords don't match.";
        }
        
        return null;
	}
}