package View;

import java.util.InputMismatchException;
import java.util.Scanner;

import Controller.ControllerPedido;

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
					menuADM();
				}
				else if (setor.equals("COZINHA")){
					menuCOZ();
				}
		}else {
			System.out.println("\n"+setor+" - Login ou Senha Incorreto!");
		}
	}
	
	public static void menuADM() {
		int op = -1;
		while(op != 0) {
			op = -1;
			System.out.println("\n=== Visualizar Pedidos/Clientes ===");
			System.out.println("1 - Pedidos Pendentes (Pagos pelo Cliente).");
			System.out.println("2 - Pedidos Finalizados (Finalizado pela Cozinha).");
			System.out.println("3 - Pedidos Retirados (Cliente retirou).");
			System.out.println("4 - Pedidos Cancelados (Cliente desistiu antes de pagar).");
			System.out.println("5 - Listar clientes.");
			System.out.println("0 - Logout ADM.");
			op = tratamentoExceptionLerInt(op, "Opção: ");
			switch(op) {
			case 1:
				System.out.println("\nPedidos Pendentes:\n"+viewPedido.controllerPedido.retornaPedidosConformeStatus("P"));
				break;
			case 2:
				System.out.println("\nPedidos Finalizados:\n"+viewPedido.controllerPedido.retornaPedidosConformeStatus("F"));
				break;
			case 3:
				System.out.println("\nPedidos Retirados:\n"+viewPedido.controllerPedido.retornaPedidosConformeStatus("E"));
				break;
			case 4:
				System.out.println("\nPedidos Cancelados:\n"+viewPedido.controllerPedido.retornaPedidosConformeStatus("C"));
				break;
			case 5:
				viewCliente.exibirCliente();
				break;
			case 0:
				op = 0;
				break;
			default:
				System.out.println("\nOpção Inválida!\n");
				break;
			}
		}
	}
	
	public static void menuCOZ() {
		System.out.println("\n=== Pedidos Pendentes ===\n"+viewPedido.controllerPedido.retornaPedidosConformeStatus("P"));
		System.out.println("\nDigite a senha do Pedido para finalizar a produção.");
		System.out.print("Senha do Pedido: ");
		int senha = ler.nextInt();
		viewPedido.attStatusPedidoCozinha(senha);
	}
	
}










