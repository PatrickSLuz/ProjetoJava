package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import DAOImpl.ClienteDAOImpl;
import bean.Cliente;

public class ClienteController {

	private Cliente cliente;
	private String adm;
	private List<Cliente> listaClientes = new ArrayList<Cliente>();
	private ClienteDAOImpl clienteDAOImpl= new ClienteDAOImpl();
	
	private int tipo_usuario;
	// 0 = Não Logado
	// 1 = Cliente
	// 2 = ADM
	
	public ClienteController() {
		listarClientes();
		if(cliente == null) {
			cliente = new Cliente();
		}
	}

	public void salvarCliente() {
		clienteDAOImpl.salvarCliente(cliente);
		cliente = new Cliente();
	}
	
	public void excluir() {
		// Pegando o paramentro do <f:param>;
		Integer codigo = Integer.parseInt((String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codigo")); 
		clienteDAOImpl.excluir(codigo);
	}
	
	public void listarClientes(){
		System.out.println("Entrou em - ClienteController.listarClientes()");
		this.listaClientes = clienteDAOImpl.listarClientes();
		//return clienteDAOImpl.listarClientes();
	}
	
	public void buscarCliente(){
		System.out.println("Entrou em - ClienteController.buscarCliente()");
		this.listaClientes = clienteDAOImpl.buscarClientes(cliente.getNome());
		//return clienteDAOImpl.buscarClientes(nome);
	}
	
	public void login() {
		if(cliente.getLogin().equals("adm") && cliente.getSenha().equals("adm")) {
			System.out.println("clienteController.login() - Logado com Sucesso ADM");
			adm = "Administrador";
			tipo_usuario = 2;
		}else {
			System.out.println("clienteController.login() - Falha no Login ADM");
			cliente = clienteDAOImpl.autenticar(cliente);
			if(cliente ==  null) {
				System.out.println("clienteController.login() - Falha no Login Cliente");
			}else {
				System.out.println("clienteController.login() - Logado com Sucesso Cliente");
				tipo_usuario = 1;
				System.out.println("Nome: "+ cliente.getNome()+
						"RG: "+cliente.getRg()+
						"CPF: "+cliente.getCpf()+
						"Login: "+cliente.getLogin()+
						"Senha: "+cliente.getSenha());
			}	
		}
	}
	
	public void logout() throws IOException {
		cliente = new Cliente();
		tipo_usuario = 0;
		FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		System.out.println("Após Redirecionar - Logout();");
		System.out.println("Nome: "+ cliente.getNome()+
				"RG: "+cliente.getRg()+
				"CPF: "+cliente.getCpf()+
				"Login: "+cliente.getLogin()+
				"Senha: "+cliente.getSenha());
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	public int getTipo_usuario() {
		return tipo_usuario;
	}
	public void setTipo_usuario(int tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}
	public String getAdm() {
		return adm;
	}
	public void setAdm(String adm) {
		this.adm = adm;
	}
}
