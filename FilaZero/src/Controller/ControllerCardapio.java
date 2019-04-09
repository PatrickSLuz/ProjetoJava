package Controller;

import Model.Cardapio;

public class ControllerCardapio {
	
	public void cadCardapio(Cardapio cardapio) {
		cardapio.setIdPt1(1);
		cardapio.setPrato1("Salada Caesar");
		cardapio.setPreocoPt1(9.9);
		
		cardapio.setIdPt2(2);
		cardapio.setPrato2("Porção de Alcatra");
		cardapio.setPreocoPt2(35.9);
		
		cardapio.setIdPt3(3);
		cardapio.setPrato3("Bife Acebolado");
		cardapio.setPreocoPt3(15.5);
		
		cardapio.setIdPt4(4);
		cardapio.setPrato4("Feijoada");
		cardapio.setPreocoPt4(14.9);
		
		cardapio.setIdPt5(5);
		cardapio.setPrato5("Steak Tartare");
		cardapio.setPreocoPt5(65);
		
		cardapio.setIdBd1(6);
		cardapio.setBebida1("Refrigerante 1L");
		cardapio.setPreocoBd1(7);
		
		cardapio.setIdBd2(7);
		cardapio.setBebida2("Torre de Chop 2,5L");
		cardapio.setPreocoBd2(60);
		
		cardapio.setIdBd3(8);
		cardapio.setBebida3("Agua");
		cardapio.setPreocoBd3(3);
		
		cardapio.setIdBd4(9);
		cardapio.setBebida4("Suco Natual");
		cardapio.setPreocoBd4(5);
		
		cardapio.setIdBd5(10);
		cardapio.setBebida5("Destilados");
		cardapio.setPreocoBd5(20);
	}
	
	public Cardapio exibirCardapio(Cardapio cardapio) {	
		return cardapio;
	}
	
}
