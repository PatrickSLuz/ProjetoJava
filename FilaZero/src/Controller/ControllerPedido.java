package Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Model.Pedido;
import Model.Produto;

public class ControllerPedido {
	
	List<Pedido> listPedido = new ArrayList<Pedido>();
	
	public String pegarDataAtual() {
	    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    Date date = new Date();
	    return dateFormat.format(date);
	}
	
	public int incrementaSenha(Pedido pedido) {
		return pedido.getSenha()+1;
	}
	
	public void cancelarPedido(Pedido cancelPedido) {
		//list_produto_encontrado.remove(cancelPedido);
		//rever isso.
	}
	
	public void registraPedido(Pedido pedido){ 
		listPedido.add(pedido);
	}
	
	public List<Pedido> pegarPedidosStatus(String status) {
		List<Pedido> listPedidoStatus = new ArrayList<Pedido>();
		
		for(int i = 0;i < listPedido.size(); i++) {
			if(listPedido.get(i).getStatus().equals(status)) {
				listPedidoStatus.add(listPedido.get(i));
			}
		}
		return listPedidoStatus;
	}
	
	public List<Produto> criaListaComPratoSelecionado(int id, int qnt, List<Produto> listProdutos, List<Produto> listProdutosDaLista) {
		for (int x = 0; x < listProdutos.size(); x++) {
			if (listProdutos.get(x).getId() == id) {
				listProdutos.get(x).setQnt(qnt);
				listProdutosDaLista.add(listProdutos.get(x));
				break;
			}
		}
		return listProdutosDaLista;
	}
	
	public void criarPedido(Produto produtos, List<Produto> listProdutosDoPedido) {
		listProdutosDoPedido.add(produtos);
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
	
	public static void ultimoPedido() {
		
	}
	
	
	
}










