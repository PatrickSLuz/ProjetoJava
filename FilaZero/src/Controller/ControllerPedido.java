package Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Model.Cliente;
import Model.Pedido;
import Model.Produto;

public class ControllerPedido {
		
	List<Pedido> listPedido = new ArrayList<Pedido>();
	
	// Metodo para pegar a Data da maquina, com o formato escolhido;
	public String pegarDataAtual() {
	    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    Date date = new Date();
	    return dateFormat.format(date);
	}
	
	// Metodo para retornar os pedidos filtrando pelo STATUS
	public List<Pedido> retornaPedidosConformeStatus(String status){
		List<Pedido> listPedidoConformeStatus = new ArrayList<>();
		for (Pedido pedido : listPedido) {
			if(pedido.getStatus().equals(status)) {
				listPedidoConformeStatus.add(pedido);
			}
		}
		return listPedidoConformeStatus;
	}
	
	public boolean validarSenhaPedido(Cliente cliente, int senha) {
		boolean senha_correta = false;
		for (Pedido pedido : listPedido) {
			if(pedido.getCliente().getCpf().equals(cliente.getCpf()) && pedido.getSenha() == senha) {
				pedido.setStatus("E"); // "E" = Pedido Entrege/Retirado;
				senha_correta = true;
				break;
			}
		}
		return senha_correta;
	}
	
	// Metodo para verificar se o cliente que se logou no sistema tem algum Pedido Finlizado pela Cozinha
	// Para que possa retira-lo;
	public List<Pedido> verificarPedidoParaRetirar(Cliente cliente){
		List<Pedido> listPedidosParaRetirar = new ArrayList<>();
		for (Pedido pedido : listPedido) {
			if(pedido.getCliente().getCpf().equals(cliente.getCpf()) && pedido.getStatus().equals("F")) {
				listPedidosParaRetirar.add(pedido);
			}
		}
		return listPedidosParaRetirar;
	}
	
	// Metodo para mudar o Status do Pedido de "P"/Pendente (Pago) para "F"/Finalizado, para que o cliente possa retira-lo; 
	public void attStatusFinalizacaoCozinha(int senha) {
		for (Pedido pedido : listPedido) {
			if(pedido.getSenha() == senha) {
				pedido.setStatus("F");
				break;
			}
		}
	}
	
	// Metodo para incrementar a Senha do Pedido;
	// Ele faz 100 + a quantidade de Pedidos;
	public int incrementaSenha() {
		return 100 + listPedido.size();
	}
	
	public void registraPedido(Pedido pedido){ 
		listPedido.add(pedido);
	}
	
	public List<Pedido> retornaListaPedido(){
		return listPedido;
	}
	
	// Metodo para inserir os produtos selecionados no Pedido em uma lista e retornar essa lista;
	// Junto ele grava a quantidade escolhida e faz os calculos de sub total do Produto (quantida x valor unitario);
	public List<Produto> criaListaComPratoSelecionado(int id, int qnt, List<Produto> listProdutos, List<Produto> listProdutosDoPedido) {
		double preco_fin;
		for (int x = 0; x < listProdutos.size(); x++) {
			if (listProdutos.get(x).getId() == id) {
				listProdutos.get(x).setQnt(qnt);
				preco_fin = qnt*listProdutos.get(x).getPrecoUni();
				listProdutos.get(x).setPrecoFin(preco_fin);
				listProdutosDoPedido.add(listProdutos.get(x));
				break;
			}
		}
		return listProdutosDoPedido;
	}

	public static double calcTroco(double valor_total, double valor_pago) {
		double troco = 0;
		
		if(valor_pago == valor_total) {
			
		}else if (valor_pago > valor_total) {
			troco = valor_pago - valor_total;
		}else {
			troco = valor_pago - valor_total; 
		}
		return troco;
	}
	
	// Metodo para pegar o ultimo pedido realizado por um Cliente;
	public Pedido ultimoPedido(Cliente cliente_logado) {
		Pedido ult_pedido = null;
		int tamanho_lista = listPedido.size();
		// Laço de repetição Decrementando para pegar do ultimo Pedido gravado ao primeiro;
		// Para trazer o Pedido mais recente do Cliente;
		for (int i = tamanho_lista-1; i >= 0; i--) {
			if(listPedido.get(i).getCliente().getCpf().equals(cliente_logado.getCpf())) {
				ult_pedido = listPedido.get(i);
				break;
			}
		}
		return ult_pedido;
	}	
}
