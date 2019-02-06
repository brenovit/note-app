package br.com.friends.noteapp.parser;

import br.com.friends.noteapp.bean.request.UserRequest;
import br.com.friends.noteapp.bean.response.UserResponse;
import br.com.friends.noteapp.domain.user.User;

public class UserParser {
	
	public static UserResponse parse(User entity) {
		UserResponse response = new UserResponse();
		return response;
	}
	
	public static User parser(UserRequest request) {
		User entity = new User();
		return entity;
	}
}
