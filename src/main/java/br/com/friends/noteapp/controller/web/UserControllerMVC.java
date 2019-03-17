package br.com.friends.noteapp.controller.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.friends.noteapp.bean.dto.PasswordChange;
import br.com.friends.noteapp.bean.user.UserResponse;
import br.com.friends.noteapp.persistence.user.User;
import br.com.friends.noteapp.service.UserService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class UserControllerMVC {
		
	@Autowired
	private UserService service;
	
	@GetMapping("/settings")
    public String settings(@ModelAttribute("userForm") User userForm, @ModelAttribute("passForm") PasswordChange passForm, Model model, HttpSession session) {
		log.info("Get settings");
		Object attribute = session.getAttribute("userKey");
		Long userKey = (Long) attribute;
		
		UserResponse user = service.getById(userKey);		
    	model.addAttribute("user",user);
    	
        return "user/settings";
	}
	
	@PostMapping("/settings")
	public String updateSettings(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
		log.info("Post settings");
		return "user/settings";
	}
	
	@PostMapping("/updatePassword")
	public String updatePassword(@ModelAttribute("passForm") PasswordChange passForm, BindingResult bindingResult) {
		log.info("Post updatePassword");
		log.info(passForm.toString());
		return "user/settings";
	}
}
