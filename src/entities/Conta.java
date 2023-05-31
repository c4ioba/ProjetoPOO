package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import entities.exception.ExcessaoConta;

public class Conta {

	ArrayList<Double> extrato = new ArrayList<>();
	List<Usuario> list = new ArrayList<>();
	Usuario users = new Usuario();
	private int agencia;
	private double saldo;

	public Conta() {

	}

	public Conta(List<Usuario> list, Usuario users, int agencia, double saldo) {
		this.list = list;
		this.users = users;
		this.agencia = agencia;
		this.saldo = saldo;
	}

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

	public void Saque(double valor) throws ExcessaoConta {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite o valor que deseja sacar: ");
		double valorSaque = scanner.nextDouble();

		if (valorSaque < saldo && valorSaque > 0.0) {

			saldo -= valorSaque;
			extrato.add(valorSaque);
			System.out.println("Saque realizado com sucesso!");
			System.out.println("Saldo atual: " + saldo);

		}
		if (valorSaque > saldo) {
			throw new ExcessaoConta("Você não possui o saldo suficiente na sua conta para realizar o Saque.");
		}
		if (valorSaque < 0.0) {
			throw new ExcessaoConta("Você não pode inserir um valor menor que 0!");
		}
	}

	public void depositar() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o valor que deseja depositar: ");
		double valorDepositar = scanner.nextDouble();

		if (valorDepositar > 0) {

			saldo += valorDepositar;
			extrato.add(valorDepositar);
			System.out.println("Depósito realizado com sucesso!");
		} else {
			System.out.println("O valor do depósito deve ser maior que zero.");
		}

	}

	public void exibirExtrato() {

		for (Double numero : extrato) {
			System.out.println(numero);
		}

		System.out.println(extrato);
	}

	public static String gerarNumeroCartao() {
		return null;

	}

	public void cadastro() {

		// Scanner scan = new Scanner(System.in);

		String nome = JOptionPane.showInputDialog("Digite o nome do Usuario");
		// System.out.print("Digite o nome de Usuário: ");
		// String nome = scan.nextLine();
		String cpf = JOptionPane.showInputDialog("Digite CPF");
		// System.out.print("Digite o CPF: ");
		// String cpf = scan.nextLine();
		String gmail = JOptionPane.showInputDialog("Digite o Gmail");
		// System.out.print("Digite o Gmail: ");
		// String gmail = scan.nextLine();
		String senha = JOptionPane.showInputDialog("Digite a senha da conta");
		// System.out.print("Digite a senha da conta: ");
		// String senha = scan.nextLine();

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

		// System.out.print("Seu número de Cartão: ");
		// System.out.println(numero.toString());
		JOptionPane.showMessageDialog(null, "Seu numero  de Cartão: " + numero.toString());

		Usuario users = new Usuario(nome, cpf, gmail, senha, numeroDoCartao);
		list.add(users);

	}

	public void Login() throws Exception {
		// Scanner scanner = new Scanner(System.in);
		String usuarioNome = JOptionPane.showInputDialog("Digite o nome do Usuario");
		// System.out.print("Digite o nome de usuário: ");
		// String usuarioNome = scanner.nextLine();
		String senha = JOptionPane.showInputDialog("Digite a  senha");
		// System.out.print("Digite a senha: ");
		// String senha = scanner.nextLine();

		for (Usuario usuario2 : list) {
			if (usuario2.getNome().equals(usuarioNome) && usuario2.getSenha().equals(senha)) {
				JOptionPane.showMessageDialog(null, "Login feito  com sucesso ");
				// System.out.println("Login feito com sucesso!");
				// menuLogin();
				exibirMenuLogin();
			} else {
				JOptionPane.showMessageDialog(null, "Usuario ou senha Incorretas ");
				throw new ExcessaoConta("Usuário ou Senha Incorretos!");
			}
		}

		limpar();
	}

	// menu Login
	public void exibirMenuLogin() throws ExcessaoConta {
		String[] opcoes = { "Saldo", "Sacar", "Depositar", "Extrato", "Sair da conta" };

		while (true) {
			int escolha = JOptionPane.showOptionDialog(null, "Selecione uma opção:", "Menu", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

			switch (escolha) {
				case 0:
					getSaldo();

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
					JOptionPane.showMessageDialog(null, "Opção inválida! Tente  .");
			}
		}

		// System.out.println("===== Conta =====");
		// System.out.println("1. Saldo");
		// System.out.println("2. Sacar");
		// System.out.println("3. Depositar");
		// System.out.println("4. Extrato");
		// System.out.println("5. Sair da conta");
		// System.out.print("Escolha uma opção: ");
	}

	// menu abertura do app esta ligado com o swith case que esta no main
	public void exibirMenu() throws Exception {
		String[] opcoes = { "Cadastro", "Login", "Sair", };

		while (true) {
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
					JOptionPane.showMessageDialog(null, "Opção inválida.");
			}
		}
	}

	// limpar cmd
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
