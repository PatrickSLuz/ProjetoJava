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
		Cliente logado=null;
		for(int i =0; i < listCliente.size() ; i++) {
			if(listCliente.get(i).getLogin().equals(login) && listCliente.get(i).getSenha().equals(senha)) {
				logado = listCliente.get(i);
				break;
			}
		}
		return logado;
	}
	
}
