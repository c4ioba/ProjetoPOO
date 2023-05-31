package entities;

import java.util.ArrayList;

import java.util.List;

import java.util.Random;

import javax.swing.JOptionPane;

import entities.exception.ExcessaoConta;

/**
 * CLASSE CONTA QUE TÊM COMO OBJETIVO GUARDAR A A LÓGICA E OS TRATAMENTOS DE EXCESSÕES DE MÉTODOS ETC.
 */
public class Conta {

	ArrayList<Double> extrato = new ArrayList<>();
	List<Usuario> list = new ArrayList<>();
	Usuario users = new Usuario();
	private int agencia;
	private double saldo;

	//CONSTRUTOR #1
	public Conta() {

	}
	//CONSTRUTOR #2
	public Conta(List<Usuario> list, Usuario users, int agencia, double saldo) {
		this.list = list;
		this.users = users;
		this.agencia = agencia;
		this.saldo = saldo;
	}
	
	//GETTER E SETTERS
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	//METÓDO DE SAQUE
	public void Saque(double valor) throws ExcessaoConta {

		String aux = JOptionPane.showInputDialog("Digite o valor que deseja sacar");

		double valorSaque = 0;
		try {
			valorSaque = Double.parseDouble(aux);
			JOptionPane.showMessageDialog(null, "Valor digitado R$" + valorSaque);
			
			if (valorSaque > saldo) {
				throw new ExcessaoConta("Você não possui o saldo suficiente na sua conta para realizar o Saque.");
			}
			if (valorSaque <= 0.0) {
				throw new ExcessaoConta("Você não pode inserir um valor menor ou igual a 0!");
			}
			
		if (valorSaque < saldo && valorSaque > 0.0) {

			saldo -= valorSaque;
			extrato.add(valorSaque);
			JOptionPane.showMessageDialog(null, "Saque realizado com sucessso!");
		}
		
	}catch (NumberFormatException e) {
		JOptionPane.showMessageDialog(null, "Número inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
	}catch (ExcessaoConta ex) {
		JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
}

}
	//MÉTODO DE DEPOSITAR
	public void depositar() {

		String aux2 = JOptionPane.showInputDialog("Digite o valor que deseja Depositar");
		double valorDepositar = 0;
		try {
			valorDepositar = Double.parseDouble(aux2);
			JOptionPane.showMessageDialog(null, "Valor digitado R$" + valorDepositar);

		if (valorDepositar > 0) {

			saldo += valorDepositar;
			extrato.add(valorDepositar);
			JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso!");
		}if(valorDepositar <= 0) {
			throw new ExcessaoConta("Você deve inserir um valor maior que R$ 0.0!");
		}
	}catch (NumberFormatException e) {
		JOptionPane.showMessageDialog(null, "Número inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
	}catch (ExcessaoConta ex) {
		JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
}
	}
	//MÉTODO PARA EXIBIR O HISTÓRICO DE TRANSAÇÕES
	public void exibirExtrato() {

		for (Double numero : extrato) {
			JOptionPane.showMessageDialog(null, "Extrato:   " + numero);
		}
	}
	//MÉTODO PARA GERAR UM NÚMERO DE CARTÃO ALEATÓRIO
	public static String gerarNumeroCartao() {
		return null;

	}
	//MÉTODO PARA REALIZAR O CADASTRO DO USUÁRIO
	public void cadastro() {

		String nome = JOptionPane.showInputDialog("Digite o nome do Usuario");
		String cpf = JOptionPane.showInputDialog("Digite CPF");
		String gmail = JOptionPane.showInputDialog("Digite o Gmail");
		String senha = JOptionPane.showInputDialog("Digite a senha da conta");

		// GERANDO NUMERO DE CARTAO
		StringBuilder numero = new StringBuilder();
		int length = 16;
		int groupSize = 4;

		Random random = new Random();

		// Gere os dígitos do número do cartão
		for (int i = 0; i < length; i++) {
			if (i > 0 && i % groupSize == 0) {
				numero.append("-");
			}
			int digit = random.nextInt(10);
			numero.append(digit);
		}
		
		String numeroDoCartao = numero.toString();
		JOptionPane.showMessageDialog(null, "Seu numero  de Cartão: " + numero.toString());

		Usuario users = new Usuario(nome, cpf, gmail, senha, numeroDoCartao);
		list.add(users);

	}
	//MÉTODO PARA REALIZAR O LOGIN DO USUÁRIO
	public void Login() throws Exception {
		String usuarioNome = JOptionPane.showInputDialog("Digite o nome do Usuario");
		String senha = JOptionPane.showInputDialog("Digite a  senha");

		for (Usuario usuario2 : list) {
			if (usuario2.getNome().equals(usuarioNome) && usuario2.getSenha().equals(senha)) {
				JOptionPane.showMessageDialog(null, "Login feito  com sucesso ");
				exibirMenuLogin();
			} else {
				JOptionPane.showMessageDialog(null, "Usuario ou senha Incorretas ");
				throw new ExcessaoConta("Usuário ou Senha Incorretos!");
			}
		}

		limpar();
	}
	//MENU APÓS A EFETIVAÇÃO DO LOGIN
	public void exibirMenuLogin() throws ExcessaoConta {
		String[] opcoes = { "Saldo", "Sacar", "Depositar", "Extrato", "Sair da conta" };

		while (true) {
			int escolha = JOptionPane.showOptionDialog(null, "Selecione uma opção:", "Menu", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

			switch (escolha) {
				case 0:
					JOptionPane.showMessageDialog(null, "Seu Saldo: R$" + getSaldo());
					break;
				case 1:
					Saque(getSaldo());
					break;
				case 2:
					depositar();

					break;
				case 3:
					exibirExtrato();

					break;
				case 4:
					JOptionPane.showMessageDialog(null, "Saindo da conta...");
					System.exit(0);
					break;	
				default:
					System.exit(0);
			}
		}
	}
	//MENU ABERTURA PADRÃO DO APP
	public void exibirMenu() throws Exception {
		String[] opcoes = { "Cadastro", "Login", "Sair", };
		
		
		while (true) {
			try{
			int escolha = JOptionPane.showOptionDialog(null, "Selecione uma opção:", "Menu", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

			switch (escolha) {
				case 0:
					cadastro();
					break;
				case 1:
					Login();
					break;

				case 2:
					JOptionPane.showMessageDialog(null, "Saindo...");
					System.exit(0);
					break;
				default:
					System.exit(0);
			}
		}catch (ExcessaoConta e) {
			e.getMessage();
		}
	}
	}
	//COMANDO PARA LIMPAR O CMD
	public void limpar() {
		// Faz o metodo aguardar 3 segundos para limpar o cmd
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		try {
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
