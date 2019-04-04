package br.com.friends.noteapp.validator.note.factory;

import org.springframework.validation.BindingResult;

import br.com.friends.noteapp.bean.note.NoteRequest;

public interface NoteValidator {
	public String validate(NoteRequest note, BindingResult bindingResult);
}
