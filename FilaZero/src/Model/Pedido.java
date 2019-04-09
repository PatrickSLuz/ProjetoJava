package Model;

public class Pedido {
	private String nomeDoPrato,nomeDaBebida;
	private int precoPrato, precoBebida, dia, mes, ano, senha;

	public String getNomeDoPrato() {
		return nomeDoPrato;
	}

	public void setNomeDoPrato(String nomeDoPrato) {
		this.nomeDoPrato = nomeDoPrato;
	}

	public String getNomeDaBebida() {
		return nomeDaBebida;
	}

	public void setNomeDaBebida(String nomeDaBebida) {
		this.nomeDaBebida = nomeDaBebida;
	}

	public int getPrecoPrato() {
		return precoPrato;
	}

	public void setPrecoPrato(int precoPrato) {
		this.precoPrato = precoPrato;
	}

	
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}
	

	public int getPrecoBebida() {
		return precoBebida;
	}

	public void setPrecoBebida(int precoBebida) {
		this.precoBebida = precoBebida;
	}

	public String toString() {
		return "\nNome do prato:"+this.nomeDoPrato+"\n Preço do prato: "+this.precoPrato+"\nBebida"+this.nomeDaBebida+"\nPreço da bebida: "+this.precoBebida+"\n Data: "+this.dia+this.mes+this.ano+"\nSenha:"+this.senha;
	}
}














