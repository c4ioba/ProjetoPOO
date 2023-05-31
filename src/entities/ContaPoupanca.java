package entities;

import java.util.List;

public final class ContaPoupanca extends Conta{
	
	private Double limiteConta;
	
	public ContaPoupanca() {
		
	}

	public ContaPoupanca(List<Usuario> list, Usuario users, int agencia, double saldo, Double limiteConta) {
		super(list, users, agencia, saldo);
		this.limiteConta = limiteConta;
	}

	public Double getLimiteConta() {
		return limiteConta;
	}

	public void setLimiteConta(Double limiteConta) {
		this.limiteConta = limiteConta;
	}
	
	
	
	
}
