package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import DAOImpl.LivroDAOImpl;
import bean.Livro;

public class LivroController {

	private Livro livro;
	private List<Livro> listaLivros = new ArrayList<Livro>();
	private LivroDAOImpl livroDAOImpl = new LivroDAOImpl();
	
	public LivroController() {
		listarLivros();
		if(livro == null) {
			livro = new Livro();
		}
	}
	
	public void salvarLivro() throws IOException {
		System.out.println("Antes LivroController.salvarLivro() - livroDAOImpl.salvarLivro(livro);");
		livroDAOImpl.salvarLivro(livro);
		System.out.println("Depois LivroController.salvarLivro() - livroDAOImpl.salvarLivro(livro);");
		livro = new Livro();
		System.out.println("Antes LivroController.salvarLivro() - listarLivros()");
		listarLivros();
		System.out.println("Depois LivroController.salvarLivro() - listarLivros()");
		FacesContext.getCurrentInstance().getExternalContext().redirect("GerenciaLivro.xhtml");
	}
	
	public void buscarLivro() {
		System.out.println("Entrou em - LivroController.buscarLivro()");
		this.listaLivros = livroDAOImpl.buscarLivros(livro.getNomeLivro());
	}
	
	public void editarLivro() throws IOException {
		System.out.println("Entrou em - LivroController.editarLivro()");
		// Pegando o paramentro do <f:param>;
		Integer codigo = Integer.parseInt((String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codigo"));
		livro = livroDAOImpl.editarLivro(codigo);
		FacesContext.getCurrentInstance().getExternalContext().redirect("CadastroLivro.xhtml");
	}
	
	public void excluir() {
		System.out.println("Entrou em - LivroController.excluir()");
		// Pegando o paramentro do <f:param>;
		Integer codigo = Integer.parseInt((String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codigo"));
		livroDAOImpl.excluirLivro(codigo);
		listarLivros();
	}
	
	public void listarLivros() {
		this.listaLivros = livroDAOImpl.listarLivros();
	}
	
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Livro> getListaLivros() {
		return listaLivros;
	}

	public void setListaLivros(List<Livro> listaLivros) {
		this.listaLivros = listaLivros;
	}
}
