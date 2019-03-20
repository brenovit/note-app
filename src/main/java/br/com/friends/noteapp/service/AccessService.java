package br.com.friends.noteapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import br.com.friends.noteapp.bean.note.NoteRequest;
import br.com.friends.noteapp.persistence.user.User;
import br.com.friends.noteapp.validator.UserValidator;

@Service
public class AccessService extends FacadeService{
	
	@Autowired
    private SecurityService security;
    @Autowired
    private UserValidator userValidator;

	public User save(User entity) {
		User user = getUser().save(entity);
		
		NoteRequest request = new NoteRequest();
		request.setTitle("Trabalho - Design Patter");
		request.setBody("Implementar no projeto os Design Patterns solicitados");
		request.setTime("18/03/2019 09:00");
		request.setType(0);
		request.setColor("red");
		request.setUserId(user.getId());
		getNote().create(request);
		
		request.setTitle("Trabalho - Session");
		request.setBody("Implementar o uso de Sessão na aplicação (HTTPSession");
		request.setTime("20/03/2019 09:00");
		request.setType(0);
		request.setColor("blue");
		request.setUserId(user.getId());
		getNote().create(request);
		
		return user;
	}

	public void autoLogin(String username, String password) {
		security.autoLogin(username, password);
	}

	public boolean registration(User userForm, BindingResult bindingResult) {
    	userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
    		return false;
    	}
		//Alterar isso
		String password = userForm.getPassword();
		
		save(userForm);
    	//Alterar isso
    	autoLogin(userForm.getUsername(), password);
    	
    	return true;
	}
}
