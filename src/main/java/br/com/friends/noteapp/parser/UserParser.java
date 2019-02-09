package br.com.friends.noteapp.parser;

import br.com.friends.noteapp.bean.user.UserRequest;
import br.com.friends.noteapp.bean.user.UserResponse;
import br.com.friends.noteapp.domain.user.User;

public class UserParser {
	
	public static UserResponse parse(User entity) {
		UserResponse response = new UserResponse();
		response.setAvatar(entity.getAvatar());
		response.setEmail(entity.getEmail());
		response.setId(entity.getId());
		response.setLogin(entity.getLogin());
		response.setName(entity.getName());
		return response;
	}
	
	public static User parser(UserRequest request) {
		User entity = new User();
		entity.setEmail(request.getEmail());
		entity.setPassword(request.getPassword());
		entity.setLogin(request.getLogin());
		entity.setName(request.getName());
		return entity;
	}
}
