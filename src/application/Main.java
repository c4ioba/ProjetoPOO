package application;

//import java.util.ArrayList;
//import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Conta;
import entities.ContaCorrente;
//import entities.ContaPoupanca;

/*
 Falta terminar o metodo extrato e criar uma classe transiçao .
 Falta criar um metodo para escolher que tipo de cadastro irar fazer se vai  ser corrente ou poupança  
 */
public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Conta c1 = new ContaCorrente();
		Scanner scanner = new Scanner(System.in);
		boolean sair = false;
		// List<Conta> lista = new ArrayList<>();
		//c1.depositar(10000);
		

		System.out.println("-------Área de Cadastro-------");
		// c1.cadastro();
		// c1.gerarNumeroCartao();

		while (!sair) {
			c1.exibirMenu();
			int opcao = scanner.nextInt();
			scanner.nextLine(); // Limpar o buffer do scanner

			switch (opcao) {
				case 1:
					c1.cadastro();
					break;
				case 2:
					c1.Login();
					break;
				case 3:
					sair = true;
					System.out.println("Saindo do programa...");
					break;
				default:
					System.out.println("Opção inválida! Tente novamente.");
					break;
			}
		}

		
		scanner.close();
		
	}

	
}
