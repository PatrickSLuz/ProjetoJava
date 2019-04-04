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
			
	}
	
	public static void cadcliente() {
		System.out.println("INFORME SEU NOME: ");
		System.out.println("INFORME SEU CFP");
	}
	
}
