package br.com.friends.noteapp.validator.note;

import br.com.friends.noteapp.bean.note.NoteRequest;
import br.com.friends.noteapp.validator.note.factory.NoteValidator;

public class ReminderValidator implements NoteValidator{

	@Override
	public String validate(NoteRequest note) {
		String message = "";
		
		if(note.getTime() == null || 
				(note.getTime() != null && note.getTime().isEmpty()))  {
			message = "The time alert cannot be empty";
		}
		
		return message;
	}

}
