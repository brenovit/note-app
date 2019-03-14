package br.com.friends.noteapp.service;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.friends.noteapp.bean.note.NoteRequest;
import br.com.friends.noteapp.bean.user.UserResponse;
import br.com.friends.noteapp.persistence.user.User;
import lombok.SneakyThrows;

@Service
public class AccessService extends FacadeService{
	
	@Autowired
    private SecurityService security;
	
	@SneakyThrows(ParseException.class)
	public void save(User entity) {
		UserResponse user = getUser().save(entity);
		
		NoteRequest request = new NoteRequest();
		request.setTitle("Title");
		request.setBody("Body");
		request.setTime("16/02/2019 12:57");
		request.setType(0);
		request.setColor("red");
		request.setUserId(user.getId());
		getNote().create(request);
	}

	public void autoLogin(String login, String password) {
		security.autoLogin(login, password);
	}
}
