package br.com.friends.noteapp.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping(path = "")
public class IndexController {
	
	private String mensagem;
	
	@GetMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("version", "1.0.0");
		mensagem = "Eu sou o login";
		model.addAttribute("mensagem", mensagem);
		return "index";
	}
	
	@GetMapping(value = "/register")
	public String register(Model model) {
		mensagem = "Eu sou o register";
		model.addAttribute("mensagem", mensagem);
		return "index";
	}
	
	@GetMapping(path="/apidoc")
	public RedirectView redirectApiDocSwagger() {
		return new RedirectView("swagger-ui.html");
	}	

	@PostMapping(path = "/{jobName}")
	public RedirectView executar(@PathVariable String jobName) {
		// mensagem = contingenciaService.executar(jobName);
		return redirect();
	}

	private RedirectView redirect() {
		return new RedirectView("/note", true);
	}
}
