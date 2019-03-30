package br.com.friends.noteapp.validator.note;

import br.com.friends.noteapp.bean.note.NoteRequest;
import br.com.friends.noteapp.validator.note.factory.NoteValidator;

public class TaskValidator implements NoteValidator{

	@Override
	public String validate(NoteRequest note) {
		String message = "";
		
		if(note.getTasks() != null && note.getTasks().isEmpty()) {
			message = "The task list cannot be empty";
		} if(note.getTasks().size() < 10) {
			
		}
		
		return message;
	}

}
