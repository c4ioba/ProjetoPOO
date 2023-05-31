package application;

import java.util.Locale;

import entities.Conta;

/**
 * CLASSE PRINCIPAL COM O MÉTODO MAIN PARA RODAR TODA A LÓGICA DO PROGRAMA.
 */
public class Principal {

	public static void main(String[] args) throws Exception {
		Locale.setDefault(Locale.US);
		Conta c1 = new Conta();
		
		c1.exibirMenu();

	}
}
