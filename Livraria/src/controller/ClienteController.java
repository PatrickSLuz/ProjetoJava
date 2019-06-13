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
	
	private boolean editaCliente = false;
	private int tipo_usuario = 0;
	// 0 = Não Logado
	// 1 = Cliente
	// 2 = ADM
	
	public ClienteController() {
		listarClientes();
		if(cliente == null) {
			cliente = new Cliente();
		}
	}

	public void imprimirClienteNoConsole() {
		System.out.println("Nome: "+ cliente.getNome()+
				" RG: "+cliente.getRg()+
				" CPF: "+cliente.getCpf()+
				" Login: "+cliente.getLogin()+
				" Senha: "+cliente.getSenha());
	}
	
	public void salvarCliente() throws IOException {
		System.out.println("Entrou em - ClienteController.salvarCliente()");
		System.out.println("Boolean p/ editar Cliente - "+editaCliente);
		System.out.println("Tipo de Usuario Logado - "+tipo_usuario);
		clienteDAOImpl.salvarCliente(cliente);
		listarClientes();
		if (tipo_usuario == 2) {
			cliente = new Cliente(); // para poder salvar outro cliente depois
			FacesContext.getCurrentInstance().getExternalContext().redirect("GerenciaCliente.xhtml");
		}else if (tipo_usuario == 1) {
			imprimirClienteNoConsole();
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		}else {
			cliente = new Cliente(); // para poder salvar outro cliente depois
			FacesContext.getCurrentInstance().getExternalContext().redirect("Login.xhtml");
		}
	}
	
	public void editarCliente() throws IOException {
		this.editaCliente = true;
		System.out.println("Entrou em - ClienteController.editarCliente()");
		System.out.println("Boolean p/ editar Cliente - "+editaCliente);
		System.out.println("clienteController.editarCliente() - Antes redirecionar p/ CadastroCliente.xhtml");
		FacesContext.getCurrentInstance().getExternalContext().redirect("CadastroCliente.xhtml");
		System.out.println("clienteController.editarCliente() - Depois redirecionar p/ CadastroCliente.xhtml");
	}
	
	public void excluir() {
		// Pegando o paramentro do <f:param>;
		Integer codigo = Integer.parseInt((String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codigo")); 
		clienteDAOImpl.excluir(codigo);
		listarClientes();
	}
	
	public void listarClientes(){
		System.out.println("Entrou em - ClienteController.listarClientes()");
		this.listaClientes = clienteDAOImpl.listarClientes();
		//return clienteDAOImpl.listarClientes();
	}
	
	public void buscarCliente(){
		System.out.println("Entrou em - ClienteController.buscarCliente()");
		this.listaClientes = clienteDAOImpl.buscarClientes(cliente.getNome());
	}
	
	public String login() {
		String retorno = "erro";
		if(cliente.getLogin().equals("adm") && cliente.getSenha().equals("adm")) { // se for Administrador
			System.out.println("clienteController.login() - Logado com Sucesso ADM");
			adm = "Administrador";
			tipo_usuario = 2;
			cliente = new Cliente(); // Para que o adm possa inserir um novo cliente;
			retorno = "index";
		}else { // se for Cliente
			System.out.println("clienteController.login() - Falha no Login ADM");
			cliente = clienteDAOImpl.autenticar(cliente);
			if(cliente ==  null) {
				System.out.println("clienteController.login() - Falha no Login Cliente");
				cliente = new Cliente(); // para a proxima comparação não dar pau  - pois o cliente esta nullo e não consegue receber o resultado da query;  
			}else {
				System.out.println("clienteController.login() - Logado com Sucesso Cliente");
				tipo_usuario = 1;
				imprimirClienteNoConsole();
				retorno = "index";
			}	
		}
		return retorno;
	}
	
	public String logout(){
		cliente = new Cliente();
		tipo_usuario = 0;
		this.editaCliente = false;
		imprimirClienteNoConsole();
		return "index";
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
	public boolean isEditaCliente() {
		return editaCliente;
	}
	public void setEditaCliente(boolean editaCliente) {
		this.editaCliente = editaCliente;
	}
}
