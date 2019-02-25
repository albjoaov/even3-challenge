package br.com.even3.crachaChallenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.even3.crachaChallenge.repository.ParticipanteRepository;

@Service
public class ParticipanteService {

	@Autowired
	private ParticipanteRepository repository;

	public void gerarPDF() {
		//
	}

}
