package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Produto;
import Model.Pedido;

public class ControllerProduto {
	
	List<Pedido> listPedidoComidas = new ArrayList<Pedido>();
	List<Produto> listProdutos = new ArrayList<Produto>();
	List<Produto> list_produto_encontrado = new ArrayList<Produto>();
	
	public void cadCardapio(Produto cardapio) {
		listProdutos.add(cardapio);
	}
	
	public List<Produto> exibirCardapio(Produto cardapio) {	
		return listProdutos;
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
	
}
