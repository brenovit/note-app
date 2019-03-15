package br.com.friends.noteapp.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.friends.noteapp.bean.note.NoteResponse;
import br.com.friends.noteapp.service.NoteService;

@Controller
public class NoteControllerMVC {
	
	@Autowired
	private NoteService service;
	
	@GetMapping({"/", "/index"})
    public String welcome(Model model, Authentication authentication) {		
		List<NoteResponse> notes = service.getFromUserUsername(authentication.getName());
		model.addAttribute("nome",authentication.getName());
		model.addAttribute("notes",notes);
        return "index";
	}	
	
}
