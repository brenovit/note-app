package br.com.friends.noteapp.controller.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class IndexController {
	
	@Value("${version}")
	private String version;
			
	@GetMapping(path="/apidoc")
	public RedirectView redirectApiDocSwagger() {
		return new RedirectView("swagger-ui.html");
	}
	
	@GetMapping(path="/api")
	public String api(Model model) {
		model.addAttribute("version", version);
		return "api";
	}	
}
