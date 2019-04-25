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
	
	public String pegarDataAtual() {
	    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    Date date = new Date();
	    return dateFormat.format(date);
	}
	
	public int incrementaSenha() {
		return 100 + listPedido.size();
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
		double preco_fin;
		for (int x = 0; x < listProdutos.size(); x++) {
			if (listProdutos.get(x).getId() == id) {
				listProdutos.get(x).setQnt(qnt);
				preco_fin = qnt*listProdutos.get(x).getPrecoUni();
				listProdutos.get(x).setPrecoFin(preco_fin);
				listProdutosDaLista.add(listProdutos.get(x));
				break;
			}
		}
		return listProdutosDaLista;
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
	
	public Pedido ultimoPedido(Cliente cliente_logado) {
		Pedido ult_pedido = null;
		int tamanho_lista = listPedido.size();
		for (int i = tamanho_lista-1; i >= 0; i--) {
			if(listPedido.get(i).getCliente().getCpf().equals(cliente_logado.getCpf())) {
				ult_pedido = listPedido.get(i);
				break;
			}
		}
		return ult_pedido;
	}
	
	
	
}










