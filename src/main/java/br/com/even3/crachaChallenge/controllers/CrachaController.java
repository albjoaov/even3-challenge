package br.com.even3.crachaChallenge.controllers;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.DocumentException;

import br.com.even3.crachaChallenge.models.Cracha;

@Controller
@RequestMapping("/")
public class CrachaController {

	@Autowired
	private br.com.even3.crachaChallenge.services.CrachaService crachaService;

	@PostMapping("/gerar")
	public String GerarCracha(@ModelAttribute Cracha cracha, @RequestParam MultipartFile imagem,
			@RequestParam String conteudo, @RequestParam String participantes, HttpServletResponse httpServletResponse)
			throws MalformedURLException, IOException, DocumentException {

		byte[] bytes = crachaService.criarPDF(imagem, conteudo, participantes);
		// System.out.println(participantes);
		// Envio do arquivo para o client
		httpServletResponse.setContentType("application/pdf");
		httpServletResponse.setHeader("Content-Disposition", "attachment; filename=cracha.pdf");
		httpServletResponse.setHeader("Pragma", "no-cache");
		httpServletResponse.setHeader("Cache-Control", "no-cache");
		httpServletResponse.getOutputStream().write(bytes);

		return "index";
	}

	@GetMapping
	public String Index(Model model) {
		model.addAttribute("cracha", new Cracha());
		return "index";
	}
}
