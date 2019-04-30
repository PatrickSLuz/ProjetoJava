package View;

import java.util.List;
import java.util.Scanner;

import Controller.ControllerCliente;
import Model.Cliente;
import Model.Endereco;
import Model.Pedido;

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
		String rg = ler.next();
		cliente.setRg(rg);
		System.out.print("Informe o seu CPF: ");
		String cpf = ler.next();
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
		
		if(controllerCliente.validarCad(cpf, login)) {
			System.out.println("CPF ou Login já cadastrado");
		}else {
			controllerCliente.cadCliente(cliente);
		}
		
	}
	
	public static void editarDadosCliente(Cliente cliente_logado) {
		endereco = new Endereco();
		
		System.out.println("\n=== EDITAR CLIENTE ===");
		System.out.print("Informe o telefone: ");
		cliente_logado.setTelefone(ler.next());
		System.out.print("Informe a sua rua: ");
		endereco.setRua(ler.next());
		System.out.print("Informe o Nº da casa: ");
		endereco.setNum(ler.nextInt());
		System.out.print("Informe o bairro: ");
		endereco.setBairro(ler.next());
		
		cliente_logado.setEndereco(endereco);
		
		System.out.print("Informe a senha: ");
		cliente_logado.setSenha(ler.next());
		
		controllerCliente.alteraDadosCliente(cliente_logado, cliente_logado.getCpf());
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
			clienteLogado(clienteLogado);
		}
		return logado;
	}
	
	public static void clienteLogado(Cliente cliente_logado) {
		int escolha = -1;
		do {
			escolha = -1;
			System.out.println("\n=== ÁREA DO CLIENTE ===");
			System.out.println("1 - Fazer pedido.");
			System.out.println("2 - Verificar se o Pedido está Finalizado.");
			System.out.println("3 - Repetir ultimo pedido.");
			System.out.println("4 - Alterar dados.");
			System.out.println("5 - Ver meus dados");
			System.out.println("0 - Logout Cliente.");
			escolha = viewPrincipal.tratamentoExceptionLerInt(escolha, "Opção: ");
			switch (escolha) {
			case 1:
				viewPedido.fazerPedido(cliente_logado);
				break;
			case 2:
				System.out.println(viewPedido.procurarPedidoCliente(cliente_logado));
				System.out.print("Digite a senha do Pedido: ");
				int senha = ler.nextInt();
				if(viewPedido.verificarSenhaPedido(cliente_logado, senha)) {
					System.out.println("Senha Correta!\nPedido Retirado!");
				}else {
					System.out.println("Senha incorreta! Tente novamente.");
				}
				break;
			case 3:
				viewPedido.ultimoPedido(cliente_logado);
				break;
			case 4:
				editarDadosCliente(cliente_logado);
				break;
			case 5:
				System.out.println(cliente_logado);
				break;
			case 0:
				break;
			default:
				System.out.println("\nOpção Inválida!\n");
				break;
			}
		}while(escolha!=0);
		
	}
	
	public static void exibirCliente() {
		System.out.println(controllerCliente.listarCliente());
	}
	
}










