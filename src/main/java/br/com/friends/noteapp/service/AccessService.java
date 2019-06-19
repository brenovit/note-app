package br.com.friends.noteapp.service;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import br.com.friends.noteapp.bean.dto.NoteType;
import br.com.friends.noteapp.bean.note.NoteRequest;
import br.com.friends.noteapp.persistence.user.User;

@Service
public class AccessService extends FacadeService{
	
	@Autowired
    private SecurityService security;
   

	private User save(User entity) {
		User user = getUser().save(entity);
		createFirstNote(user.getId());
		return user;
	}
	
	private void createFirstNote(Long userId) {
		NoteRequest request = new NoteRequest();
		request.setTitle("Primeira Nota");
		request.setBody("Bem-Vindo ao NotaAqui"
				+ "\n1. Clique nos 3 pontinhos acima da nota para Editar ou Deletar a nota."
				+ "\n2. Clique no botão de \"+\" para Criar uma nova nota."
				+ "\n3. Sempre que criar uma nota, no horario marcado, será enviado um email de lembrete"
				+ "\n4. Vamos anotar");
		request.setTime(new DateTime().toString("dd/MM/yyyy HH:mm"));
		request.setType(NoteType.BASIC);
		request.setColor("yellow");
		request.setUserId(userId);
		getNote().save(request);
	}
	

	private void autoLogin(String username, String password) {
		security.autoLogin(username, password);
	}

	public boolean registration(User userForm, BindingResult bindingResult) {   	
    	
    	getUser().validate(userForm, bindingResult);
		
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
