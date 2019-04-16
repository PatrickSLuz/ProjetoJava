package View;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Controller.ControllerProduto;
import Model.Produto;
import Model.Cliente;
import Model.Pedido;

public class ViewPedido {

	static Scanner ler = new Scanner(System.in);
	
	static ControllerProduto controllerProduto = new ControllerProduto();
	
	static Produto produto = new Produto();
	static Pedido pedido;
	
	static ViewPrincipal viewPrincipal = new ViewPrincipal();
	
	private static String pegarDataAtual() {
	    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    Date date = new Date();
	    return dateFormat.format(date);
	}
	
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
		
		produto = new Produto(8, "Água", 3);
		controllerProduto.cadCardapio(produto);
		
		produto = new Produto(9, "Suco Natural", 5);
		controllerProduto.cadCardapio(produto);
		
		produto = new Produto(10, "Destilados", 20);
		controllerProduto.cadCardapio(produto);
	}
	
	public static double exibirProdutosPedido(Pedido pedido) {
		int qnt;
		double preco_uni, preco_fin = 0;
		for(int i = 0; i < pedido.getProdutos().size(); i++) {
			qnt = pedido.getProdutos().get(i).getQnt();
			preco_uni = pedido.getProdutos().get(i).getPreco();
			preco_fin += qnt * preco_uni;
			System.out.println("\nNome: "+pedido.getProdutos().get(i).getPratoBebida());
			System.out.println("Quantidade: "+qnt);
			System.out.println("Preço Uni: "+preco_uni);
			System.out.println("Preço: "+preco_uni * qnt);
		}
		return preco_fin;
	}
	
	public static void fazerPedido(Cliente cliente_logado) {
		int comprarMais = -1;
		double vlr_total = 0;
		pedido = new Pedido();
		while(comprarMais < 0 || comprarMais >= 1) {
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
			
			pedido.setProdutos(controllerProduto.criaListaComPratoSelecionado(retornoPedido, qnt));
			
			System.out.println("\nDeseja comprar mais um Prato ou Bedida?");
			System.out.println("0 - Não.");
			System.out.println("1 - Sim.");
			comprarMais = viewPrincipal.tratamentoExceptionLerInt(comprarMais, "Opção: ");
			if(comprarMais == 0) {
				pedido.setData(pegarDataAtual());
				pedido.setVlr_total(vlr_total);
				pedido.setSenha("123");
				pedido.setStatus('A');
				pedido.setCliente(cliente_logado);
			
				vlr_total = exibirProdutosPedido(pedido);
				System.out.println("\nValor Total: "+vlr_total);
			}
		}
	}
	
	public static void ultimoPedido() {
		
	}
	
}
