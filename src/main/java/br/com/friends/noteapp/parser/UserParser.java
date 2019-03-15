package br.com.friends.noteapp.parser;

import br.com.friends.noteapp.bean.user.UserRequest;
import br.com.friends.noteapp.bean.user.UserResponse;
import br.com.friends.noteapp.persistence.user.User;

public class UserParser {
	
	public static UserResponse parse(User entity) {
		UserResponse response = new UserResponse();
		response.setAvatar(entity.getAvatar());
		response.setEmail(entity.getEmail());
		response.setId(entity.getId());
		response.setLogin(entity.getUsername());
		response.setName(entity.getName());
		response.setPassword(entity.getPassword());
		return response;
	}
	
	public static User parse(UserRequest request) {
		User entity = new User();
		entity.setEmail(request.getEmail());
		entity.setPassword(request.getPassword());
		entity.setUsername(request.getLogin());
		entity.setName(request.getName());
		return entity;
	}
}
