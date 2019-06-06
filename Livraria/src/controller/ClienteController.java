package controller;

import java.util.List;

import DAOImpl.ClienteDAOImpl;
import bean.Cliente;

public class ClienteController {

	private Cliente cliente;
	private List<Cliente> listaClientes;
	private ClienteDAOImpl clienteDAOImpl= new ClienteDAOImpl();
	
	public ClienteController() {
		if(cliente == null) {
			cliente = new Cliente();
		}
	}

	public void salvarCliente() {
		clienteDAOImpl.salvarCliente(cliente);
		cliente = new Cliente();
	}
	
	public List<Cliente> listarClientes(){
		return clienteDAOImpl.listarClientes();
	}
	
	public void login() {
		if(cliente.getLogin().equals("adm") && cliente.getSenha().equals("adm")) {
			System.out.println("clienteController.login() - Logado com Sucesso ADM");
		}else {
			System.out.println("clienteController.login() - Falha no Login ADM");
			if(clienteDAOImpl.autenticar(cliente) ==  null) {
				System.out.println("clienteController.login() - Falha no Login Cliente");
			}else {
				System.out.println("clienteController.login() - Logado com Sucesso Cliente");
			}	
		}
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getListaClientes() {
		this.listaClientes = listarClientes();
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
}
