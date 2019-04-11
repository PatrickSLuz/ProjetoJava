package Model;

public class Produto {
	
	private int id, qnt;
	private String pratoBebida;
	private double preco;
	
		
	public Produto() {
		
	}
		
	public Produto(int id, String pratoBebida, double preco) {
		this.id = id;
		this.pratoBebida = pratoBebida;
		this.preco = preco;
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "\nPrato "+this.id+":\n"+
				"Nome: "+this.pratoBebida+"\n"+
				"Preço: R$ "+this.preco+"\n";
	}
	
}

