package br.com.friends.noteapp.validator.note;

import org.springframework.validation.BindingResult;

import br.com.friends.noteapp.bean.note.NoteRequest;
import br.com.friends.noteapp.validator.note.factory.NoteValidator;

public class BasicValidator implements NoteValidator{

	@Override
	public String validate(NoteRequest note, BindingResult bindingResult) {
		// TODO Auto-generated method stub
		return null;
	}

}
