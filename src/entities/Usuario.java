package entities;

public class Usuario extends Pessoa{
	
	private double saldo;
	private double extrato;
	
	public Usuario() {
		
	}
	
	public Usuario(String nome, String cpf, String gmail, String senha, String numeroDoCartao, double saldo,
			double extrato) {
		super(nome, cpf, gmail, senha, numeroDoCartao);
		this.saldo = saldo;
		this.extrato = extrato;
	}

	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getExtrato() {
		return extrato;
	}

	public void setExtrato(double extrato) {
		this.extrato = extrato;
	}
	
	
	
}
