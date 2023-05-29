package entities;

public final class ContaCorrente extends Conta{

	private double taxaCartao;
	
	public ContaCorrente() {
	}

	public ContaCorrente(String nome, String senha, int agencia, double numeroConta, double saldo, double taxaCartao) {
		super(nome, senha, agencia, numeroConta, saldo);
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
