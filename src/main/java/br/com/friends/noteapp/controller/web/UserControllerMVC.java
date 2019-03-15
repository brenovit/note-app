package br.com.friends.noteapp.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.friends.noteapp.bean.user.UserResponse;
import br.com.friends.noteapp.service.UserService;

@Controller
public class UserControllerMVC {
		
	@Autowired
	private UserService service;
	
	@GetMapping("/settings")
    public String welcome(Model model, HttpServletRequest request, HttpSession session) {
		
		String username = request.getAttribute("userPrincipal.name").toString();
		UserResponse user = service.getByUsername(username);
		session.setAttribute("userId", user);
    	model.addAttribute("user",user);    	
        return "user/settings";
	}	
	
}
