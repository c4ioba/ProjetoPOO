package application;

import java.util.Locale;

import entities.Conta;

public class Main {

	public static void main(String[] args) throws Exception {
		Locale.setDefault(Locale.US);
		Conta c1 = new Conta();

		// pegar o metodo inicial de menu cadastro
		c1.exibirMenu();

		// System.out.println("-------Área de Cadastro-------");
		/*
		 * try {
		 * while (!sair) {
		 * c1.exibirMenu();
		 * int opcao = scanner.nextInt();
		 * scanner.nextLine(); // Limpar o buffer do scanner
		 * 
		 * switch (opcao) {
		 * case 1:
		 * 
		 * c1.cadastro();
		 * break;
		 * case 2:
		 * c1.Login();
		 * break;
		 * case 3:
		 * sair = true;
		 * System.out.println("Saindo do programa...");
		 * break;
		 * default:
		 * System.out.println("Opção inválida! Tente novamente.");
		 * break;
		 * }
		 * }
		 * } catch (ExcessaoConta e) {
		 * System.out.println(e.getMessage());
		 * }
		 */
	}
}
