package br.com.friends.noteapp.validator.note;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import br.com.friends.noteapp.bean.note.NoteRequest;
import br.com.friends.noteapp.validator.note.factory.NoteValidator;

public class BirthdayValidator implements NoteValidator{

	@Override
	public String validate(NoteRequest note, BindingResult errors) {
		String message = null;
		
		if(note.getPersonName() == null || 
				(note.getPersonName() != null && note.getPersonName().isEmpty()))  {
			setError(errors, "personName", "person.not.empty");
			message = "The person name cannot be empty";
		}
		
		return message;
	}
	
	private void setError(Errors errors, String field, String errorCode) {
		if(errors != null) {
			errors.rejectValue(field,errorCode);
		}
	}

}
