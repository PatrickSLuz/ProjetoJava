package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controller.ControllerProduto;
import Model.Produto;
import Model.Pedido;

public class ViewPedido {

	static Scanner ler = new Scanner(System.in);
	
	static ControllerProduto controllerProduto = new ControllerProduto();
	
	static Produto produto = new Produto();
	static Pedido pedido;
	
	static ViewPrincipal viewPrincipal = new ViewPrincipal();
	
	public static void alimentaCardapio() {
		produto = new Produto(1, "Salada Caesar", 9.9);
		controllerProduto.cadCardapio(produto);
		
		produto = new Produto(2, "Porção de Alcatra", 35.9);
		controllerProduto.cadCardapio(produto);
		
		produto = new Produto(3, "Bife Acebolado", 15.5);
		controllerProduto.cadCardapio(produto);

		produto = new Produto(4, "Feijoada", 14.9);
		controllerProduto.cadCardapio(produto);
		
		produto = new Produto(5, "Steak Tartare", 65);
		controllerProduto.cadCardapio(produto);
		
		produto = new Produto(6, "Refrigerante 1L", 7);
		controllerProduto.cadCardapio(produto);
		
		produto = new Produto(7, "Torre de Chop 2,5L", 60);
		controllerProduto.cadCardapio(produto);
		
		produto = new Produto(8, "Agua", 3);
		controllerProduto.cadCardapio(produto);
		
		produto = new Produto(9, "Suco Natural", 5);
		controllerProduto.cadCardapio(produto);
		
		produto = new Produto(10, "Destilados", 20);
		controllerProduto.cadCardapio(produto);
	}
	
	public static void fazerPedido() {
		int comprarMais = -1;
		double vlr_total = 0;
		while(comprarMais < 0 || comprarMais >= 1) {
			pedido = new Pedido();
			comprarMais = -1;
			System.out.println("\n=== CARDÁPIO ===\n"+controllerProduto.exibirCardapio(produto));
			int retornoPedido = -1;
			while(retornoPedido < 1 || retornoPedido > 10) {			
				retornoPedido = viewPrincipal.tratamentoExceptionLerInt(retornoPedido, "Digite o numero do Prato ou da Bebida: ");
				if(retornoPedido < 1 || retornoPedido > 10) {
					System.out.println("\nEscolha um Prato ou Bebida que existe no Cárdapio!\n");
				}
			}			
			System.out.print("Informe a quantidade: ");
			int qnt = ler.nextInt();
			
			pedido.setProdutos(controllerProduto.procuraPratoPeloId(retornoPedido, qnt));
			//vlr_total = pedido.getProdutos().get(retornoPedido-1).getPreco();
			
			System.out.println("\nDeseja comprar mais um Prato ou Bedida?");
			System.out.println("0 - Não.");
			System.out.println("1 - Sim.");
			comprarMais = viewPrincipal.tratamentoExceptionLerInt(comprarMais, "Opção: ");
			if(comprarMais == 0) {
				pedido.setDia(11);
				pedido.setMes(04);
				pedido.setAno(2019);
				pedido.setVlr_total(vlr_total);
				pedido.setSenha(123);
				pedido.setStatus('A');
			
				System.out.println("Produtos: "+pedido.getProdutos());
				
				System.out.println("Valor Total: "+pedido.getVlr_total());
			
			}
		}
	}
	
	public static void ultimoPedido() {
		
	}
	
}
