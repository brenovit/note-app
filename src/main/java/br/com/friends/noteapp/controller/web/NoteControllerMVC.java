package br.com.friends.noteapp.controller.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.friends.noteapp.bean.note.NoteResponse;
import br.com.friends.noteapp.bean.user.UserResponse;
import br.com.friends.noteapp.service.NoteService;

@Controller
public class NoteControllerMVC {
	
	@Autowired
	private NoteService service;
	
	@GetMapping({"/", "/index"})
    public String welcome(Model model, Authentication authentication, HttpSession session) {		
		Object attribute = session.getAttribute("userKey");
		Long userKey = 0L;
		if(attribute == null) {
			String username = authentication.getName();
			UserResponse user = service.getUser().getByUsername(username);
			session.setAttribute("userKey", user.getId());
			userKey = user.getId();
		} else {
			userKey = (Long) attribute;
		}		
		
		List<NoteResponse> notes = service.getFromUserId(userKey);
		model.addAttribute("notes",notes);
        return "index";
	}
	
	@GetMapping("/note")
    public String create() {
		return "note/create-note";
	}
	
	@PostMapping("/note/edit/{id}")
    public String edit() {
		return "note/create-note";
	}
	
	@PostMapping("/note")
    public String save() {
		return "redirect:/index";
	}
	
	@GetMapping("/note/delete/{id}")
    public String delete() {
		return "redirect:/index";
	}
	
}
