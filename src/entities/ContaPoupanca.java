package entities;

public final class ContaPoupanca extends Conta{
	
	private Double limiteConta;
	
	public ContaPoupanca() {
		
	}
	
	public ContaPoupanca(String nome, String senha, int agencia, double numeroConta, double saldo, Double limiteConta) {
		super(nome, senha, agencia, numeroConta, saldo);
		this.limiteConta = limiteConta;
	}

	public Double getLimiteConta() {
		return limiteConta;
	}

	public void setLimiteConta(Double limiteConta) {
		this.limiteConta = limiteConta;
	}
	
	
	
	
}
