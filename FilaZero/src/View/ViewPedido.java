package View;

import java.util.Scanner;

import Controller.ControllerCardapio;
import Model.Cardapio;

public class ViewPedido {

	static Scanner ler = new Scanner(System.in);
	
	static ControllerCardapio controllerCardapio = new ControllerCardapio();
	
	static Cardapio cardapio = new Cardapio();
	
	public static void alimentaCardapio() {
		controllerCardapio.cadCardapio(cardapio);
	}
	
	public static void fazerPedido() {
		System.out.println("\n=== CARDÁPIO ===\n"+controllerCardapio.exibirCardapio(cardapio));
		int idPratoBebida = -1, retornoPedido = -1;
		while(retornoPedido < 1 || retornoPedido > 10) {			
			retornoPedido = ViewPrincipal.tratamentoExceptionLerInt(idPratoBebida, "Digite o numero do Prato ou da Bebida: ");
			if(retornoPedido < 1 || retornoPedido > 10) {
				System.out.println("\nEscolha um Prato ou Bebida que existe no Cárdapio!\n");
			}
		}		
		System.out.print("Informe a quantidade: ");
		int qnt = ler.nextInt();
	}
	
	public static void ultimoPedido() {
		
	}
	
}
