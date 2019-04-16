package Model;

public class Endereco {

	private String rua;
	private String bairro;
	private int num;
	
	public Endereco() {
		
	}
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public String toString() {
		return "\n Rua: "+this.rua+"\n Bairro: "+this.bairro+"\n Numero: "+this.num;
	}
	
}
