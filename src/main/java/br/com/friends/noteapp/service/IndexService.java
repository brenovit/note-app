package br.com.friends.noteapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.friends.noteapp.bean.note.NoteResponse;
import br.com.friends.noteapp.bean.user.UserResponse;

@Service
public class IndexService extends FacadeService {

	public UserResponse getUserByUsername(String username) {
		return getUser().getByUsername(username);
	}

	public List<NoteResponse> getNotesFromUserId(Long userKey) {
		return getNote().getFromUserId(userKey);
	}	
	
}
