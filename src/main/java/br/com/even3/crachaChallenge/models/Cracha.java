package br.com.even3.crachaChallenge.models;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

// @Entity
// @Table(name = "cracha")
public class Cracha implements Serializable {

	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String layout;
	private String conteudo;
	private MultipartFile imagem;
	private Participante participantes;

	public String getConteudo() {
		return conteudo;
	}

	public MultipartFile getImagem() {
		return imagem;
	}

	public String getLayout() {
		return layout;
	}

	public Participante getParticipantes() {
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

	public void setParticipantes(Participante participantes) {
		this.participantes = participantes;
	}

}
