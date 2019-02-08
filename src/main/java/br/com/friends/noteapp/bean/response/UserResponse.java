package br.com.friends.noteapp.bean.response;

import java.util.UUID;

import lombok.Data;

@Data
public class UserResponse {
	private UUID id;	
	private String name;
	private String login;
	private String password;
	private String email;
	private String avatar;
}
