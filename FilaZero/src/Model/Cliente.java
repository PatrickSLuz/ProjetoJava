package Model;

public class Cliente {

	private String nome;
	private String rg;
	private String cpf;
	private Endereco endereco;
	private String telefone;
	private String login;
	private String senha;
	
	public Cliente() {
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String toString() {
		return "\nNome: "+this.nome+"\nRG: "+this.rg+"\nCPF: " +this.cpf+"\n Endereço: "+this.endereco+"\n Telefone: "+this.telefone+"\n Login: "+this.login+"\n Senha"+this.senha;
	}
	
}
