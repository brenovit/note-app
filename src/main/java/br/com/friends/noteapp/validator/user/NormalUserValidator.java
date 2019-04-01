package br.com.friends.noteapp.validator.user;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import br.com.friends.noteapp.persistence.user.User;
import br.com.friends.noteapp.service.UserService;
import br.com.friends.noteapp.util.spring.BeanUtil;
import br.com.friends.noteapp.validator.user.factory.UserValidator;

public class NormalUserValidator implements UserValidator {
	
	@Override
	public String validate(User user, Errors errors) {
		String message = null;
		MessageSource bundle = BeanUtil.getBeans(MessageSource.class);
		UserService service = BeanUtil.getBeans(UserService.class);
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");      
		
		if (service.findByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "Duplicate.userForm.email");
            message = bundle.getMessage("Duplicate.userForm.email", null, LocaleContextHolder.getLocale());
        }
		
        if (service.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
            message = bundle.getMessage("Duplicate.userForm.username", null, LocaleContextHolder.getLocale());
        }       

        if (user.getUsername().length() < 5 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
            message = bundle.getMessage("Size.userForm.username", null, LocaleContextHolder.getLocale());
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 2 || user.getPassword().length() > 32) {
            errors.rejectValue("password",  "Size.userForm.password");
            message = bundle.getMessage("Size.userForm.password", null, LocaleContextHolder.getLocale());
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
            message = bundle.getMessage("Diff.userForm.passwordConfirm", null, LocaleContextHolder.getLocale());
        }
        
        return message;
	}
}