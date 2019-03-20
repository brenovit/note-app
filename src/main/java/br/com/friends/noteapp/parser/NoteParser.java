package br.com.friends.noteapp.parser;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.joda.time.DateTime;

import br.com.friends.noteapp.bean.dto.NoteType;
import br.com.friends.noteapp.bean.note.NoteRequest;
import br.com.friends.noteapp.bean.note.NoteResponse;
import br.com.friends.noteapp.persistence.note.Note;
import br.com.friends.noteapp.persistence.user.User;

public class NoteParser {
	
	public static NoteResponse parse(Note entity) {
		NoteResponse response = new NoteResponse();
		response.setId(entity.getId());
		response.setBody(entity.getBody());
		response.setColor(entity.getColor());
		response.setGift(entity.getGift());
		response.setLastModificatedDate(entity.getLastModificatedDate());
		response.setLocationParty(entity.getLocationParty());
		response.setPersonName(entity.getPersonName());
		response.setTitle(entity.getTitle());
		response.setType(entity.getType());
		response.setUserId(entity.getUser().getId());
		response.setSended(String.valueOf(entity.isSended()));
		response.setAlertTime(new DateTime(entity.getAlertTime()).toString("dd/MM/yyyy HH:mm"));
		return response;
	}
	
	public static Note parser(NoteRequest request) throws ParseException {
		Note entity = new Note();
		entity.setBody(request.getBody());
		entity.setColor(request.getColor());
		entity.setGift(request.getGift());
		entity.setAlertTime(request.getAlertTime());
		entity.setLastModificatedDate(new Date());
		entity.setLocationParty(request.getLocationParty());
		entity.setPersonName(request.getPersonName());
		entity.setTitle(request.getTitle());				
		entity.setType(getType(request.getType()));
		entity.setUser(new User().id(request.getUserId()));
		return entity;
	}

	private static NoteType getType(Integer type) {
		if(NoteType.BASIC.ordinal() == type) {
			return NoteType.BASIC;
		} else if(NoteType.BIRTHDAY.ordinal() == type) {
			return NoteType.BIRTHDAY;
		} else if(NoteType.RECIPE.ordinal() == type) {
			return NoteType.RECIPE;
		} else if(NoteType.REMINDER.ordinal() == type) {
			return NoteType.REMINDER;
		} else if(NoteType.TASK.ordinal() == type) {
			return NoteType.TASK;
		}
		return null;
	}

	public static List<NoteResponse> parse(List<Note> notes) {
		List<NoteResponse> notesResponse = notes.stream().map(n -> parse(n)).collect(Collectors.toList());
		return notesResponse;
	}
}
