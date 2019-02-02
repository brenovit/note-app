package br.com.friends.noteapp.bean.request;

import lombok.Data;

@Data
public class NoteRequest {
	private String title;
	private String body;	
	private UserNote user;
	private String tipo;
	
	@Data
	class UserNote {
		private String UUID;
	}
}
