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
import br.com.friends.noteapp.bean.modelview.NoteColorView;
import br.com.friends.noteapp.bean.modelview.NoteTypeView;
import br.com.friends.noteapp.bean.note.NoteRequest;
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
    public String create(@ModelAttribute("noteForm") NoteRequest noteForm, Model model) {
		model.addAttribute("noteTypes", getNoteTypes());		
		model.addAttribute("colors", getNoteColors());
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
		service.save(noteForm);
		return "redirect:/index";
	}
	
	private List<NoteTypeView> getNoteTypes(){
		List<NoteTypeView> noteTypes = new ArrayList<NoteTypeView>();
		noteTypes.add(extractType(NoteType.BASIC));
		noteTypes.add(extractType(NoteType.BIRTHDAY));
		noteTypes.add(extractType(NoteType.RECIPE));
		noteTypes.add(extractType(NoteType.REMINDER));
		noteTypes.add(extractType(NoteType.TASK));		
		return noteTypes;
	}
	
	private List<NoteColorView> getNoteColors(){
		List<NoteColorView> noteTypes = new ArrayList<NoteColorView>();
		noteTypes.add(new NoteColorView("white"));
		noteTypes.add(new NoteColorView("red"));
		noteTypes.add(new NoteColorView("pink"));
		noteTypes.add(new NoteColorView("purple"));
		noteTypes.add(new NoteColorView("indigo"));
		noteTypes.add(new NoteColorView("blue"));
		noteTypes.add(new NoteColorView("cyan"));
		noteTypes.add(new NoteColorView("teal"));
		noteTypes.add(new NoteColorView("green"));
		noteTypes.add(new NoteColorView("lime"));
		noteTypes.add(new NoteColorView("yellow"));
		noteTypes.add(new NoteColorView("amber"));
		noteTypes.add(new NoteColorView("orange"));
		noteTypes.add(new NoteColorView("brown"));
		noteTypes.add(new NoteColorView("grey"));
		noteTypes.add(new NoteColorView("black"));
		return noteTypes;
	}
	
	private NoteTypeView extractType(NoteType noteType) {
		return new NoteTypeView(noteType.ordinal(), noteType.name());
	}
	
	@GetMapping("/note/edit/{noteId}")
    public String edit(@PathVariable Long noteId, @ModelAttribute("noteForm") NoteRequest noteForm, Model model, HttpSession session) {
		//Long userKey = (Long) session.getAttribute("userKey");
		session.setAttribute("noteId", noteId);
		NoteResponse note = service.get(noteId);
		model.addAttribute("note", note);
		
		return "forward:/note";
	}
	
	@GetMapping("/note/delete/{noteId}")
    public String delete(@PathVariable Long noteId,  Model model, HttpSession session) {
		//Long userKey = (Long) session.getAttribute("userKey");
		service.delete(noteId);
		model.addAttribute("message", "Note "+noteId+" deleted");
		return "forward:/index";
	}	
}
