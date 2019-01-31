package br.com.friends.noteapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class IndexController {

	@GetMapping(value = "/")
	public String index(Model model) {
		System.out.println("Index");
		model.addAttribute("version", "1.0.0");
		return "index";
	}
	
	@GetMapping(path="/apidoc")
	public RedirectView redirectApiDocSwagger() {
		return new RedirectView("swagger-ui.html");
	}

}
