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
			System.out.println("3 - Restaurante.");
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
		
	
	public static void menuCliente() {
		System.out.println("\n=== MENU CLIENTE ===");
		System.out.println("1 - Cadastro cliente.");
		System.out.println("2 - Login.");
		System.out.println("0 - Voltar.");
		System.out.print("Opção: ");
		int opcao = ler.nextInt();
		
		if (opcao ==1) {
			cadCliente();
		}
		else if (opcao == 2) {
			loginCliente();
		}
		
		else if (opcao!=0) {
			System.out.println("\nOpção Inválida!\n");
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
		int rg = ler.nextInt();
		cliente.setRg(rg);
		System.out.print("Informe o seu CPF: ");
		int cpf = ler.nextInt();
		cliente.setCpf(cpf);
		System.out.print("Informe o telefone: ");
		String telefone = ler.next();
		cliente.setTelefone(telefone);
		System.out.print("Informe o nome da sua rua: ");
		String rua = ler.next();
		endereco.setRua(rua);
		System.out.print("Informe o Nº: ");
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
	
	public static void loginCliente() {
		
		System.out.println("\n=== LOGIN CLIENTE ===");
		System.out.print("Login: ");
		String login = ler.next();
		
		System.out.print("Senha: ");
		String senha = ler.next();
		
		if(controllerCliente.autenticarCliente(login, senha)==null) {
			System.out.println("Login ou senha incorretos!");
		}
		else {
			System.out.println("Logado com sucesso!!");
		}
	}
	
	public static void login(String setor, String entrar) {
		
		System.out.println("\n=== LOGIN "+setor+" ===");
		
		System.out.print("Login: ");
		String login = ler.next();
		System.out.print("Senha: ");
		String senha = ler.next();
		
		if(login == entrar && senha == entrar) {
			System.out.println("\n"+setor+ "Logado com sucesso!");
		}else {
			System.out.println("\n"+setor+" - Login ou senha errados!");
		}
		
	}
	
}










