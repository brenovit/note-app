package br.com.friends.noteapp.validator.note;

import org.springframework.validation.BindingResult;

import br.com.friends.noteapp.bean.note.NoteRequest;
import br.com.friends.noteapp.validator.note.factory.NoteValidator;

public class RecipeValidator implements NoteValidator{

	@Override
	public String validate(NoteRequest note, BindingResult bindingResult) {
		String message = "";
		
		if(note.getTasks() != null && note.getTasks().isEmpty()) {
			message = "The tasks list cannot be empty";
		} else if(note.getItens() != null && note.getItens().isEmpty()) {
			message = "The itens list cannot be empty";
		}
		
		return message;
	}
}
