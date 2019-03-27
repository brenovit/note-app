package br.com.friends.noteapp.validator.user.factory;

import br.com.friends.noteapp.validator.AbstractFactoryValidator;
import br.com.friends.noteapp.validator.note.factory.NoteValidator;
import br.com.friends.noteapp.validator.user.AdminUserValidator;
import br.com.friends.noteapp.validator.user.NormalUserValidator;

public class UserFactoryValidator extends AbstractFactoryValidator{
	
	@Override
	public UserValidator getUserValidator(Integer userType) {
		if(userType == null) {
			return null;
		}
		
		if(userType == 1) {
			return new NormalUserValidator();
		} else if(userType == 0) {
			return new AdminUserValidator();
		}
		
		return null;
	}
	
	@Override
	public NoteValidator getNoteValidator(Integer noteType) {
		return null;
	}
}
