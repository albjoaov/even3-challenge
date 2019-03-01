package br.com.even3.crachaChallenge.models;

// @Entity
// @Table(name = "participante")

public class Participante { // implements Serializable {

	// private static final long serialVersionUID = 1L;

	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nome;
	private String pais;
	private String instituicao;
	private String email;
	private String inscricao;

	public Participante(long id, String nome, String pais, String instituicao, String email, String inscricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.pais = pais;
		this.instituicao = instituicao;
		this.email = email;
		this.inscricao = inscricao;
	}

	public String getEmail() {
		return email;
	}

	public long getId() {
		return id;
	}

	public String getInscricao() {
		return inscricao;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public String getNome() {
		return nome;
	}

	public String getPais() {
		return pais;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setInscricao(String inscricao) {
		this.inscricao = inscricao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
