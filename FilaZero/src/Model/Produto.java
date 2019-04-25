package Model;

public class Produto {
	
	private int id, qnt;
	private String pratoBebida;
	private double precoUni;
	private double precoFin;
	
		
	public Produto() {
		
	}
		
	public Produto(int id, String pratoBebida, double precoUni) {
		this.id = id;
		this.pratoBebida = pratoBebida;
		this.precoUni = precoUni;
	}
	
	
	public double getPrecoFin() {
		return precoFin;
	}

	public void setPrecoFin(double precoFin) {
		this.precoFin = precoFin;
	}

	public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPratoBebida() {
		return pratoBebida;
	}

	public void setPratoBebida(String pratoBebida) {
		this.pratoBebida = pratoBebida;
	}

	public double getPrecoUni() {
		return precoUni;
	}

	public void getPrecoUni(double precoUni) {
		this.precoUni = precoUni;
	}

	public String imprimeTudoProduto() {
		return "\nPrato "+this.id+":\n"+
				"Nome: "+this.pratoBebida+"\n"+
				"Quantidade: "+this.qnt+"\n"+
				"Preço Uni: R$ "+this.precoUni+"\n"+
				"Preco Fin: R$ "+this.precoFin+"\n";
	}
	
	@Override
	public String toString() {
		return "\nPrato "+this.id+":\n"+
				"Nome: "+this.pratoBebida+"\n"+
				"Preço Uni: R$ "+this.precoUni+"\n";
	}
	
}

