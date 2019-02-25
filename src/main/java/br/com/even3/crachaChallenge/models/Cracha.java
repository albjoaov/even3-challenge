package br.com.even3.crachaChallenge.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cracha")
public class Cracha implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String layout;
	private String conteudo;
	private String imagem;
	private Participante participantes;

	public String getConteudo() {
		return conteudo;
	}

	public String getImagem() {
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

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public void setParticipantes(Participante participantes) {
		this.participantes = participantes;
	}

}
