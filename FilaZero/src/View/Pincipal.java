package View;

import java.util.Scanner;

public class Pincipal {
	static Scanner ler = new Scanner(System.in);
	public static void main(String[] args) {
		

	}
	
	public static void menu() {
		System.out.println("**MENU**");
		System.out.println("1 -- CLIENTE: ");
		System.out.println("2 -- ADMINISTRADOR: ");
		System.out.println("3 -- RESTAURANTE: ");
		int op = ler.nextInt();
		
		switch (op) {
		case 1:
			menuCliente();
			break;
		case 2: 
			adm();
			break;
		case 3:
			restaurente();
			break;
		default:
			break;
		}
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
