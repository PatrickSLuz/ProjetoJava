package View;

import java.util.Scanner;

import Controller.ControllerCliente;
import Model.Cliente;
import Model.Endereco;

public class Pincipal {
	
	static Scanner ler = new Scanner(System.in);
	static ControllerCliente controllerCliente = new ControllerCliente();
	static Cliente cliente;
	static Endereco endereco;
	
	public static void main(String[] args) {

		menu();

	}
	
	public static void menu() {
		int op = -1;
		do {
			System.out.println("\n=== MENU ===");
			System.out.println("1 - Cliente.");
			System.out.println("2 - Administrador.");
			System.out.println("3 - Cozinha.");
			System.out.println("0 - Sair.");
			System.out.print("Opção: ");
			op = ler.nextInt();
			switch (op) {
			case 1:
				menuCliente();
				break;
			case 2: 
				login("ADM", "adm");
				break;
			case 3:
				login("COZINHA", "coz");
				break;
			case 0:
				op = 0;
				break;
			default:
				System.out.println("\nOpção Inválida!\n");
				break;
			}
		} while(op!=0);
	}
		
	public static void cadRestaurante() {
		
	}
	
	public static void menuCliente() {
		int opcao = -1;
		while(opcao != 0) {
			System.out.println("\n=== MENU CLIENTE ===");
			System.out.println("1 - Cadastro cliente.");
			System.out.println("2 - Editar dados.");
			System.out.println("3 - Login.");
			System.out.println("0 - Voltar.");
			System.out.print("Opção: ");
			opcao = ler.nextInt();
			
			if (opcao == 1) {
				cadCliente();
			}else if (opcao == 3) {
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
		}
		return logado;
	}
	
	public static void login(String setor, String entrar) {
		
		System.out.println("\n=== LOGIN "+setor+" ===");
		
		System.out.print("Login: ");
		String login = ler.next();
		System.out.print("Senha: ");
		String senha = ler.next();
		
		if(login.equals(entrar) && senha.equals(entrar)) {
			System.out.println("\n"+setor+ " Logado com Sucesso!");
		}else {
			System.out.println("\n"+setor+" - Login ou Senha Incorreto!");
		}
		
	}
	
}










