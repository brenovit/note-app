package br.com.friends.noteapp.controller.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.friends.noteapp.bean.dto.NoteType;
import br.com.friends.noteapp.bean.modelview.NoteColorView;
import br.com.friends.noteapp.bean.modelview.NoteTypeView;
import br.com.friends.noteapp.bean.note.NoteRequest;
import br.com.friends.noteapp.bean.note.NoteResponse;
import br.com.friends.noteapp.service.NoteService;
import br.com.friends.noteapp.util.session.SessionAttribute;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class NoteControllerMVC {
	
	@Autowired
	private NoteService service;
	private String errorMessage;	
	
	@GetMapping("/note")
    public String create(@ModelAttribute("noteForm") NoteRequest noteForm, Model model) {
		model.addAttribute("noteTypes", getNoteTypes());
		model.addAttribute("colors", getNoteColors());
		model.addAttribute("message", errorMessage);
		errorMessage = "";
		return "note/note";
	}
	
	@PostMapping("/note")
    public String save(@ModelAttribute("noteForm") NoteRequest noteForm, HttpSession session, BindingResult bindingResult) {		
		Long userKey = (Long) session.getAttribute(SessionAttribute.USER_KEY.toString());
		Object attribute = session.getAttribute(SessionAttribute.NOTE_KEY.toString());		
		if(attribute != null) {
			Long noteId = (Long) attribute;
			log.info(noteId);
			noteForm.setId(noteId);
		}
		
		noteForm.setUserId(userKey);
		
		String message = service.validate(noteForm);
		if(message != null && !message.isEmpty()) {
			errorMessage = message;
			return "redirect:/note";
		}
		
		service.save(noteForm);
		
		session.removeAttribute(SessionAttribute.NOTE_KEY.toString());
		return "redirect:/index";
	}
	
	@GetMapping("/note/edit/{noteId}")
    public String edit(@PathVariable Long noteId, @ModelAttribute("noteForm") NoteRequest noteForm, Model model, HttpSession session) {
		Long userKey = (Long) session.getAttribute(SessionAttribute.USER_KEY.toString());
		NoteResponse note = service.get(noteId);
		
		if(!userKey.equals(note.getUserId())) {
			model.addAttribute("message", "That note does note belong to you");
			return "forward:/index";
		} 
		
		session.setAttribute(SessionAttribute.NOTE_KEY.toString(), noteId);			
		model.addAttribute("note", note);
		
		return "forward:/note";
	}
	
	@GetMapping("/note/delete/{noteId}")
    public String delete(@PathVariable Long noteId,  Model model, HttpSession session) {
		Long userKey = (Long) session.getAttribute(SessionAttribute.USER_KEY.toString());
		
		NoteResponse note = service.get(noteId);
		if(!userKey.equals(note.getUserId())) {
			model.addAttribute("message", "That note does note belong to you");
		} else {
			service.delete(noteId);
			model.addAttribute("message", "Note "+noteId+" deleted");			
		}
		
		return "forward:/index";
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
}
