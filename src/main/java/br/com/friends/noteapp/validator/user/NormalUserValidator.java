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
			setError(errors,"email", "Duplicate.userForm.email");
            message = getBundleMessage(bundle,"Duplicate.userForm.email");
        }
		
        if (service.findByUsername(user.getUsername()) != null) {
            setError(errors,"username", "Duplicate.userForm.username");
            message = getBundleMessage(bundle,"Duplicate.userForm.username");
        }       

        if (user.getUsername().length() < 5 || user.getUsername().length() > 32) {
            setError(errors,"username", "Size.userForm.username");
            message = getBundleMessage(bundle,"Size.userForm.username");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 2 || user.getPassword().length() > 32) {
            setError(errors,"password", "Size.userForm.password");
            message = getBundleMessage(bundle,"Size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            setError(errors,"passwordConfirm", "Diff.userForm.passwordConfirm");
            message = getBundleMessage(bundle,"Diff.userForm.passwordConfirm");
        }
        
        return message;
	}
	
	private void setError(Errors errors, String field, String errorCode) {
		if(errors != null) {
			errors.rejectValue(field,errorCode);
		}
	}
	
	private String getBundleMessage(MessageSource bundle, String code) {
		return bundle.getMessage(code, null, LocaleContextHolder.getLocale());
	}
}