package br.com.friends.noteapp.controller.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.friends.noteapp.bean.dto.NoteType;
import br.com.friends.noteapp.bean.note.NoteRequest;
import br.com.friends.noteapp.bean.note.NoteResponse;
import br.com.friends.noteapp.bean.note.NoteTypeMVC;
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
    public String create(@ModelAttribute("noteForm") NoteRequest noteForm, Model model) {
		List<NoteTypeMVC> noteTypes = getNoteTypes();		
		model.addAttribute("noteTypes", noteTypes);		
		return "note/create-note";
	}
	
	@PostMapping("/note")
    public String save(@ModelAttribute("noteForm") NoteRequest noteForm, HttpSession session) {
		Long userKey = (Long) session.getAttribute("userKey");
		Object attribute = session.getAttribute("noteId");		
		if(attribute != null) {			
			Long noteId = (Long) attribute;
			noteForm.setId(noteId);
		}
		
		noteForm.setUserId(userKey);
		service.create(noteForm);
		return "redirect:/index";
	}
	
	private List<NoteTypeMVC> getNoteTypes(){
		List<NoteTypeMVC> noteTypes = new ArrayList<NoteTypeMVC>();
		noteTypes.add(extractType(NoteType.BASIC));
		noteTypes.add(extractType(NoteType.BIRTHDAY));
		noteTypes.add(extractType(NoteType.RECIPE));
		noteTypes.add(extractType(NoteType.REMINDER));
		noteTypes.add(extractType(NoteType.TASK));		
		return noteTypes;
	}
	
	private NoteTypeMVC extractType(NoteType noteType) {
		return new NoteTypeMVC(noteType.ordinal(), noteType.name());
	}
	
	@GetMapping("/note/edit/{noteId}")
    public String edit(@PathVariable Long noteId, @ModelAttribute("noteForm") NoteRequest noteForm, Model model, HttpSession session) {
		Long userKey = (Long) session.getAttribute("userKey");
		session.setAttribute("noteId", noteId);
		NoteResponse note = service.get(noteId);
		model.addAttribute("note", note);
		return "forward:/note";
	}
	
	@GetMapping("/note/delete/{noteId}")
    public String delete(@PathVariable Long noteId,  Model model, HttpSession session) {
		Long userKey = (Long) session.getAttribute("userKey");
		service.delete(noteId);
		model.addAttribute("message", "Note "+noteId+" deleted");
		return "forward:/index";
	}	
}
