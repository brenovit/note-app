package br.com.friends.noteapp.bean.request;

import lombok.Data;

@Data
public class UserRequest {
	private String name;
	private String login;
	private String password;
	private String email;	
}
