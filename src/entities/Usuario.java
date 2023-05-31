package entities;

public class Usuario {
	
	private String nome;
	private String cpf;
	private String gmail;
	private String senha;
	private String numeroDoCartao;
	
	public Usuario() {
		
	}

	public Usuario(String nome, String cpf, String gmail, String senha, String numeroDoCartao) {
		this.nome = nome;
		this.cpf = cpf;
		this.gmail = gmail;
		this.senha = senha;
		this.numeroDoCartao = numeroDoCartao;
	}

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
