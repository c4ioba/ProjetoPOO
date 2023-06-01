package entities;

public abstract class Pessoa {

	// ATRIBUTOS DE UM USUÁRIO
	private String nome;
	private String cpf;
	private String gmail;
	private String senha;
	private String numeroDoCartao;

	// CONTRUTOR #1
	public Pessoa() {

	}

	// CONTRUTOR #2
	// botar exeção caso nao escreva cpf gmal nome e senha na hora de cadastrar
	public Pessoa(String nome, String cpf, String gmail, String senha, String numeroDoCartao) {
		this.nome = nome;
		this.cpf = cpf;
		this.gmail = gmail;
		this.senha = senha;
		this.numeroDoCartao = numeroDoCartao;
	}

	// GETTERS E SETTERS
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNumeroDoCartao() {
		return numeroDoCartao;
	}

	public void setNumeroDoCartao(String numeroDoCartao) {
		this.numeroDoCartao = numeroDoCartao;
	}

}
