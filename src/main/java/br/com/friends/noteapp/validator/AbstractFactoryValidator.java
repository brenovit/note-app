package br.com.friends.noteapp.validator;

import br.com.friends.noteapp.validator.note.factory.NoteValidator;
import br.com.friends.noteapp.validator.user.factory.UserValidator;

public abstract class AbstractFactoryValidator {
	public abstract UserValidator getUserValidator(Integer userType);
	public abstract NoteValidator getNoteValidator(Integer noteType);
}
