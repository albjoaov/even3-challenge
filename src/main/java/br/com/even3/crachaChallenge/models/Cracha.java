package br.com.even3.crachaChallenge.models;

import org.springframework.web.multipart.MultipartFile;

public class Cracha {

	private String layout;
	private String conteudo;
	private MultipartFile imagem;
	private String participantes;

	public String getConteudo() {
		return conteudo;
	}

	public MultipartFile getImagem() {
		return imagem;
	}

	public String getLayout() {
		return layout;
	}

	public String getParticipantes() {
		return participantes;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public void setImagem(MultipartFile imagem) {
		this.imagem = imagem;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public void setParticipantes(String participantes) {
		this.participantes = participantes;
	}

}
