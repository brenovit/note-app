package br.com.friends.noteapp.parser;

import br.com.friends.noteapp.bean.request.NoteRequest;
import br.com.friends.noteapp.bean.response.NoteResponse;
import br.com.friends.noteapp.entity.Note;

public class NoteParser {
	
	public static NoteResponse parse(Note entity) {
		NoteResponse response = new NoteResponse();
		return response;
	}
	
	public static Note parser(NoteRequest request) {
		Note entity = new Note();
		return entity;
	}
}
