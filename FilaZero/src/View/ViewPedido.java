package View;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import Controller.ControllerPedido;
import Controller.ControllerProduto;
import Model.Cliente;
import Model.Pedido;
import Model.Produto;

public class ViewPedido {

	static Scanner ler = new Scanner(System.in);
	
	static ControllerProduto controllerProduto = new ControllerProduto();
	static ControllerPedido controllerPedido = new ControllerPedido();
	
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
		
		produto = new Produto(8, "Água", 3);
		controllerProduto.cadCardapio(produto);
		
		produto = new Produto(9, "Suco Natural", 5);
		controllerProduto.cadCardapio(produto);
		
		produto = new Produto(10, "Destilados", 20);
		controllerProduto.cadCardapio(produto);
	}
	
	public static double exibirProdutosPedidoRetornaVlr(Pedido pedido) {
		int qnt;
		double preco_uni, preco_fin, vlr_total = 0;
		for(int i = 0; i < pedido.getProdutos().size(); i++) {
			qnt = pedido.getProdutos().get(i).getQnt();
			preco_uni = pedido.getProdutos().get(i).getPrecoUni();
			preco_fin = pedido.getProdutos().get(i).getPrecoFin();
			vlr_total += preco_fin;
			System.out.println("\nNome: "+pedido.getProdutos().get(i).getPratoBebida());
			System.out.println("Quantidade: "+qnt);
			System.out.println("Preço Uni: "+preco_uni);
			String fim = String.format("%.2f", preco_fin);
			System.out.println("Preço: "+fim);
			
		}
		return vlr_total;
	}
	
	public static void printarCardapio() {
		for (Produto produto : controllerProduto.exibirCardapio(produto)) {
			System.out.println("ID: "+produto.getId());
			System.out.println("Produto: "+produto.getPratoBebida());
			System.out.println("Preço unitário: "+produto.getPrecoUni()+"\n");
		}
	}	
	public static void fazerPedido(Cliente cliente_logado) {
		int comprarMais = -1;
		double vlr_total = 0;
		
		pedido = new Pedido();
		List<Produto> listProdutos = controllerProduto.retornaProdutos();
		List<Produto> listProdutosDaLista = new ArrayList<Produto>();
		
		while(comprarMais < 0 || comprarMais >= 1) {
			comprarMais = -1;
			System.out.println("\n=== CARDÁPIO ===\n");
			printarCardapio();
			int retornoPedido = -1;
			while(retornoPedido < 1 || retornoPedido > 10) {			
				retornoPedido = viewPrincipal.tratamentoExceptionLerInt(retornoPedido, "Digite o numero do Prato ou da Bebida: ");
				if(retornoPedido < 1 || retornoPedido > 10) {
					System.out.println("\nEscolha um Prato ou Bebida que existe no Cárdapio!\n");
				}
			}			
			System.out.print("Informe a quantidade: ");
			int qnt = ler.nextInt();
			
			System.out.println("\nDeseja comprar mais um Prato ou Bedida?");
			System.out.println("0 - Não.");
			System.out.println("1 - Sim.");
			comprarMais = viewPrincipal.tratamentoExceptionLerInt(comprarMais, "Opção: ");
			
			// setando os produtos selecionados na lista antes de perguntar se o user quer para de comprar.
			pedido.setProdutos(controllerPedido.criaListaComPratoSelecionado(retornoPedido, qnt, listProdutos, listProdutosDaLista));
			
			if(comprarMais == 0) {
				
				pedido.setData(controllerPedido.pegarDataAtual());
				pedido.setSenha(controllerPedido.incrementaSenha());
				pedido.setCliente(cliente_logado);
				vlr_total = exibirProdutosPedidoRetornaVlr(pedido);
				pedido.setVlr_total(vlr_total);
				
				if(pagamentoPedido(vlr_total)) {
					System.out.println("\nPedido Finalizado!");
					System.out.println("Sua senha é: "+pedido.getSenha());
					pedido.setStatus("P");
				}else {
					pedido.setStatus("C");
					System.out.println("\nPedido Cancelado!");
				}
				controllerPedido.registraPedido(pedido);
			}else if(comprarMais != 1) {
				System.out.println("\nOpção Inválida!\n");
			}
		}
	}
	
	public static boolean pagamentoPedido(double valor_total){
		boolean compraFinalizada = false;
		int op = -1;
			while (op != 0) {
			op = -1;
			String valorTroco = String.format("%.2f", valor_total);
			System.out.println("\nO valor Total a ser Pago é: R$ "+valorTroco);
	
			System.out.println("\nSelecione a forma de Pagamento:");
			System.out.println("1 - Cartão.");
			System.out.println("2 - Dinheiro.");
			System.out.println("0 - Desistir do Pedido.");
			op = viewPrincipal.tratamentoExceptionLerInt(op, "Opção: ");
	
			switch(op) {
			case 1:
				op = 0;
				compraFinalizada = true;
				break;
			case 2:
				double troco = 0;
				System.out.print("Insira o valor a ser pago: ");
				double valor_pago = ler.nextDouble();
				troco = controllerPedido.calcTroco(valor_total, valor_pago);
				if(troco < 0) {
					String troco_falt = String.format("%.2f", troco * (-1));
					System.out.println("\nEstá faltando: R$ "+troco_falt);
					op = -1;
				}else if(troco >= 0) {
					String trocoFim = String.format("%.2f", troco);
					System.out.println("Troco: R$ "+trocoFim);
					op = 0;
					compraFinalizada = true;
				}
				break;
			case 0:
				compraFinalizada = false;
				break;
			default:
				System.out.println("\nOpção Inválida!\n");
				break;
			}
		}
		return compraFinalizada;
	}
	
	public static void ultimoPedido(Cliente cliente_logado) {
		if(controllerPedido.ultimoPedido(cliente_logado) != null) {
			System.out.println("\nSeu ultimo pedido é:\n"
			+ controllerPedido.ultimoPedido(cliente_logado));
		}else {
			System.out.println("\nVocê não fez nenhum Pedido ainda!");
		}
	}
	
	public boolean verificarSenhaPedido(Cliente cliente, int senha){
		return controllerPedido.validarSenhaPedido(cliente, senha);
	}
	
	public static List<Pedido> procurarPedidoCliente(Cliente cliente) {
		return controllerPedido.verificarPedidoParaRetirar(cliente);
	}
	
	public static void attStatusPedidoCozinha(int senha) {
		controllerPedido.attStatusFinalizacaoCozinha(senha);
	}
	
}
