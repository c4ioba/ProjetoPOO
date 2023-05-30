package entities;

//import java.util.ArrayList;
import java.util.HashMap;
//import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public abstract class Conta {
	
	// private List<String> extrato;

	private String nome;
	private String senha;
	private int agencia;
	private double numeroConta;
	private double saldo;
	private double depositar;

	public double getDepositar() {
		return depositar;
	}

	public void setDepositar(double depositar) {
		this.depositar = depositar;
	}

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

	private String getSenha() {
		return senha;
	}

	private void setSenha(String senha) {
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

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void Saque(double valor) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o valor que deseja sacar: ");
		double valorSaque = scanner.nextDouble();

		if (valorSaque <= saldo) {
			saldo -= valorSaque;
			System.out.println("Saque realizado com sucesso!");
			System.out.println("Saldo atual: " + saldo);

		} else {
			System.out.println("Saldo insuficiente. Saque não realizado.");

		}

	}

	public void depositar() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o valor que deseja depositar: ");
		double valorDepositar = scanner.nextDouble();

		if (valorDepositar > 0) {
			saldo += valorDepositar;
			System.out.println("Depósito realizado com sucesso!");
		} else {
			System.out.println("O valor do depósito deve ser maior que zero.");
		}

	}

	public void gerarNumeroCartao() {
		System.out.println("Número do Cartão: ");
		Random gerador = new Random();

		for (int i = 0; i < 4; i++) {
			int numeroAleatorio = gerador.nextInt(9);
			System.out.print(numeroAleatorio);
		}
		System.out.print("-");
		for (int i = 0; i < 4; i++) {
			int numeroAleatorio = gerador.nextInt(9);
			System.out.print(numeroAleatorio);
		}
		System.out.print("-");
		for (int i = 0; i < 4; i++) {
			int numeroAleatorio = gerador.nextInt(9);
			System.out.print(numeroAleatorio);
		}
		System.out.print("-");
		for (int i = 0; i < 4; i++) {
			int numeroAleatorio = gerador.nextInt(9);
			System.out.print(numeroAleatorio);
		}

	}
//construtor
	public void Cadastro(String nome,String senha){
		this.nome = nome;
		this.senha = senha;

	}

	
	Map<String, String> usuarios = new HashMap<>();	
	public <Cadastro> void cadastro() {
		
		Scanner scan = new Scanner(System.in);

	

		System.out.print("Digite o nome de usuário: ");
        String usuario = scan.nextLine();
        if (usuarios.containsKey(usuario)) {
            System.out.println("Usuário já existe!");
            return;
        }

        System.out.print("Digite a senha: ");
        String senha = scan.nextLine();

        usuarios.put(usuario, senha);
        System.out.println("Usuário cadastrado com sucesso!");

		gerarNumeroCartao();

		System.out.println("");

		limpar();
	}
	/*
	 * Iremos ter que criar uma classe so para transiçoes igual a que te mandei no
	 * zap e botar nossos metodos la
	 * public void exibirExtrato() {
	 * System.out.println("Extrato da Conta " + numeroConta);
	 * for (String transacao : extrato) {
	 * System.out.println(transacao);
	 * }
	 * System.out.println("Saldo atual: " + saldo);
	 * }
	 */

	public void Login() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite o nome de usuário: ");
        String usuario = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        if (usuarios.containsKey(usuario) && usuarios.get(usuario).equals(senha)) {
            System.out.println("Login realizado com sucesso!");
			limpar();
			menuLogin();
        } else {
            System.out.println("Nome de usuário ou senha incorretos!");
        }
		
		
	
		limpar();
	}

	//
	public void menuLogin() {
		boolean sair = false;
		Scanner scanner = new Scanner(System.in);
		while (!sair) {
			exibirMenuLogin();
			int opcao = scanner.nextInt();
			scanner.nextLine(); // Limpar o buffer do scanner

			switch (opcao) {
				case 1:
					// Mostrar o saldo
					System.out.println(getSaldo());
					break;
				case 2:
					Saque(getSaldo());

					break;
				case 3:
					depositar();
					// exibirExtrato();
					break;
				case 4:

					// exibirExtrato();
					break;
				case 5:
					sair = true;
					System.out.println("Saindo da conta....");
					break;
				default:
					System.out.println("Opção inválida! Tente novamente.");
					break;
			}
		}
	}

	// menu Login
	public void exibirMenuLogin() {
		System.out.println("===== Conta =====");
		System.out.println("1. Saldo");
		System.out.println("2. Sacar");
		System.out.println("3. Depositar");
		System.out.println("4. Extrato");
		System.out.println("5. Sair da conta");
		System.out.print("Escolha uma opção: ");
	}

	// menu abertura do app esta ligado com o swith case que esta no main
	public void exibirMenu() {
		System.out.println("===== MENU =====");
		System.out.println("1. Cadastro");
		System.out.println("2. Login");
		System.out.println("3. Sair");
		System.out.print("Escolha uma opção: ");
	}

	// limpar cmd
	public void limpar() {
		// Faz o metodo aguardar 3 segundos para limpar o cmd
		try {
			Thread.sleep(3000);
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
