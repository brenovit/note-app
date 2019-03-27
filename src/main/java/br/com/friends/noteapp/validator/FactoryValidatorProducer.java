package br.com.friends.noteapp.validator;

import br.com.friends.noteapp.validator.note.factory.NoteFactoryValidator;
import br.com.friends.noteapp.validator.user.factory.UserFactoryValidator;

public class FactoryValidatorProducer {
	
	public static AbstractFactoryValidator getFactory(String factory) {
		if(factory.equals("USER")) {
			return new UserFactoryValidator();
		} else if(factory.equals("NOTE")) {
			return new NoteFactoryValidator();
		}
		return null;
	}
}
