package br.com.friends.noteapp.validator.note.factory;

import static br.com.friends.noteapp.bean.dto.NoteType.BASIC;
import static br.com.friends.noteapp.bean.dto.NoteType.BIRTHDAY;
import static br.com.friends.noteapp.bean.dto.NoteType.RECIPE;
import static br.com.friends.noteapp.bean.dto.NoteType.REMINDER;
import static br.com.friends.noteapp.bean.dto.NoteType.TASK;

import br.com.friends.noteapp.validator.AbstractFactoryValidator;
import br.com.friends.noteapp.validator.note.BasicValidator;
import br.com.friends.noteapp.validator.note.BirthdayValidator;
import br.com.friends.noteapp.validator.note.RecipeValidator;
import br.com.friends.noteapp.validator.note.ReminderValidator;
import br.com.friends.noteapp.validator.note.TaskValidator;
import br.com.friends.noteapp.validator.user.factory.UserValidator;

public class NoteFactoryValidator extends AbstractFactoryValidator {
	
	
	@Override
	public UserValidator getUserValidator(Integer userType) {		
		return null;
	}
	
	@Override
	public NoteValidator getNoteValidator(Integer noteType) {
		if(noteType == null) {
			return null;
		}
		
		if(noteType.equals(BASIC.ordinal())) {
			return new BasicValidator();
		} else if(noteType.equals(BIRTHDAY.ordinal())) {
			return new BirthdayValidator();
		} else if(noteType.equals(RECIPE.ordinal())) {
			return new RecipeValidator();
		} else if(noteType.equals(REMINDER.ordinal())) {
			return new ReminderValidator();
		} else if(noteType.equals(TASK.ordinal())) {
			return new TaskValidator();
		} 
		
		return null;
	}
}
