package View;

import java.util.InputMismatchException;
import java.util.Scanner;

import Controller.ControllerProduto;
import Controller.ControllerCliente;
import Model.Produto;
import Model.Cliente;
import Model.Endereco;
import Model.Pedido;
public class ViewPrincipal {
	
	static Scanner ler = new Scanner(System.in);
	
	static ViewCliente viewCliente = new ViewCliente();
	static ViewPedido viewPedido = new ViewPedido();
		
	public static void main(String[] args) {
		
		viewPedido.alimentaCardapio();
		menu();

	}
	
	public static int tratamentoExceptionLerInt(int varLeitura, String msgPedirInfo) {
		
			while (varLeitura < 0) {
				ler = new Scanner(System.in);
				System.out.print(msgPedirInfo);
				try {
					varLeitura = ler.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Digite somente numeros.");
				}
			}
		return varLeitura;
	}
	
	public static void menu() {
		int op = -1;
		do {
			op = -1;
			System.out.println("\n=== MENU ===");
			System.out.println("1 - Cliente.");
			System.out.println("2 - Administrador.");
			System.out.println("3 - Cozinha.");
			System.out.println("0 - Sair.");
			op = tratamentoExceptionLerInt(op, "Opção: ");
			switch (op) {
			case 1:
				viewCliente.menuCliente();
				break;
			case 2: 
				login("ADM", "adm");
				break;
			case 3:
				login("COZINHA", "coz");
				break;
			case 0:
				op = 0;
				System.out.println("\nSistema Encerrado!");
				break;
			default:
				System.out.println("\nOpção Inválida!\n");
				break;
			}
		} while(op!=0);
	}
	
	public static void login(String setor, String entrar) {
		
		System.out.println("\n=== LOGIN "+setor+" ===");
		
		System.out.print("Login: ");
		String login = ler.next();
		System.out.print("Senha: ");
		String senha = ler.next();
		
		if(login.equals(entrar) && senha.equals(entrar)) {
			System.out.println("\n"+setor+ " Logado com Sucesso!");
			if(setor.equals("ADM")) {
				System.out.print("Status do pedido: "+);
			}
		}else {
			System.out.println("\n"+setor+" - Login ou Senha Incorreto!");
		}
		
		
		
	}
	
	
	
}










