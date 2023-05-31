package entities;

import java.util.List;

//import java.util.Random;

public final class ContaCorrente extends Conta{

	private double taxaCartao;
	
	public ContaCorrente() {
	}

	public ContaCorrente(List<Usuario> list, Usuario users, int agencia, double saldo, double taxaCartao) {
		super(list, users, agencia, saldo);
		this.taxaCartao = taxaCartao;
	}

	public void investir(double valor) {
        if (getSaldo() >= valor) {
            double juros = valor * (3.75 / 100);
            double auxSaldo = getSaldo();
            auxSaldo -= valor;
            auxSaldo += juros;
            System.out.println("Investimento realizado. Saldo atual: " + auxSaldo);
        } else {
            System.out.println("Saldo insuficiente para o investimento.");
        }
    }
	
	
	
	
}
