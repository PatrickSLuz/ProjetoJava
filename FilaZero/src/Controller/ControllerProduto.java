package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Produto;
import Model.Pedido;

public class ControllerProduto {
	
	
	List<Produto> listProdutos = new ArrayList<Produto>();
	
	
	public void cadCardapio(Produto cardapio) {
		listProdutos.add(cardapio);
	}
	
	public List<Produto> exibirCardapio(Produto cardapio) {	
		return listProdutos;
	}
	
	
	
}
