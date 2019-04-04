package br.com.friends.noteapp.validator.note;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import br.com.friends.noteapp.bean.note.NoteRequest;
import br.com.friends.noteapp.validator.note.factory.NoteValidator;

public class ReminderValidator implements NoteValidator{

	@Override
	public String validate(NoteRequest note, BindingResult errors) {
		String message = "";
		
		if(note.getTime() == null || 
				(note.getTime() != null && note.getTime().isEmpty()))  {
			setError(errors, "time", "time.alert.not.empty");
			message = "The time alert cannot be empty";
		}
		
		return message;
	}
	
	private void setError(Errors errors, String field, String errorCode) {
		if(errors != null) {
			errors.rejectValue(field,errorCode);
		}
	}

}
