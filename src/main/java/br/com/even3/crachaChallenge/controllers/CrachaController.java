package br.com.even3.crachaChallenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.even3.crachaChallenge.UploadComponent;
import br.com.even3.crachaChallenge.models.Cracha;

@Controller
@RequestMapping("/")
public class CrachaController {

	@Autowired
	private UploadComponent upload;

	@PostMapping("/gerar")
	public String GerarCracha(@ModelAttribute Cracha cracha, @RequestParam MultipartFile imagem) {
		upload.salvarFoto(imagem);
		return "index";
	}

	@GetMapping
	public String Index(Model model) {
		model.addAttribute("cracha", new Cracha());
		return "index";
	}
}
