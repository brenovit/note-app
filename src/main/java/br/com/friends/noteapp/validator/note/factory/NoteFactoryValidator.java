package br.com.friends.noteapp.validator.note.factory;

import static br.com.friends.noteapp.bean.dto.NoteType.BASIC;
import static br.com.friends.noteapp.bean.dto.NoteType.BIRTHDAY;
import static br.com.friends.noteapp.bean.dto.NoteType.RECIPE;
import static br.com.friends.noteapp.bean.dto.NoteType.REMINDER;
import static br.com.friends.noteapp.bean.dto.NoteType.TASK;

import br.com.friends.noteapp.validator.note.BasicValidator;
import br.com.friends.noteapp.validator.note.BirthdayValidator;
import br.com.friends.noteapp.validator.note.RecipeValidator;
import br.com.friends.noteapp.validator.note.ReminderValidator;
import br.com.friends.noteapp.validator.note.TaskValidator;

public class NoteFactoryValidator {

	public static NoteValidator getValidator(Integer integer) {
		if(integer == null) {
			return null;
		}
		
		if(integer.equals(BASIC.ordinal())) {
			return new BasicValidator();
		} else if(integer.equals(BIRTHDAY.ordinal())) {
			return new BirthdayValidator();
		} else if(integer.equals(RECIPE.ordinal())) {
			return new RecipeValidator();
		} else if(integer.equals(REMINDER.ordinal())) {
			return new ReminderValidator();
		} else if(integer.equals(TASK.ordinal())) {
			return new TaskValidator();
		} 
		
		return null;
	}

}
