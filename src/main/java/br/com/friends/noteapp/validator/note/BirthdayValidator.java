package br.com.friends.noteapp.validator.note;

import br.com.friends.noteapp.bean.note.NoteRequest;
import br.com.friends.noteapp.validator.note.factory.NoteValidator;

public class BirthdayValidator implements NoteValidator{

	@Override
	public String validate(NoteRequest note) {
		String message = null;
		
		if(note.getPersonName() == null || 
				(note.getPersonName() != null && note.getPersonName().isEmpty()))  {
			message = "The person name cannot be empty";
		} else if(note.getGift() == null || 
				(note.getGift() != null && note.getGift().isEmpty()))  {
			message = "The gift cannot be empty";
		} else if(note.getPartyLocation() == null || 
				(note.getPartyLocation() != null && note.getPartyLocation().isEmpty()))  {
			message = "The party location cannot be empty";
		}
		
		return message;
	}

}
