package br.com.friends.noteapp.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping(path = "/note")
public class NoteControllerMVC {

	private String mensagem;

	@GetMapping(path = "")
	public String list(Model model) {
		model.addAttribute("mensagem", mensagem);
		mensagem = "Eu sou o note";
		return "note/list";
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
