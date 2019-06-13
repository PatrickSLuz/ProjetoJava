package DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import DAO.DAO;
import DAO.LivroDAO;
import bean.Livro;

public class LivroDAOImpl extends DAO implements LivroDAO{

	EntityManager em;
	
	@Override
	public void salvarLivro(Livro livro) {
		System.out.println("Entro em - LivroDAOImpl.salvarLivro()");		
		em = getEntityManager();
		try {
			if(livro.getCodigo()==null) {
				System.out.println("Entrou no IF - sem codigo - Livro Novo");
				em.getTransaction().begin(); // Abre a transação com o BD;
				System.out.println("Deopis do - em.getTransaction().begin()");
				em.persist(livro); // Persiste um objeto no Banco;
				System.out.println("Deopis do - em.persist(livro);");
				em.getTransaction().commit(); // Confirma/Comita a execução anterior;
				System.out.println("Deopis do - em.getTransaction().commit();");
			}else {
				System.out.println("Entrou no Else - com codigo - Livro existente");
				em.getTransaction().begin(); // Abre a transação com o BD;
				em.merge(livro); // Atualiza um objeto no Banco;
				em.getTransaction().commit(); // Confirma/Comita a execução anterior;
			}
		} catch(Exception e) {
			System.out.println("Entro em Catch - LivroDAOImpl.salvarLivro()");
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}		
	}
	
	public Livro editarLivro(Integer codigo) {
		em = getEntityManager();
		return em.find(Livro.class, codigo);
	}
	
	public void excluirLivro(Integer codigo) {
		System.out.println("Entrou em - LivroDAOImpl.excluirLivro()");
		em = getEntityManager();
		em.getTransaction().begin();
		Livro li = em.find(Livro.class, codigo); // faz uma busca no banco pelo codigo;
		em.remove(li);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Livro> buscarLivros(String nomeLivro){
		System.out.println("Entrou em - LivroDAOImpl.buscarLivros()");
		em = getEntityManager();
		Query q = em.createQuery("select l from Livro l where l.nomeLivro like :pnomeLivro");
		try {
			System.out.println("Entrou no try em - LivroDAOImpl.buscarLivros()");
			q.setParameter("pnomeLivro", "%"+nomeLivro+"%");
		} catch(Exception e) {
			System.out.println("Entrou no catch em - LivroDAOImpl.buscarLivros()");
			e.printStackTrace();
		} finally {
			System.out.println("Entrou no finally em - LivroDAOImpl.buscarLivros()");
			//em.close();
		}
		return q.getResultList();
	}
	
	public List<Livro> listarLivros(){
		em = getEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select object(l) from Livro as l");
		return q.getResultList();
	}

}

