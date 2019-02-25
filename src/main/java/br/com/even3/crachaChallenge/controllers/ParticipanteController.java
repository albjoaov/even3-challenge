package br.com.even3.crachaChallenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.even3.crachaChallenge.models.Cracha;
import br.com.even3.crachaChallenge.services.ParticipanteService;

@Controller
public class ParticipanteController {

	@Autowired
	private ParticipanteService service;

	@GetMapping("/")
	public String indexForm(Model model) {
		model.addAttribute("cracha", new Cracha());
		return "index";
	}

	@PostMapping("/")
	public String indexSubmit(@ModelAttribute Cracha cracha) {
		return "index";
	}
}
