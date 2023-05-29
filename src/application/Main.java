package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Conta;
import entities.ContaCorrente;
import entities.ContaPoupanca;

public class Main{

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
			Scanner scan = new Scanner(System.in);
			List<Conta> lista = new ArrayList<>();
			
				System.out.println("Nome: ");
				String nome = scan.nextLine();
				System.out.println("Senha: ");
				String senha = scan.nextLine();

				
	}

}
