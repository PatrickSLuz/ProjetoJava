package View;

import java.util.Scanner;

public class Pincipal {
	static Scanner ler = new Scanner(System.in);
	public static void main(String[] args) {

		menu();

	}
	
	public static void menu() {
		System.out.println("=== MENU ===");
		System.out.println("1 - Cliente.");
		System.out.println("2 - Administrador.");
		System.out.println("3 - Restaurante.");
		System.out.println("0 - Sair.");
		System.out.print("Opção: ");
		int op = ler.nextInt();
		
		switch (op) {
		case 1:
			menuCliente();
			break;
		case 2: 
			adm();
			break;
		case 3:
			cozinha();
			break;
		case 0:
			op = 0;
			break;
		default:
			System.out.println("\nOpção Inválida!");
			break;
		}
	}
	
	public static void menuCliente() {
		System.out.println("\n=== MENU CLIENTE ===");
		System.out.println("1 - Cadastrar cliente.");
		System.out.println("2 - Fazer Login.");
		System.out.println("0 - Voltar.");
		System.out.print("Opção: ");
		int opcao = ler.nextInt();
	}
	
	public static void adm() {
		
	}
	
	public static void cozinha() {
		
	}
	
	public static void cadcliente() {
		System.out.println("INFORME SEU NOME: ");
		String nome = ler.next();
		
		System.out.println("INFORME SEU RG: ");
		int rg = ler.nextInt();
		
		System.out.println("INFORME SEU CPF: ");
		int cpf = ler.nextInt();
		
		System.out.println("INFORME SEU TELEFONE: ");
		String telefone = ler.next();
		System.out.println("INFORME SEU ENDEREÇO: ");
		
	}
	
}
