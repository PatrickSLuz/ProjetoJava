package controller;

import java.util.List;

import DAOImpl.LivroDAOImpl;
import bean.Livro;

public class LivroController {

	private Livro livro;
	private List<Livro> listaLivro;
	private LivroDAOImpl livroDAOImpl = new LivroDAOImpl();
	
	public LivroController() {
		if(livro == null) {
			livro = new Livro();
		}
	}
	
	public void salvarLivro() {
		livroDAOImpl.salvarLivro(livro);
		livro = new Livro();
	}
	
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Livro> getListaLivro() {
		this.listaLivro = livroDAOImpl.listarLivros();
		return listaLivro;
	}

	public void setListaLivro(List<Livro> listaLivro) {
		this.listaLivro = listaLivro;
	}
}
