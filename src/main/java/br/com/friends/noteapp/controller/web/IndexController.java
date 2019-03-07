package br.com.friends.noteapp.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.com.friends.noteapp.bean.modelview.LoginModelView;

@Controller
@RequestMapping(path = "/")
public class IndexController {
	
	private String mensagem;
	
	@GetMapping(value = "")
	public ModelAndView index() {		
		return new ModelAndView("index", "login", new LoginModelView());
	}
	
	@PostMapping(value = "login")
	public String login(@ModelAttribute("login")LoginModelView loginModelView, 
		      BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("username", loginModelView.getUsername());
        model.addAttribute("password", loginModelView.getPassword());        
        return "note/list";
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
