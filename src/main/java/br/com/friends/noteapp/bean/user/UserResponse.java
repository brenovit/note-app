package br.com.friends.noteapp.bean.user;

import lombok.Data;

@Data
public class UserResponse {
	private Long id;	
	private String name;
	private String login;
	private String email;
	private String avatar;
	private String password;
}
