package br.com.friends.noteapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping(value = "/")
	public String index(Model model) {
		System.out.println("Index");
		model.addAttribute("version", "1.0.0");
		return "index";
	}

}
