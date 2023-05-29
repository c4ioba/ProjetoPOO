package entities;

import java.util.Scanner;

public abstract class Conta {
		
	private String nome;
	private String senha;
	private int agencia;
	private double numeroConta;
	private double saldo = 0.0;
	
	public Conta() {
		
	}
	
	public Conta(String nome, String senha, int agencia, double numeroConta, double saldo) {
		this.nome = nome;
		this.senha = senha;
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public double getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(double numeroConta) {
		this.numeroConta = numeroConta;
	}
	public double getSaldo() {
		return saldo;
	}
	
	public void Saque(double valor) {
		if(valor > saldo) {
			System.out.println("Saldo Insuficiente");
		}else {
			saldo -= valor;
			System.out.println("Saque de: "+ valor + " realizado com sucesso");
		}
	}
	
	public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito realizado. Saldo atual: " + saldo);
    }
	
	
	
	
}
