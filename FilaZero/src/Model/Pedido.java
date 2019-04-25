package Model;

import java.util.List;

public class Pedido {
	private List<Produto> produtos;
	private String status;
	private int senha;
	private String data;
	private double vlr_total;
	private Cliente cliente;
	
	public Pedido() {
		
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getVlr_total() {
		return vlr_total;
	}

	public void setVlr_total(double vlr_total) {
		this.vlr_total = vlr_total;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public String verificaStatus() {
		String status = this.status;
		if(status.equals("A")) {
			status = "Aberto";
		}else if(status.equals("P")) {
			status = "Pendente";
		}else if(status.equals("E")) {
			status = "Entrege";
		}else {
			status = "Cancelado";
		}
		return status;
	}
	
	public String toString() {
		return "\nStatus: "+verificaStatus()
				+ "\nData: "+this.data
				+ "\nCliente: "
				+ "\n Nome: "+cliente.getNome()
				+ "\n CPF: "+cliente.getCpf()
				+ "\nProdutos: "+produtos.toString()
				+ "\nSenha: "+this.senha;
	}
}














