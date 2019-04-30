package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Cliente;

public class ControllerCliente {

	List<Cliente> listCliente = new ArrayList<Cliente>();
	
	public void cadCliente(Cliente cliente) {
		listCliente.add(cliente);
	}
	
	public Cliente autenticarCliente(String login, String senha) {
		Cliente logado = null;
		for(int i =0; i < listCliente.size(); i++) {
			if(listCliente.get(i).getLogin().equals(login) && listCliente.get(i).getSenha().equals(senha)) {
				logado = listCliente.get(i);
				break;
			}
		}
		return logado;
	}
	
	public void alteraDadosCliente(Cliente cliente,String cpf) {
		for(int i = 0; i < listCliente.size(); i++) {
			if(listCliente.get(i).getCpf().equals(cpf)) {
				listCliente.get(i).setEndereco(cliente.getEndereco());
				listCliente.get(i).setSenha(cliente.getSenha());
				listCliente.get(i).setTelefone(cliente.getTelefone());
			}
		}
		
	}
	
	public boolean validarCad(String cpf, String login) {
		boolean validar = false;
		
		for (int i = 0; i < listCliente.size(); i++) {
			if(listCliente.get(i).getCpf().equals(cpf) && listCliente.get(i).getLogin().equals(login)) {
				validar = true;
			}
		}
		return validar;
	}
	
	public List<Cliente> listarCliente() {
		return listCliente;
	}
	
}
