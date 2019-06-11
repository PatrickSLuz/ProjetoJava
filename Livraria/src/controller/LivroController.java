package controller;

import java.util.ArrayList;
import java.util.List;

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
	
	public void salvarLivro() {
		livroDAOImpl.salvarLivro(livro);
		livro = new Livro();
	}
	
	public void buscarLivro() {
		System.out.println("Entrou em - LivroController.buscarLivro()");
		this.listaLivros = livroDAOImpl.buscarLivros(livro.getNomeLivro());
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
