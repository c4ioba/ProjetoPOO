package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.w3c.dom.UserDataHandler;

import entities.exception.ExcessaoConta;

public abstract class Conta {
	
	// private List<String> extrato;
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
			System.out.println("Saque realizado com sucesso!");
			System.out.println("Saldo atual: " + saldo);

		} 
		if (valorSaque > saldo){
			throw new ExcessaoConta("Você não possui o saldo suficiente na sua conta para realizar o Saque.");
		}
		if(valorSaque < 0.0) {
			throw new ExcessaoConta("Você não pode inserir um valor menor que 0!");
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

	    public static String gerarNumeroCartao() {
			return null;
	        
	    }

	
	
	public void cadastro() {
	
		Scanner scan = new Scanner(System.in);

		System.out.print("Digite o nome de Usuário: ");
        String nome = scan.nextLine();
        System.out.print("Digite o CPF: ");
        String cpf = scan.nextLine();
        System.out.print("Digite o Gmail: ");
        String gmail = scan.nextLine();
        System.out.print("Digite a senha da conta: ");
        String senha = scan.nextLine();
        
        //GERANDO NUMERO DE CARTAO
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
        System.out.print("Seu número de Cartão: ");
        System.out.println(numero.toString());
        
        Usuario users = new Usuario(nome, cpf, gmail, senha, numeroDoCartao);
        list.add(users);
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

	public void Login() throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite o nome de usuário: ");
        String usuarioNome = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();
        
        for (Usuario usuario2 : list) {
			if(usuario2.getNome().equals(usuarioNome) && usuario2.getSenha().equals(senha)) {
				System.out.println("Login feito com sucesso!");
				menuLogin();
			}
			else {
				throw new ExcessaoConta("Usuário ou Senha Incorretos!");
			}
		}
		
		limpar();
	}

	//
	public void menuLogin() throws ExcessaoConta {
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
