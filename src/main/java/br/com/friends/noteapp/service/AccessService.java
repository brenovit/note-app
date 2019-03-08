package br.com.friends.noteapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.friends.noteapp.persistence.user.User;

@Service
public class AccessService extends FacadeService{
	
	@Autowired
    private SecurityService security;

	public void save(User entity) {
		getUser().save(entity);
	}

	public void autoLogin(String login, String password) {
		security.autoLogin(login, password);
	}
}
