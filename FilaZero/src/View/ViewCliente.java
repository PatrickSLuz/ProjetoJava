package View;

import java.util.Scanner;

import Controller.ControllerCliente;
import Model.Cliente;
import Model.Endereco;

public class ViewCliente {

	static Scanner ler = new Scanner(System.in);
	
	static ControllerCliente controllerCliente = new ControllerCliente();
	
	static ViewPrincipal viewPrincipal = new ViewPrincipal();
	static ViewPedido viewPedido = new ViewPedido();
	
	static Cliente cliente;
	static Endereco endereco;
	
	public static void menuCliente() {
		int opcao = -1;
		while(opcao != 0) {
			opcao = -1;
			System.out.println("\n=== MENU CLIENTE ===");
			System.out.println("1 - Cadastro cliente.");
			System.out.println("2 - Login.");
			System.out.println("0 - Voltar.");
			opcao = viewPrincipal.tratamentoExceptionLerInt(opcao, "Opção: ");
			if (opcao == 1) {
				cadCliente();
			}else if (opcao == 2) {
				if(loginCliente()) {
					opcao = 0;
				}
			} else if (opcao != 0) {
				System.out.println("\nOpção Inválida!\n");
			}
		}
	}
	
	public static void cadCliente() {
		cliente = new Cliente();
		endereco = new Endereco();
		
		System.out.println("\n=== CADASTRO CLIENTE ===");
		System.out.print("Informe seu nome: ");
		String nome = ler.next();
		cliente.setNome(nome);
		System.out.print("Informe o seu RG: ");
		long rg = ler.nextLong();
		cliente.setRg(rg);
		System.out.print("Informe o seu CPF: ");
		long cpf = ler.nextLong();
		cliente.setCpf(cpf);
		System.out.print("Informe o telefone: ");
		String telefone = ler.next();
		cliente.setTelefone(telefone);
		System.out.print("Informe a sua rua: ");
		String rua = ler.next();
		endereco.setRua(rua);
		System.out.print("Informe o Nº da casa: ");
		int num = ler.nextInt();
		endereco.setNum(num);
		System.out.print("Informe o bairro: ");
		String bairro = ler.next();
		endereco.setBairro(bairro);
		cliente.setEndereco(endereco);
		System.out.print("Informe o login: ");
		String login = ler.next();
		cliente.setLogin(login);
		System.out.print("Informe a senha: ");
		String senha = ler.next();
		cliente.setSenha(senha);
		
		controllerCliente.cadCliente(cliente);
	}
	
	public static void editarDadosCliente() {
		cliente = new Cliente();
		endereco = new Endereco();
		
		System.out.println("\n=== EDITAR CLIENTE ===");
		System.out.print("Informe o telefone: ");
		cliente.setTelefone(ler.next());
		System.out.print("Informe a sua rua: ");
		endereco.setRua(ler.next());
		System.out.print("Informe o Nº da casa: ");
		endereco.setNum(ler.nextInt());
		System.out.print("Informe o bairro: ");
		endereco.setBairro(ler.next());
		
		cliente.setEndereco(endereco);
		
		System.out.print("Informe o login: ");
		cliente.setLogin(ler.next());
		System.out.print("Informe a senha: ");
		cliente.setSenha(ler.next());
		
		controllerCliente.cadCliente(cliente);
	}
	
	public static boolean loginCliente() {
		boolean logado = false;
		System.out.println("\n=== LOGIN CLIENTE ===");
		
		System.out.print("Login: ");
		String login = ler.next();
		System.out.print("Senha: ");
		String senha = ler.next();
		
		Cliente clienteLogado = controllerCliente.autenticarCliente(login, senha); 
		if(clienteLogado == null) {
			System.out.println("\nLogin ou senha Incorreto!");
		} else {
			System.out.println("\nLogado com sucesso!");
			logado = true;
			clienteLogado();
		}
		return logado;
	}
	
	public static void clienteLogado() {
		int escolha = -1;
		do {
			escolha = -1;
			System.out.println("\n=== ÁREA DO CLIENTE ===");
			System.out.println("1 - Fazer pedido.");
			System.out.println("2 - Repetir ultimo pedido.");
			System.out.println("3 - Alterar dados.");
			System.out.println("0 - Voltar para o Menu.");
			escolha = viewPrincipal.tratamentoExceptionLerInt(escolha, "Opção: ");
			switch (escolha) {
			case 1:
				viewPedido.fazerPedido();
				break;
			case 2:
				viewPedido.ultimoPedido();
				break;
			case 3:
				editarDadosCliente();
				break;
			default:
				System.out.println("\nOpção Inválida!\n");
				break;
			}
		}while(escolha!=0);
		
	}
	
}
