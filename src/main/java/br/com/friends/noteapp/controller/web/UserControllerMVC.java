package br.com.friends.noteapp.controller.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserControllerMVC {
	
	@GetMapping("/settings")
    public String welcome(Model model, HttpServletRequest request) {
    	model.addAttribute("nome",request.getAttribute("userPrincipal.name"));
    	model.addAttribute("email","email@email.com");
        return "user/settings";
	}	
	
}
