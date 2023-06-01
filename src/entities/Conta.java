package entities;

import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import entities.exception.ExcessaoConta;

/**
 * CLASSE CONTA QUE TÊM COMO OBJETIVO GUARDAR A A LÓGICA E OS TRATAMENTOS DE
 * EXCESSÕES DE MÉTODOS ETC.
 */
public class Conta {

	ArrayList<Double> extrato = new ArrayList<>();
	List<Usuario> list = new ArrayList<>();
	Usuario users = new Usuario();
	private int agencia;
	private double saldo;

	// CONSTRUTOR #1
	public Conta() {

	}

	// CONSTRUTOR #2
	public Conta(List<Usuario> list, Usuario users, int agencia, double saldo) {
		this.list = list;
		this.users = users;
		this.agencia = agencia;
		this.saldo = saldo;
	}

	// GETTER E SETTERS
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

	// METÓDO DE SAQUE
	public void Saque(double valor) throws ExcessaoConta {

		String aux = JOptionPane.showInputDialog(null, "Digite o valor que deseja sacar", "Saque",
				JOptionPane.INFORMATION_MESSAGE);

		double valorSaque = 0;
		try {
			valorSaque = Double.parseDouble(aux);
			JOptionPane.showMessageDialog(null, "Valor digitado R$" + valorSaque, "Saque",
					JOptionPane.INFORMATION_MESSAGE);

			if (valorSaque > saldo) {
				JOptionPane.showMessageDialog(null,
						"Você não possui o saldo suficiente na sua conta para realizar o Saque.", "Saque",
						JOptionPane.ERROR_MESSAGE);

				throw new ExcessaoConta("Você não possui o saldo suficiente na sua conta para realizar o Saque.");

			}
			if (valorSaque <= 0.0) {
				JOptionPane.showMessageDialog(null,
						"Você não possui o saldo suficiente na sua conta para realizar o Saque.", "Erro",
						JOptionPane.ERROR_MESSAGE);
				throw new ExcessaoConta("Você não pode inserir um valor menor ou igual a 0!");
			}

			if (valorSaque < saldo && valorSaque > 0.0) {

				saldo -= valorSaque;
				extrato.add(valorSaque);
				JOptionPane.showMessageDialog(null, "Saque realizado com sucessso!", "Saque",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Número inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
		} catch (ExcessaoConta ex) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + ex.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	// MÉTODO DE DEPOSITAR
	public void depositar() {

		String aux2 = JOptionPane.showInputDialog(null, "Digite o valor que deseja Depositar", "Deposito",
				JOptionPane.INFORMATION_MESSAGE);
		double valorDepositar = 0;
		try {
			valorDepositar = Double.parseDouble(aux2);
			JOptionPane.showMessageDialog(null, "Valor digitado R$" + valorDepositar, "Deposito",
					JOptionPane.INFORMATION_MESSAGE);

			if (valorDepositar > 0) {

				saldo += valorDepositar;
				extrato.add(valorDepositar);
				JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso!", "Deposito",
						JOptionPane.INFORMATION_MESSAGE);
			}
			if (valorDepositar <= 0) {
				JOptionPane.showMessageDialog(null, "Você deve inserir um valor maior que R$ 0.0!", "Erro",
						JOptionPane.ERROR_MESSAGE);
				throw new ExcessaoConta("Você deve inserir um valor maior que R$ 0.0!");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Número inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
		} catch (ExcessaoConta ex) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + ex.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// MÉTODO PARA EXIBIR O HISTÓRICO DE TRANSAÇÕES
	public void exibirExtrato() {

		for (Double numero : extrato) {
			JOptionPane.showMessageDialog(null, "Extrato:   " + numero);
		}
	}

	// MÉTODO PARA GERAR UM NÚMERO DE CARTÃO ALEATÓRIO
	public static String gerarNumeroCartao() {
		return null;

	}

	// MÉTODO PARA REALIZAR O CADASTRO DO USUÁRIO
	public void cadastro() {
		String nome = "";
		String cpf = "";
		String gmail = "";
		String senha = "";

		JPanel panel = new JPanel();
		panel.setLayout((LayoutManager) new BoxLayout(panel, BoxLayout.Y_AXIS));

		JTextField nomeField = new JTextField(20);
		JTextField cpfField = new JTextField(20);
		JTextField gmailField = new JTextField(20);
		JPasswordField senhaField = new JPasswordField(20);

		panel.add(new JLabel("Nome:"));
		panel.add(nomeField);
		panel.add(new JLabel("CPF:"));
		panel.add(cpfField);
		panel.add(new JLabel("Gmail:"));
		panel.add(gmailField);
		panel.add(new JLabel("Senha:"));
		panel.add(senhaField);

		int option = JOptionPane.showConfirmDialog(null, panel, "Cadastro", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		// os valores inseridos podem ser acessados usando as variáveis nome, cpf, gmail
		// e senha. Você pode usar essas informações como necessário no resto do código.
		if (option == JOptionPane.OK_OPTION) {
			nome = nomeField.getText();
			cpf = cpfField.getText();
			gmail = gmailField.getText();
			senha = new String(senhaField.getPassword());

			// Resto do código...
		}

		// botar exeção, caso nao escreva cpf gmal nome e senha na hora de cadastrar

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

	// MÉTODO PARA REALIZAR O LOGIN DO USUÁRIO
	public void Login() throws Exception {
		String usuarioNome = "";
		String senha = "";
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JTextField nomeField = new JTextField(20);
		JPasswordField senhaField = new JPasswordField(20);

		panel.add(new JLabel("Nome do Usuário:"));
		panel.add(nomeField);
		panel.add(new JLabel("Senha:"));
		panel.add(senhaField);

		int option = JOptionPane.showConfirmDialog(null, panel, "Login", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (option == JOptionPane.OK_OPTION) {
			usuarioNome = nomeField.getText();
			senha = new String(senhaField.getPassword());

			// Resto do código...
		}

		for (Usuario usuario2 : list) {
			if (usuario2.getNome().equals(usuarioNome) && usuario2.getSenha().equals(senha)) {
				JOptionPane.showMessageDialog(null, "Login feito  com sucesso... ", "Login",
						JOptionPane.INFORMATION_MESSAGE);
				limpar();
				exibirMenuLogin();
			} else {
				JOptionPane.showMessageDialog(null, "Usuario ou senha Incorretas ", "Erro", JOptionPane.ERROR_MESSAGE);
				throw new ExcessaoConta("Usuário ou Senha Incorretos!");
			}
		}

		limpar();
	}

	// MENU APÓS A EFETIVAÇÃO DO LOGIN
	public void exibirMenuLogin() throws ExcessaoConta {
		String[] opcoes = { "Saldo", "Sacar", "Depositar", "Extrato", "Sair da conta" };
		boolean sairdaconta = false;
		while (!sairdaconta) {
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
					sairdaconta = true;

					break;
				default:
					System.exit(0);
			}
		}
	}

	// MENU ABERTURA PADRÃO DO APP
	public void exibirMenu() throws Exception {
		String[] opcoes = { "Cadastro", "Login", "Sair", };
		ImageIcon logo = new ImageIcon("C:/Users/cleis/OneDrive/Desktop/Jogo/ProjetoPOO/bro.jpeg");

		while (true) {
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

			JLabel opcaoSelecionadaLabel = new JLabel();
			panel.add(opcaoSelecionadaLabel);

			try {
				int escolha = JOptionPane.showOptionDialog(null, panel, "Banco Repeliente de molieres",
						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, logo, opcoes, opcoes[0]);

				switch (escolha) {
					case 0:
						opcaoSelecionadaLabel.setText("Opção selecionada: Cadastro");
						cadastro();
						break;
					case 1:
						opcaoSelecionadaLabel.setText("Opção selecionada: Login");
						Login();

						break;

					case 2:
						JOptionPane.showMessageDialog(null, "Saindo...");
						System.exit(0);
						break;
					default:
						System.exit(0);
				}
			} catch (ExcessaoConta e) {
				e.getMessage();
			}
		}
	}

	// COMANDO PARA LIMPAR O CMD
	public void limpar() {
		// Faz o metodo aguardar 3 segundos para limpar o cmd
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

}
