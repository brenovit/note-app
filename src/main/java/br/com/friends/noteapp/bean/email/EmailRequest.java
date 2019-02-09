package br.com.friends.noteapp.bean.email;

import lombok.Data;

@Data
public class EmailRequest {	
	private String subject;
	private String message;
	private String to;
}
