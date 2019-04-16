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
	List<Produto> listProdutos = new ArrayList<Produto>();
	List<Produto> list_produto_encontrado = new ArrayList<Produto>();
	
	public String pegarDataAtual() {
	    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    Date date = new Date();
	    return dateFormat.format(date);
	}
	
	public void cancelarPedido(Pedido cancelPedido) {
		list_produto_encontrado.remove(cancelPedido);
	}
	
	public void registraPedido(Pedido pedido){ 
		listPedido.add(pedido);
	}
	
	public List<Produto> criaListaComPratoSelecionado(int id, int qnt) {
		for (int x = 0; x < listProdutos.size(); x++) {
			if (listProdutos.get(x).getId() == id) {
				listProdutos.get(x).setQnt(qnt);
				list_produto_encontrado.add(listProdutos.get(x));
				break;
			}
		}
		return list_produto_encontrado;
	}
	
	public void criarPedido(Produto produtos) {
		listProdutos.add(produtos);
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
	
}
